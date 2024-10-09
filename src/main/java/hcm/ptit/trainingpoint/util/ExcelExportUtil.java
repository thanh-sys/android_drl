package hcm.ptit.trainingpoint.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import hcm.ptit.trainingpoint.enitty.EvaluationForm;
import hcm.ptit.trainingpoint.enitty.MyUserDetails;
import hcm.ptit.trainingpoint.enitty.TrainingResultsSummary;
import hcm.ptit.trainingpoint.model.dto.InputDTO;
import hcm.ptit.trainingpoint.service.ClassesService;
import hcm.ptit.trainingpoint.service.ConsultantService;
import hcm.ptit.trainingpoint.service.EvaluationFormService;
import hcm.ptit.trainingpoint.service.StudentService;

import org.apache.poi.ss.util.CellRangeAddress;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class ExcelExportUtil {

	private XSSFWorkbook workbook;
	private XSSFSheet sheet;

	private StudentService studentService;

	@Autowired
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

//	private EvaluationFormService evaluationFormService;

	private List<TrainingResultsSummary> trainingResultsSummaryList;

//    private ClassesService classesService;

//	private ConsultantService consultantService;
//
//	@Autowired
//	public void setConsultantService(ConsultantService consultantService) {
//		this.consultantService = consultantService;
//	}

	LocalDate today = LocalDate.now();
	DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("dd");
	DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MM");
	DateTimeFormatter yearFormatter = DateTimeFormatter.ofPattern("yyyy");

	String day = today.format(dayFormatter);
	String month = today.format(monthFormatter);
	String year = today.format(yearFormatter);

//    String classes = classesService.findByUsernameConsultant2(user.getUsername());

	public ExcelExportUtil(List<TrainingResultsSummary> trainingResultsSummaryList) {
		this.trainingResultsSummaryList = trainingResultsSummaryList;
		workbook = new XSSFWorkbook();
	}

	private void createCell(Row row, int column, Object value, CellStyle style, Sheet sheet, int startColumn,
			int endColumn) {
		sheet.autoSizeColumn(column);
		Cell cell = row.createCell(column);
		if (value instanceof Integer) {
			cell.setCellValue((Integer) value);
		} else if (value instanceof Double) {
			cell.setCellValue((Double) value);
		} else if (value instanceof Boolean) {
			cell.setCellValue((Boolean) value);
		} else if (value instanceof Long) {
			cell.setCellValue((Long) value);
		} else if (value instanceof String) {
			cell.setCellValue((String) value);
		}

		if (style != null) {
			cell.setCellStyle(style);
		}
		sheet.addMergedRegion(new CellRangeAddress(row.getRowNum(), row.getRowNum(), startColumn, endColumn));
	}

	private void createHeaderRow(String classes, String faculty, List<EvaluationForm> evaluationForm) {

//		MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

//		String faculty = consultantService.getFacultyByUsername(user.getUsername());
//		List<EvaluationForm> evaluationForm = evaluationFormService
//				.findByCriteria(new InputDTO(null, 205, null, null, null, classes));

		sheet = workbook.createSheet("Kết quả rèn luyện");

		// Tạo các ô trong dòng tiêu đề và thiết lập nội dung
		CellStyle titleStyle = workbook.createCellStyle();
		Font titleFont = workbook.createFont();
		titleFont.setBold(true);
		titleStyle.setFont(titleFont);
		titleStyle.setAlignment(HorizontalAlignment.CENTER);

		Row titleRow1 = sheet.createRow(0);
		Row titleRow2 = sheet.createRow(1);
		Row titleRow4 = sheet.createRow(3);
		Row titleRow6 = sheet.createRow(5);
		Row titleRow8 = sheet.createRow(7);
		Row titleRow9 = sheet.createRow(8);

		createCell(titleRow1, 0, "HỌC VIỆN CÔNG NGHỆ BƯU CHÍNH VIỄN THÔNG", titleStyle, sheet, 0, 5);
		createCell(titleRow1, 6, "CỘNG HÒA XÃ HỘI CHỦ NGHĨA VIỆT NAM", titleStyle, sheet, 6, 10);
		createCell(titleRow2, 0, "HỌC VIỆN CNBCVT CƠ SỞ TẠI TP HỒ CHÍ MINH", titleStyle, sheet, 0, 5);
		createCell(titleRow2, 6, "Độc lập - Tự do - Hạnh phúc", titleStyle, sheet, 6, 10);
		createCell(titleRow4, 4, "Tp. Hồ Chí Minh, ngày " + day + " tháng " + month + " năm " + year, titleStyle, sheet,
				4, 10);
		createCell(titleRow6, 0, "TỔNG HỢP KẾT QUẢ RÈN LUYỆN CỦA SINH VIÊN", titleStyle, sheet, 0, 10);

//		createCell(titleRow8, 0, "Lớp:" + classes, titleStyle, sheet, 0, 1);
//		createCell(titleRow8, 4, "Khoa:" , titleStyle, sheet, 4, 5);
//		createCell(titleRow9, 0, "Học Kỳ: " , titleStyle, sheet, 0, 1);
//		createCell(titleRow9, 4, "Năm học: " , titleStyle, sheet, 4, 5);

		createCell(titleRow8, 0, "Lớp:" + classes, titleStyle, sheet, 0, 1);
		createCell(titleRow8, 4, "Khoa:" + faculty, titleStyle, sheet, 4, 5);
		createCell(titleRow9, 0, "Học Kỳ: " + evaluationForm.get(0).getSemesterInYear(), titleStyle, sheet, 0, 1);
		createCell(titleRow9, 4, "Năm học: " + evaluationForm.get(0).getYear(), titleStyle, sheet, 4, 5);

		titleStyle = createBorderedStyle(workbook);
		titleFont = workbook.createFont();
		titleFont.setBold(true);
		titleStyle.setFont(titleFont);
		titleStyle.setAlignment(HorizontalAlignment.CENTER);

		Row headerRow = sheet.createRow(10);

		// Tạo các ô trong dòng tiêu đề bảng và thiết lập nội dung
		String[] columns = { "TT", "Họ và tên", "Mã sinh viên", "Nội dung 1", "Nội dung 2", "Nội dung 3", "Nội dung 4",
				"Nội dung 5", "Tổng điểm", "Xếp loại rèn luyện", "Ghi chú" };
		for (int i = 0; i < columns.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columns[i]);
			cell.setCellStyle(titleStyle);
			sheet.autoSizeColumn(i);
		}
	}

	private void writeTrainingResultsSummaryData(List<EvaluationForm> evaluationForm) {
		int rowCount = 11;

		CellStyle style = createBorderedStyle(workbook);
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);
		int i =1;
		int xuatSac=0,gioi=0,kha=0,trungBinh=0,yeu=0, kem =0;
		for (EvaluationForm evaluationForm1 : evaluationForm) {
			Row row = sheet.createRow(rowCount++);
			Cell cell0 = row.createCell(0);
			cell0.setCellValue(i++);
			cell0.setCellStyle(style);

			Cell cell1 = row.createCell(1);
			cell1.setCellValue(evaluationForm1.getStudent().getFullName());
			cell1.setCellStyle(style);

			Cell cell2 = row.createCell(2);
			cell2.setCellValue(evaluationForm1.getStudent().getUser().getUsername());
			cell2.setCellStyle(style);

			Cell cell3 = row.createCell(3);
			cell3.setCellValue(evaluationForm1.getTotal1());
			cell3.setCellStyle(style);

			Cell cell4 = row.createCell(4);
			cell4.setCellValue(evaluationForm1.getTotal2());
			cell4.setCellStyle(style);

			Cell cell5 = row.createCell(5);
			cell5.setCellValue(evaluationForm1.getTotal3());
			cell5.setCellStyle(style);

			Cell cell6 = row.createCell(6);
			cell6.setCellValue(evaluationForm1.getTotal4());
			cell6.setCellStyle(style);

			Cell cell7 = row.createCell(7);
			cell7.setCellValue(evaluationForm1.getTotal5());
			cell7.setCellStyle(style);

			Cell cell8 = row.createCell(8);
			cell8.setCellValue(evaluationForm1.getTotalPoint());
			cell8.setCellStyle(style);

			Cell cell9 = row.createCell(9);
			cell9.setCellValue(evaluationForm1.getGraded());
			if(evaluationForm1.getGraded()=="Xuất sắc") {
				xuatSac++;
				}else if(evaluationForm1.getGraded()=="Giỏi") {
					gioi++;
				}else if(evaluationForm1.getGraded()=="Khá") {
					kha++;
				}else if(evaluationForm1.getGraded()=="Trung Bình") {
					trungBinh++;
				}else if(evaluationForm1.getGraded()=="Yếu") {
					yeu++;
				}else if(evaluationForm1.getGraded()=="Kém") {
					kem++;
				}
			cell9.setCellStyle(style);

			Cell cell10 = row.createCell(10);
			cell10.setCellValue("");
			cell10.setCellStyle(style);
		}

		style = workbook.createCellStyle();
		font = workbook.createFont();
		font.setFontHeight(11);
		style.setFont(font);
		style.setAlignment(HorizontalAlignment.CENTER);
//        sheet.autoSizeColumn(i);

		int totalStudents = evaluationForm.size();
		Row footerRow1 = sheet.createRow(rowCount++ + 1);
		Row footerRow4 = sheet.createRow(rowCount++ + 1);
		Row footerRow2 = sheet.createRow(rowCount++ + 2);
		Row footerRow3 = sheet.createRow(rowCount++ + 2);
		Row footerRow5 = sheet.createRow(rowCount++ + 2);
		Row footerRow6 = sheet.createRow(rowCount++ + 2);
		Row footerRow7 = sheet.createRow(rowCount++ + 2);
		Row footerRow8 = sheet.createRow(rowCount++ + 2);

		createCell(footerRow1, 0, "Danh sách có", style, sheet, 0, 1);
		createCell(footerRow1, 2, totalStudents + " sinh viên", style, sheet, 2, 4);

		createCell(footerRow4, 0,
				" Lưu ý: Kết quả điểm rèn luyện được phân thành các loại: Xuất sắc, Tốt, Khá, Trung bình, Yếu, ", style,
				sheet, 0, 9);

		createCell(footerRow2, 0, "Loại Xuất sắc: Từ 90 - đến 100 điểm", style, sheet, 0, 4);
		createCell(footerRow2, 5, xuatSac + " Sinh viên", style, sheet, 5, 6);
		createCell(footerRow2, 7, String.format("%.2f",((xuatSac)/(double)totalStudents)*100) + "%", style, sheet, 7, 8);

		createCell(footerRow3, 0, "Loại Tốt: Từ 80 đến dưới 90 điểm", style, sheet, 0, 4);
		createCell(footerRow3, 5, gioi +" Sinh viên", style, sheet, 5, 6);
		createCell(footerRow3, 7, String.format("%.2f",((gioi/(double)totalStudents))*100)+"%", style, sheet, 7, 8);

		createCell(footerRow5, 0, "Loại Khá: Từ 65 đến dưới 80 điểm", style, sheet, 0, 4);
		createCell(footerRow5, 5, kha + " Sinh viên", style, sheet, 5, 6);
		createCell(footerRow5, 7, String.format("%.2f",((kha)/(double)totalStudents)*100)+ "%", style, sheet, 7, 8);

		createCell(footerRow6, 0, "Loại Trung bình: Từ 50 đến dưới 65 điểm", style, sheet, 0, 4);
		createCell(footerRow6, 5, trungBinh + " Sinh viên", style, sheet, 5, 6);
		createCell(footerRow6, 7, String.format("%.2f",((trungBinh)/(double)totalStudents)*100)+ "%", style, sheet, 7, 8);

		createCell(footerRow7, 0, "Loại Yếu: Từ 35 đến dưới 50 điểm", style, sheet, 0, 4);
		createCell(footerRow7, 5, yeu + " Sinh viên", style, sheet, 5, 6);
		createCell(footerRow7, 7, String.format("%.2f",((yeu)/(double)totalStudents)*100) +"%", style, sheet, 7, 8);

		createCell(footerRow8, 0, "Loại kém: Dưới 35 điểm", style, sheet, 0, 4);
		createCell(footerRow8, 5, kem + " Sinh viên", style, sheet, 5, 6);
		createCell(footerRow8, 7, String.format("%.2f",((kem)/(double)totalStudents)*100) + "%", style, sheet, 7, 8);

		Row footerRow9 = sheet.createRow(rowCount++ + 3);
		Row footerRow10 = sheet.createRow(rowCount++ + 3);

		createCell(footerRow9, 0, "Khoa đào tạo", style, sheet, 0, 2);
		createCell(footerRow9, 4, "Cố vấn học tập", style, sheet, 4, 7);
		createCell(footerRow9, 9, "Lớp trưởng", style, sheet, 9, 11);

		createCell(footerRow10, 4, "(Ký và ghi rõ họ tên)", style, sheet, 4, 7);
		createCell(footerRow10, 9, "(Ký và ghi rõ họ tên)", style, sheet, 9, 11);

	}

	private CellStyle createBorderedStyle(Workbook workbook) {
		CellStyle style = workbook.createCellStyle();
		style.setBorderBottom(BorderStyle.THIN);
		style.setBorderTop(BorderStyle.THIN);
		style.setBorderRight(BorderStyle.THIN);
		style.setBorderLeft(BorderStyle.THIN);
		return style;
	}

	public void exportDataToExcel(HttpServletResponse response, String classes, String faculty,
			List<EvaluationForm> evaluationForm) throws IOException {

		createHeaderRow(classes, faculty, evaluationForm);
		writeTrainingResultsSummaryData(evaluationForm);

		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);

		// Đóng workbook
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Tạo file Excel thành công!");

	}
}
