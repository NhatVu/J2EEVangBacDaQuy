package com.vangbacdaquy.utility;

import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DatasetCreator {
	public static void main(String[] args) {
		try {
			combineFiles("C:\\Users\\Xi Tit\\Desktop\\Labeled", 7,
					"C:\\Users\\Xi Tit\\Desktop\\Labeled\\ExtractedData.xlsx");
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Remove posts that are labeled "irrelevant"
	 * 
	 * @param inputDir
	 *            directory containing excel files
	 * @param labelClassIndex
	 *            0-based index of label column
	 * @param outputFile
	 *            path to output file
	 * @throws InvalidFormatException
	 * @throws IOException
	 */
	public static void removeIrrelevant(String inputDir, int labelClassIndex,
			String outputFile) throws InvalidFormatException, IOException {
		XSSFWorkbook resultWorkbook = new XSSFWorkbook();
		XSSFSheet resultSheet = resultWorkbook.createSheet();
		boolean firstRow = true;
		int rowCount = 0;

		resultWorkbook
				.setMissingCellPolicy(Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
		File[] files = new File(inputDir).listFiles();
		FileFilter filter = new TextFileFilter();

		for (File file : files) {
			Row sourceRow;
			Cell sourceCell;
			if (!file.isDirectory() && !file.isHidden() && file.exists()
					&& file.canRead() && filter.accept(file)) {

				XSSFWorkbook wBook = new XSSFWorkbook(file);
				wBook.setMissingCellPolicy(Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

				Iterator<Row> rowIterator = wBook.getSheetAt(0).iterator();

				if (!firstRow) {
					rowIterator.next();
				} else {
					firstRow = false;
				}
				while (rowIterator.hasNext()) {
					sourceRow = rowIterator.next();
					sourceCell = sourceRow.getCell(labelClassIndex);

					if (sourceCell.toString().equals("Không liên quan")
							|| sourceRow.getCell(0).getCellTypeEnum() == CellType.BLANK) {
						continue;
					} else {
						Row resultRow = resultSheet.createRow(rowCount);

						for (int cellIndex = 0; cellIndex < sourceRow
								.getLastCellNum(); cellIndex++) {
							resultRow.createCell(cellIndex, CellType.STRING)
									.setCellValue(
											sourceRow.getCell(cellIndex)
													.getStringCellValue());
						}
						rowCount++;
					}
				}
				wBook.close();

			}// end if (file filter)
		}// end for (loop through files)
		FileOutputStream fos = new FileOutputStream(outputFile);
		resultWorkbook.write(fos);
		System.out.println("Done");
		fos.close();
		resultWorkbook.close();
	}

	public static void combineFiles(String inputDir, int labelClassIndex,
			String outputFile) throws InvalidFormatException, IOException {
		XSSFWorkbook resultWorkbook = new XSSFWorkbook();
		XSSFSheet resultSheet = resultWorkbook.createSheet();
		boolean firstRow = true;
		int rowCount = 0;

		resultWorkbook
				.setMissingCellPolicy(Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
		File[] files = new File(inputDir).listFiles();
		FileFilter filter = new TextFileFilter();

		for (File file : files) {
			Row sourceRow;
			Cell sourceCell;
			if (!file.isDirectory() && !file.isHidden() && file.exists()
					&& file.canRead() && filter.accept(file)) {

				XSSFWorkbook wBook = new XSSFWorkbook(file);
				wBook.setMissingCellPolicy(Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

				Iterator<Row> rowIterator = wBook.getSheetAt(0).iterator();

				if (!firstRow) {
					rowIterator.next();
				} else {
					firstRow = false;
				}
				while (rowIterator.hasNext()) {
					sourceRow = rowIterator.next();
					sourceCell = sourceRow.getCell(labelClassIndex);

					if (sourceRow.getCell(0).getCellTypeEnum() == CellType.BLANK) {
						continue;
					} else {
						Row resultRow = resultSheet.createRow(rowCount);

						for (int cellIndex = 0; cellIndex < sourceRow
								.getLastCellNum(); cellIndex++) {
							resultRow.createCell(cellIndex, CellType.STRING)
									.setCellValue(
											sourceRow.getCell(cellIndex)
													.getStringCellValue());
						}
						rowCount++;
					}

				}
				wBook.close();

			}// end if (file filter)
		}// end for (loop through files)
		FileOutputStream fos = new FileOutputStream(outputFile);
		resultWorkbook.write(fos);
		System.out.println("Done");
		fos.close();
		resultWorkbook.close();
	}

}
