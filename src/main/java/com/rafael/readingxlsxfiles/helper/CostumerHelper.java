package com.rafael.readingxlsxfiles.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.web.multipart.MultipartFile;

import com.rafael.readingxlsxfiles.domain.model.Costumer;

public class CostumerHelper {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

	public static boolean isXlsx(MultipartFile file) {
		if (!TYPE.equals(file.getContentType())) {
			return false;
		}
		return true;
	}

	public static List<Costumer> importDataOfFileXlsx(InputStream inputStream) {
		try {
			Workbook workbook = WorkbookFactory.create(inputStream);
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rows = sheet.iterator();
			List<Costumer> costumers = new ArrayList<Costumer>();
			int rowNumber = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();
				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}
				Iterator<Cell> cellsInRow = currentRow.iterator();
				Costumer costumer = new Costumer();
				int cellIdx = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();
					switch (cellIdx) {
					case 0:
						costumer.setId((long) currentCell.getNumericCellValue());
						break;
					case 1:
						costumer.setFirstName(currentCell.getStringCellValue());
						break;
					case 2:
						costumer.setLastName(currentCell.getStringCellValue());
						break;
					case 3:
						costumer.setBirthDate(currentCell.getDateCellValue());
						break;
					default:
						break;
					}
					cellIdx++;
				}
				costumers.add(costumer);
			}
			workbook.close();
			return costumers;
		} catch (IOException e) { 
			throw new RuntimeException("Failed to parse XLSX file: " + e.getMessage());
		}
	}
}