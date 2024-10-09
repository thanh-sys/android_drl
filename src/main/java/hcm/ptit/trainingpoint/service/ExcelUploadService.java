package hcm.ptit.trainingpoint.service;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import hcm.ptit.trainingpoint.enitty.Student;
import hcm.ptit.trainingpoint.model.dto.StudentDTO;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Service
public class ExcelUploadService {
	public static boolean isValidExcelFile(MultipartFile file) {
		return Objects.equals(file.getContentType(),
				"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	}

	public static List<StudentDTO> getStudentsDataFromExcel(InputStream inputStream) {
		List<StudentDTO> students = new ArrayList<>();
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = workbook.getSheet("students");
			int rowIndex = 0;
			for (Row row : sheet) {
				System.out.println(row);
				if (rowIndex == 0) {
					rowIndex++;
					continue;
				}
				if (row == null || row.getCell(0) == null || row.getCell(0).getStringCellValue() == " " || row.getCell(1) == null || row.getCell(1).getStringCellValue() == " " ) {
					continue; // bỏ qua dòng trống
				} else {
					Iterator<Cell> cellIterator = row.iterator();
					int cellIndex = 0;
					StudentDTO student = new StudentDTO();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						switch (cellIndex) {
						case 0:
							student.setUsername(cell.getStringCellValue());
							break;					
						case 1:
							student.setClassName(cell.getStringCellValue());
							break;
						case 2:
							student.setAddress(cell.getStringCellValue());
							break;
						case 3:
							student.setBirthday(cell.getLocalDateTimeCellValue().toLocalDate());
							break;
						case 4:
							student.setCountry(cell.getStringCellValue());
							break;
						case 5:
							student.setEmail(cell.getStringCellValue());
							break;
							
						case 6:
							student.setFullName(cell.getStringCellValue());
							break;
						case 7:
							student.setRole(cell.getStringCellValue());
							break;
						default:
							break;
						}
						cellIndex++;
					}
					students.add(student);
				}

			}
		} catch (IOException e) {
			e.getStackTrace();
		}
		for (StudentDTO student : students) {
			System.out.println("Full Name: " + student.getFullName());
			System.out.println("Email: " + student.getEmail());
			System.out.println("Address: " + student.getAddress());
			System.out.println("Birthday: " + student.getBirthday());
			System.out.println("Country: " + student.getCountry());
			System.out.println("Class Name: " + student.getClassName());
			System.out.println("Username: " + student.getUsername());
			System.out.println("Role: " + student.getRole());
			System.out.println("--------------");
		}

		return students;
	}

}