package vnu.uet.trainingpoint.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.ui.Model;
import vnu.uet.trainingpoint.service.ConsultantService;
import vnu.uet.trainingpoint.service.SemesterService;
import vnu.uet.trainingpoint.service.StudentService;
import vnu.uet.trainingpoint.service.UserService;
import vnu.uet.trainingpoint.util.JwtUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Configuration
public class CustomLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    public static String sessionFullName;
    public static String sessionUsername;


    @Autowired
    private JwtUtil jwtTokenUtil;

    public static String jwt;

    private StudentService studentService;

    private ConsultantService consultantService;

    private UserService userService;

    private SemesterService semesterService;

    @Autowired
    public void setSemesterService(SemesterService semesterService) {
        this.semesterService = semesterService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setConsultantService(ConsultantService consultantService) {
        this.consultantService = consultantService;
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        String targetUrl = determineTargetUrl(authentication);
        if (response.isCommitted()) {
            return;
        }

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        jwt = jwtTokenUtil.generateToken(userDetails);
//        System.out.println(jwt);

        String fullName = "";

        String username = userDetails.getUsername();

        if (Objects.requireNonNull(userService.findByUsername(username).getBody()).getRoles().equals("ROLE_CONSULTANT")) {
            fullName = consultantService.getNameByUsername(username);
        } else if (Objects.requireNonNull(userService.findByUsername(username).getBody()).getRoles().equals("ROLE_ADMIN")) {
            fullName = "admin";
        } else {
            fullName = studentService.findByUsername(username).getFullName();
        }

        sessionFullName=fullName;
        sessionUsername= username;

        HttpSession session= request.getSession();
        session.setAttribute("username", username);
        session.setAttribute("fullName", fullName);

        if(semesterService.findBySemesterNo(194).isPresent()){
            System.setProperty("cache.deadline", semesterService.getDeadline(194));
        }else{
            System.setProperty("cache.deadline", "Hiiện tại chưa có kỳ đánh giá nào");
        }

        RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }


    protected String determineTargetUrl(Authentication authentication) {
        String url = "login?error=true";
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        List<String> roles = new ArrayList<>();

        for (GrantedAuthority a : authorities) {
            roles.add(a.getAuthority());
        }

        if (roles.contains("ROLE_ADMIN")) {
            url = "/admin";
        } else if (roles.contains("ROLE_CONSULTANT")) {
            url = "/consultant";
        } else if (roles.contains("ROLE_STUDENT")) {
            url = "/student";
        } else if (roles.contains("ROLE_PRESIDENT")) {
            url = "/monitor";
        }
        return url;
    }
}
