package hcm.ptit.trainingpoint.service.impl;

import hcm.ptit.trainingpoint.util.Const;
import hcm.ptit.trainingpoint.model.dto.DataMailDTO;
import hcm.ptit.trainingpoint.model.dto.sdi.ClientSdi;
import hcm.ptit.trainingpoint.service.MailService;
import hcm.ptit.trainingpoint.service.ClientService;
import hcm.ptit.trainingpoint.util.DataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    private MailService mailService;

    @Override
    public Boolean create(ClientSdi sdi) {
        try {
            DataMailDTO dataMail = new DataMailDTO();

            dataMail.setTo(sdi.getEmail());
            dataMail.setSubject(Const.SEND_MAIL_SUBJECT.CLIENT_REGISTER);

            Map<String, Object> props = new HashMap<>();
            props.put("name", sdi.getName());
            props.put("username", sdi.getUsername());
            props.put("password", DataUtil.generateTempPwd(6));
            dataMail.setProps(props);

            mailService.sendHtmlMail(dataMail, Const.TEMPLATE_FILE_NAME.CLIENT_REGISTER);
            return true;
        } catch (MessagingException exp){
            exp.printStackTrace();
        }
        return false;
    }
}