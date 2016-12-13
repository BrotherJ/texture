package texture.util.poi;

import java.io.FileInputStream;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellRangeAddress;

import texture.util.str.StrCommon;


/**
 * @author wangyc
 *
 */
public class DoExcel {
	
	/**
	 * ����excel�Ĺ�����
	 * 
	 * @param fileInput
	 * @return
	 */
	public static Workbook getWorkBook(String fileInput) {
		Workbook wb = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(fileInput);
			wb = WorkbookFactory.create(fileInputStream);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return wb;
	}
	
	/**
	 * ����Sheetҳ
	 * 
	 * @param fileInput
	 * @param sheetNum
	 * @return
	 */
	public static Sheet getSheet(String fileInput, int sheetNum) {
		Workbook wb = getWorkBook(fileInput);
		Sheet sheet = wb.getSheetAt(sheetNum);
		return sheet;
	}
	
	/**
	 * @param fileInput
	 * @param sheetName
	 * @return
	 */
	public static Sheet getSheet(String fileInput, String sheetName) {
		Workbook wb = getWorkBook(fileInput);
		Sheet sheet = wb.getSheet(sheetName);
		return sheet;
	}
	
	/**
	 * ����Excelָ����Ԫ��
	 *
	 * @param sheet
	 * @param indexRow
	 * @param indexCell
	 * @return
	 */
	public static Cell getCell(Sheet sheet, int indexRow, int indexCell) {
		Row row = getRow(sheet, indexRow);
		Cell cell = row.getCell(indexCell);
		if (cell == null) {
			cell = row.createCell(indexCell);
		}
		return cell;
	}
	
	/**
	 * @param sheet
	 * @param POS
	 * @return
	 */
	public static Cell getCell(Sheet sheet, String POS) {
		int Col = getCol(POS);
		int Row = Integer.parseInt(StrCommon.GetNum(POS)) - 1;
		
		Row row = getRow(sheet, Row);
		Cell cell = row.getCell(Col);
		if (cell == null) {
			cell = row.createCell(Col);
		}
		return cell;
	}

	/**
	 * @param sheet
	 * @param indexRow
	 * @return
	 */
	public static Row getRow(Sheet sheet, int indexRow) {
		Row row = sheet.getRow(indexRow);
		if (row == null) {
			row = sheet.createRow(indexRow);
		}
		return row;
	}
	
	public static Cell getCell(Row row, int index) {
		Cell cell = row.getCell(index);
		if (cell == null) {
			cell = row.createCell(index);
		}
		return cell;
	}
	
	/**
	 * ����Col
	 * 
	 * @param Pos
	 * @return
	 */
	public static int getCol(String Pos) {
		int Col = 0;
		String TempPos = StrCommon.GetStr(Pos);
		int len = TempPos.length();
		for (int j = 1; j <= len; j++) {
			Col = (TempPos.charAt(j - 1) - 'A' + 1) * (int) Math.pow(26, len - j) + Col;
		}
		Col = Col - 1;
		return Col;
	}

	/**
	 * ��õ�Ԫ��ֵ
	 * 
	 * @param sheet
	 * @param POS
	 * @return
	 */
	public static String GetCellValue(Sheet sheet, String POS) {
		try {
			int Col = getCol(POS);
			int Row = Integer.parseInt(StrCommon.GetNum(POS)) - 1;
			Cell cell = getCell(sheet, Row, Col);
			
			if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
				return cell.getStringCellValue().trim();
			} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				String temp = String.valueOf(cell.getNumericCellValue());
				temp = StrCommon.RemoveZero(temp);
				return temp;
			}else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
				String temp = String.valueOf(cell.getBooleanCellValue());
				return temp;
			}else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
				String temp = cell.getStringCellValue().trim();
				if (temp.equals("")) {
					temp = String.valueOf(cell.getNumericCellValue());
				}
				temp = StrCommon.RemoveZero(temp);
				return temp;
			} else {
				return "";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * @param sheet
	 * @param indexRow
	 * @param indexCell
	 * @return
	 */
	public static String GetCellValue(Sheet sheet, int indexRow, int indexCell) {
		try {
			Cell cell = getCell(sheet, indexRow, indexCell);
			
			if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
				return cell.getStringCellValue().trim();
			} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
				String temp = String.valueOf(cell.getNumericCellValue());
				temp = StrCommon.RemoveZero(temp);
				return temp;
			} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
				String temp = String.valueOf(cell.getBooleanCellValue());
				return temp;
			}else if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
				String temp = cell.getStringCellValue().trim();
				if (temp.equals("")) {
					temp = String.valueOf(cell.getNumericCellValue());
				}
				temp = StrCommon.RemoveZero(temp);
				return temp;
			} else {
				return "";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Date GetDateCellValue(Sheet sheet, String POS) {
		try {
			int Col = getCol(POS);
			int Row = Integer.parseInt(StrCommon.GetNum(POS)) - 1;
			Cell cell = getCell(sheet, Row, Col);
			Date temp = cell.getDateCellValue();
			return temp;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * ��д��Ԫ��ֵ
	 * 
	 * @param sheet
	 * @param indexRow
	 * @param indexCell
	 * @param str
	 */
	public static void FillCell(Sheet sheet, int indexRow, int indexCell, String str) {
		try {
			Cell cell = getCell(sheet, indexRow, indexCell);
			
			if (str.compareTo("") == 0) {
				return;
			}
			if (cell != null) {
				// cell.setEncoding(Cell.ENCODING_UTF_16);
				cell.setCellValue(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
	/**
	 * @param sheet
	 * @param POS
	 * @param str
	 */
	public static void FillCell(Sheet sheet, String POS, String str) {
		try {
			int Col = getCol(POS);
			int Row = Integer.parseInt(StrCommon.GetNum(POS)) - 1;
			Cell cell = getCell(sheet, Row, Col);
			
			if (str.compareTo("") == 0) {
				return;
			}
			if (cell != null) {
				// cell.setEncoding(Cell.ENCODING_UTF_16);
				cell.setCellValue(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
	public static void FillCellDate(Sheet sheet, String POS, Date date) {
		try {
			int Col = getCol(POS);
			int Row = Integer.parseInt(StrCommon.GetNum(POS)) - 1;
			Cell cell = getCell(sheet, Row, Col);
			
			if (cell != null) {
				// cell.setEncoding(Cell.ENCODING_UTF_16);
				cell.setCellValue(date);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
	public static void FillCellint(Sheet sheet, String POS, int num) {
		try {
			int Col = getCol(POS);
			int Row = Integer.parseInt(StrCommon.GetNum(POS)) - 1;
			Cell cell = getCell(sheet, Row, Col);
			
			if (cell != null) {
				// cell.setEncoding(Cell.ENCODING_UTF_16);
				cell.setCellValue(num);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
	public static void FillCellBool(Sheet sheet, String POS, boolean bool) {
		try {
			int Col = getCol(POS);
			int Row = Integer.parseInt(StrCommon.GetNum(POS)) - 1;
			Cell cell = getCell(sheet, Row, Col);
			
			if (cell != null) {
				// cell.setEncoding(Cell.ENCODING_UTF_16);
				cell.setCellValue(bool);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
	//�߿�Ӵ�
	public static void setCellStyleBorder(Workbook wb, Sheet sheet, int rownum, int cellnum) {
		
		CellStyle setBorder = wb.createCellStyle();
		setBorder.setBorderBottom(CellStyle.BORDER_THIN); //�±߿�
		setBorder.setBorderLeft(CellStyle.BORDER_THIN);//��߿�
		setBorder.setBorderTop(CellStyle.BORDER_THIN);//�ϱ߿�
		setBorder.setBorderRight(CellStyle.BORDER_THIN);//�ұ߿�
		Cell cell = getCell(sheet, rownum, cellnum);
		cell.setCellStyle(setBorder);
	}
	
	public static void setCellStyleAlign(Workbook wb, Sheet sheet, int rownum, int cellnum, String align) {
		
		CellStyle setBorder = wb.createCellStyle();
		if(align.equals("CENTER")){
			setBorder.setAlignment(CellStyle.ALIGN_CENTER); // ˮƽ���� 
		}
		if(align.equals("LEFT")){
			setBorder.setAlignment(CellStyle.ALIGN_LEFT); // ˮƽ���� 
		}
		if(align.equals("RIGHT")){
			setBorder.setAlignment(CellStyle.ALIGN_RIGHT); // ˮƽ����
		}
		Cell cell = getCell(sheet, rownum, cellnum);
		cell.setCellStyle(setBorder);
	}
	
	
	/**
	 * �Ƴ��ϲ�
	 * 
	 * @param sheet
	 * @param firstRow
	 * @param endRow
	 */
	public static void removeMergedRegion(Sheet sheet, int firstRow, int endRow) {
		for (int i = 0; i < sheet.getNumMergedRegions(); i++) {
			CellRangeAddress address = sheet.getMergedRegion(i);
			if ((address.getFirstRow() > firstRow) && (address.getFirstRow() < endRow)) {
				sheet.removeMergedRegion(i);
			}
		}
	}
	
	/**
	 * ����excel������Ԫ��
	 * 
	 * @param sourceSheet
	 *            Ҫ����excel��sheet
	 * @param sourceRowIndex
	 *            excel�е�����
	 * @param sourceColumnIndex
	 *            excel�е�����
	 * @param targetSheet
	 *            Ŀ��excel��sheet
	 * @param targetRowIndex
	 *            Ŀ��excel��������
	 * @param targetColumnIndex
	 *            Ŀ��excel��������
	 */
	public static void copyCell(Sheet sourceSheet, int sourceRowIndex,
			int sourceColumnIndex, Sheet targetSheet, int targetRowIndex,
			int targetColumnIndex) {
		Row sourceRow = sourceSheet.getRow(sourceRowIndex);
		if (sourceRow != null) {
			Cell sourceCell = sourceRow.getCell(sourceColumnIndex);
			if (sourceCell != null) {
				Row targetRow = getRow(targetSheet, targetRowIndex);
				Cell targetCell = getCell(targetRow, targetColumnIndex);
				CellStyle cellStyle = sourceCell.getCellStyle();
				if (cellStyle != null) {
					targetCell.setCellStyle(cellStyle);
				}
				int cellType = sourceCell.getCellType();
				targetCell.setCellType(cellType);
				switch (cellType) {
				case Cell.CELL_TYPE_STRING:
					targetCell.setCellValue(sourceCell.getStringCellValue());
					break;
				case Cell.CELL_TYPE_NUMERIC:
					targetCell.setCellValue(sourceCell.getNumericCellValue());
					break;
				case Cell.CELL_TYPE_BLANK:
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					targetCell.setCellValue(sourceCell.getBooleanCellValue());
					break;
				default:
					System.out.println("Unknow cell type " + cellType);
					break;
				}
			}
		}
	}

	/**
	 * ����excel�Ķ���
	 * 
	 * @param sourceSheet
	 *            ��ű������ݵ��б�
	 * @param sourceFirstRow
	 *            excel�п�ʼ������
	 * @param sourceLastRow
	 *            excel�н���������
	 * @param columnNum
	 * @param targetSheet
	 * @param targetFirstRow
	 */
	public static void copyRows(Sheet sourceSheet, int sourceFirstRow,
			int sourceLastRow, int columnNum,
			Sheet targetSheet, int targetFirstRow) {
		// �����ϲ��ĵ�Ԫ��
		for (int i = 0; i < sourceSheet.getNumMergedRegions(); i++) {
			CellRangeAddress sourceAddress = sourceSheet.getMergedRegion(i);
			if ((sourceAddress.getFirstRow() >= sourceFirstRow) && (sourceAddress.getFirstRow() <= sourceLastRow)) {
				int targetAddressFirstRow = sourceAddress.getFirstRow() - sourceFirstRow + targetFirstRow;
				int targetAddressLastRow = sourceAddress.getLastRow() - sourceFirstRow + targetFirstRow;
				CellRangeAddress targetAddress = new CellRangeAddress(
						targetAddressFirstRow, targetAddressLastRow,
						sourceAddress.getFirstColumn(),
						sourceAddress.getLastColumn());
				targetSheet.addMergedRegion(targetAddress);
			}
		}
		// �����и�
		for (int i = sourceFirstRow; i <= sourceLastRow; i++) {
			Row sourceRow = sourceSheet.getRow(i);
			if (sourceRow != null) {
				short height = sourceRow.getHeight();
				Row targetRow = DoExcel.getRow(targetSheet, targetFirstRow + i - sourceFirstRow);
				targetRow.setHeight(height);
			}
		}
		// ����cellstyle
		for (int i = sourceFirstRow; i <= sourceLastRow; i++) {
			Row sourceRow = sourceSheet.getRow(i);
			if (sourceRow != null) {
				for (int j = 0; j < columnNum; j++) {
					Cell cell = sourceRow.getCell(j);
					if (cell != null) {
						Row targetRow = DoExcel.getRow(targetSheet, targetFirstRow + i - sourceFirstRow);
						Cell targetCell = DoExcel.getCell(targetRow, j);
						CellStyle cellstyle = cell.getCellStyle();
						if (cellstyle != null) {
							targetCell.setCellStyle(cellstyle);
						}
						int cellType = cell.getCellType();
						targetCell.setCellType(cellType);
						switch (cellType) {
						case Cell.CELL_TYPE_STRING:
							targetCell.setCellValue(cell.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							targetCell.setCellValue(cell.getNumericCellValue());
							break;
						case Cell.CELL_TYPE_BLANK:
							break;
						case Cell.CELL_TYPE_BOOLEAN:
							targetCell.setCellValue(cell.getBooleanCellValue());
							break;
						default:
							System.out.println("Unknow cell type " + cellType);
							break;
						}
					}
				}
			}
		}
		// �����ı�
		for (int i = sourceFirstRow; i <= sourceLastRow; i++) {
			Row sourceRow = sourceSheet.getRow(i);
			Row targetRow = DoExcel.getRow(targetSheet, targetFirstRow + i - sourceFirstRow);
			if (sourceRow != null) {
				for (int j = 0; j < columnNum; j++) {
					Cell cell = sourceRow.getCell(j);
					if (cell != null) {
						Cell targetCell = DoExcel.getCell(targetRow, j);
						int cellType = cell.getCellType();
						targetCell.setCellType(cellType);
						switch (cellType) {
						case Cell.CELL_TYPE_STRING:
							targetCell.setCellValue(cell.getStringCellValue());
							break;
						case Cell.CELL_TYPE_NUMERIC:
							targetCell.setCellValue(cell.getNumericCellValue());
							break;
						case Cell.CELL_TYPE_BLANK:
							break;
						case Cell.CELL_TYPE_BOOLEAN:
							targetCell.setCellValue(cell.getBooleanCellValue());
							break;
						default:
							System.out.println("Unknow cell type " + cellType);
							break;
						}
					}
				}
			}
		}
	}

	public static String GetSheetNameFormSheet(Workbook wb, Sheet DestSheet) {
		for (int m = 0; m < wb.getNumberOfSheets(); m++) {
			if (wb.getSheetAt(m) == DestSheet) {
				return wb.getSheetName(m);
			}
		}
		return "";
	}
	
	
	/**
	 * ɾ������sheetҳ
	 * @param wb
	 * @param x �ڼ���sheetҳ��ʼ����ɾ��
	 * @param sheetNum sheetҳ����
	 */
	public static void DeleteSheets(Workbook wb, int x, int sheetNum) {
		int n = x + 1;
		if (n < sheetNum) {
			try {
				for (; n < sheetNum; n++) {
					wb.removeSheetAt(x + 1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * ������
	 * ����޺ϲ���Ԫ��������ʽ����
	 * 
	 * @param sheet
	 * @param startRow ��ʼ��
	 * @param rows ��������
	 */
	public static void insertRows(Sheet sheet, int startRow, int rows) {
		sheet.shiftRows(startRow, sheet.getLastRowNum(), rows, true, false);
		
		for (int i = 0; i < rows; i++) {
			Row sourceRow = null;// ԭʼλ��
			Row targetRow = null;// �ƶ���λ��
			Cell sourceCell = null;
			Cell targetCell = null;
			sourceRow = sheet.createRow(startRow);
			targetRow = sheet.getRow(startRow + rows);
			sourceRow.setHeight(targetRow.getHeight());

			for (int m = targetRow.getFirstCellNum(); m < targetRow.getPhysicalNumberOfCells(); m++) {
				sourceCell = sourceRow.createCell(m);
				targetCell = targetRow.getCell(m);
				sourceCell.setCellStyle(targetCell.getCellStyle());
				sourceCell.setCellType(targetCell.getCellType());
			}
			startRow++;
		}
	}
	
//	public static void InsertRow(HSSFSheet sheet, int startRow, int rows) {
//		try {
//			sheet.shiftRows(startRow, sheet.getLastRowNum(), rows, true, false);
//			for (int i = 0; i < rows; i++) {
//				try {
//					HSSFCell sourceCell = null;
//					HSSFCell targetCell = null;
//					HSSFRow sourceRow = sheet.createRow(startRow);
//					HSSFRow targetRow = sheet.getRow(startRow + rows);
//					// �����ϲ��ĵ�Ԫ��
//					// ������һ�еĺϲ���Ԫ����һ��
//					ArrayList<Region> ToAddRegion = new ArrayList<Region>();
//					int regionNum = sheet.getNumMergedRegions();
//					for (int j = 0; j < regionNum; j++) {
//						Region region = sheet.getMergedRegionAt(j);
//						if ((region.getRowTo() == startRow + rows) && ((region.getRowFrom() == startRow + rows))) {
//							region.setRowFrom(startRow);
//							region.setRowTo(startRow);
//							ToAddRegion.add(region);
//						}
//					}
//					for (int m = 0; m < ToAddRegion.size(); m++) {
//						sheet.addMergedRegion(ToAddRegion.get(m));
//					}
//
//					sourceRow.setHeight(targetRow.getHeight());
//					for (int m = targetRow.getFirstCellNum(); m < targetRow.getPhysicalNumberOfCells(); m++) {
//						sourceCell = sourceRow.createCell(m);
//						targetCell = targetRow.getCell(m);
//						sourceCell.setCellStyle(targetCell.getCellStyle());
//						sourceCell.setCellType(targetCell.getCellType());
//					}
//					startRow++;
//				} catch (Exception e1) {
//					e1.printStackTrace();
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
//	//����֧��Sheetͨ������
//	public static boolean CopyPages(int pages, HSSFSheet sheet,
//			int linesPerPage, int StartRow) {
//		if (pages <= 0) {
//			return true;
//		}
//		int regionNum = sheet.getNumMergedRegions();
//		if (StartRow > linesPerPage) {
//			MessageBox.post("ģ���ļ���ÿҳʵ�������������ڲ��������õ�ÿҳ������", "����", MessageBox.ERROR);
//			return false;
//		}
//
//		int pageBreaks[] = sheet.getRowBreaks();
//		if (pageBreaks != null)
//			for (int i = 0; i < pageBreaks.length; i++) {
//				sheet.removeRowBreak(pageBreaks[i]);
//			}
//		for (int i = 0; i < pages; i++)
//			sheet.setRowBreak((i + 1) * linesPerPage - 1);
//		for (int i = 1; i <= pages; i++) {
//			for (int j = 0; j < regionNum; j++) {
//				Region region = sheet.getMergedRegionAt(j);
//				if (region.getRowTo() > StartRow) {
//					region.setRowFrom(region.getRowFrom() + i * linesPerPage);
//					region.setRowTo(region.getRowTo() + i * linesPerPage);
//					sheet.addMergedRegion(region);
//				}
//			}
//		}
//
//		for (int i = StartRow; i <= StartRow + linesPerPage; i++) {
//			HSSFRow tempRow = sheet.getRow(i);
//			if (tempRow == null) {
//				continue;
//			}
//			for (int k = 1; k <= pages; k++) {
//				HSSFRow tttempRow = sheet.createRow(i + k * linesPerPage);
//				tttempRow.setHeight(tempRow.getHeight());
//			}
//			int beginCell = tempRow.getFirstCellNum();
//			int endCell = tempRow.getLastCellNum();
//			if (beginCell >= 0) {
//				for (int j = beginCell; j <= endCell; j++) {
//					HSSFCell tempCell = tempRow.getCell(j);
//					if (tempCell != null) {
//						int cellType = tempCell.getCellType();
//						for (int k = 1; k <= pages; k++) {
//							HSSFRow tttempRow = sheet.getRow(i + k * linesPerPage);
//							HSSFCell tttempCell = tttempRow.createCell(j);
//							tttempCell.setCellStyle(tempCell.getCellStyle());
//							tttempCell.setCellType(tempCell.getCellType());
//							if (cellType == HSSFCell.CELL_TYPE_NUMERIC) {
//								tttempCell.setCellValue(tempCell.getNumericCellValue());
//							} else if (cellType == HSSFCell.CELL_TYPE_STRING) {
//								tttempCell.setCellValue(tempCell.getStringCellValue());
//							} else if (cellType == HSSFCell.CELL_TYPE_FORMULA) {
//								tttempCell.setCellFormula(tempCell.getCellFormula());
//							}
//						}
//					}
//				}
//			}
//		}
//		return true;
//	}
//	
//	/**
//	 * ���ɶ�ҳ��Sheet����copy��һҳ�����ݺ͸�ʽ���������е�ҳ
//	 * 
//	 * @param pages
//	 *            ҳ��
//	 * @param sheet
//	 *            HSSFSheet----*****ע��: ģ��Excel�ļ�����������һ��ǿ�Ʒ�ҳ��
//	 * @param lingsPerPage
//	 *            ÿҳ����
//	 * @return true/false
//	 */
//	public static boolean createMultiPages(int pages, HSSFSheet sheet, int linesPerPage) {
//		int regionNum = sheet.getNumMergedRegions();
//		int beginRow = sheet.getFirstRowNum();
//		int endRow = sheet.getLastRowNum();
//
//		if (endRow + 1 > linesPerPage) {
//			MessageBox.post("ģ���ļ���ÿҳʵ�������������ڲ��������õ�ÿҳ������", "����", MessageBox.ERROR);
//			return false;
//		}
//
//		// Remove all page breaks
//		int pageBreaks[] = sheet.getRowBreaks();
//		if (pageBreaks != null)
//			for (int i = 0; i < pageBreaks.length; i++)
//				sheet.removeRowBreak(pageBreaks[i]);
//
//		// Set all page break;
//		for (int i = 0; i < pages; i++)
//			sheet.setRowBreak((i + 1) * linesPerPage - 1);
//
//		// Set merged regions for all pages
//		for (int i = 1; i < pages; i++) {
//			for (int j = 0; j < regionNum; j++) {
//				Region region = sheet.getMergedRegionAt(j);
//				region.setRowFrom(region.getRowFrom() + i * linesPerPage);
//				region.setRowTo(region.getRowTo() + i * linesPerPage);
//				sheet.addMergedRegion(region);
//			}
//		}
//
//		// Set cell format for all pages
//		for (int i = beginRow; i <= endRow; i++) {
//			HSSFRow tempRow = sheet.getRow(i);
//
//			// Create rows and set row height for all pages
//			for (int k = 1; k < pages; k++) {
//				HSSFRow tttempRow = sheet.createRow(i + k * linesPerPage);
//				tttempRow.setHeight(tempRow.getHeight());
//			}
//
//			// Set cell format for all pages
//			int beginCell = tempRow.getFirstCellNum();
//			int endCell = tempRow.getLastCellNum();
//			if (beginCell >= 0) {
//				for (int j = beginCell; j <= endCell; j++) {
//					try {
//						HSSFCell tempCell = tempRow.getCell((short) j);
//						if (tempCell != null) {
//							int cellType = tempCell.getCellType();
//							for (int k = 1; k < pages; k++) {
//								HSSFRow tttempRow = sheet.getRow(i + k * linesPerPage);
//								HSSFCell tttempCell = tttempRow.createCell((short) j);
//								tttempCell.setCellStyle(tempCell.getCellStyle());
//								tttempCell.setCellType(tempCell.getCellType());
//
//								if (cellType == HSSFCell.CELL_TYPE_NUMERIC) {
//									tttempCell.setCellValue(tempCell.getNumericCellValue());
//								} else if (cellType == HSSFCell.CELL_TYPE_STRING) {
//									tttempCell.setCellValue(tempCell.getStringCellValue());
//								} else if (cellType == HSSFCell.CELL_TYPE_FORMULA) {
//									tttempCell.setCellFormula(tempCell.getCellFormula());
//								}
//							}
//						}
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		}
//		return true;
//	}

}