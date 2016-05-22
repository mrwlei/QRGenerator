package cn.cobala.poi.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class POIUtils {
	
	
	/**
	 * @author wl
	 * @description 数据导出excel
	 * @param response
	 * @param datalist  
	 * @param title  {"username","password","age"}
	 * @param filename
	 * @throws Exception 
	 */
	public static void exportExcel(HttpServletResponse response,List<Map> datalist,String[] title,String filename) throws Exception {
		
		filename = filename + ".xls";
		
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		response.setHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes("gbk"),"iso8859-1"));
		
		OutputStream out = response.getOutputStream();
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		ByteArrayOutputStream os = null;
		
		HSSFWorkbook work = new HSSFWorkbook();
    	HSSFSheet sheet = work.createSheet();
		
		
		try {
			HSSFRow row = sheet.createRow(0); //第一行
			HSSFCell cell = null; //列
			
			HSSFCellStyle commStyle = work.createCellStyle();
			commStyle.setAlignment(HSSFCellStyle.ALIGN_LEFT);
			commStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_BOTTOM);
			commStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
			commStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
			commStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
			commStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
			
			
			//创建第一行第一列
			for(int i=0; i<title.length; i++) {
				cell = row.createCell(i); 
				cell.setCellValue(title[i]);
				cell.setCellStyle(commStyle);
			}
			
			//真实数据
			for(int q=0; q<datalist.size(); q++) {
				row = sheet.createRow(q + 1);
				Map mpdata = datalist.get(q);
				
				for(int u=0; u<title.length; u++) {
					cell = row.createCell(u);
					cell.setCellValue(String.valueOf(mpdata.get(u) == null ? "" : mpdata.get(u)));
				}
			}
			
			os = new ByteArrayOutputStream();
			work.write(os); //写入到输出流
			
			byte[] data = os.toByteArray();
			
			InputStream is = new ByteArrayInputStream(data);
			
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(out);
			
			byte[] b = new byte[1024000];
			int len;
			while((len = bis.read(b, 0, b.length)) != -1) {
				bos.write(b, 0, len);
			}
			
			bis.close();
			bos.close();
			out.flush();
			out.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * @author wl 
	 * @description 读取excel中所有sheet数据，
	 * @param filePath
	 * @return Map 其中 key 为某个单元格里的内容
	 * @throws Exception
	 */
	public static Map<Integer,List<List<String>>> readExcel(String filePath) throws Exception {
		
		Map<Integer,List<List<String>>> sheets = new HashMap<Integer,List<List<String>>>();
		
		InputStream is = new FileInputStream(filePath);
		
		Workbook wb = WorkbookFactory.create(is);
		
		System.out.println("一共 " + (wb.getNumberOfSheets()) +"个单元格");
		
		for(int i = 0; i < wb.getNumberOfSheets(); i++) {
			Sheet sheet = wb.getSheetAt(i);   //一个单元格
			List<List<String>> listExcel = new ArrayList<List<String>>(); // 每个单元格里面，所有的行和列数据
			
			for(Row row : sheet) {
				List<String> listRow = new ArrayList<String>();
				
				//遍历一行，所有的列
				for(Cell cell : row) {
					if("".equals(cell.toString())) {
						break;
					}
					listRow.add(cell.toString());
				}
				listExcel.add(listRow);
			}
			
			sheets.put(i, listExcel);
			
		}
		
		is.close();
		
		return sheets;
	}
	
	/**
	 * @author wl 
	 * @description 读取excel中所有sheet数据，
	 * @param filePath
	 * @return Map 其中 key 为某个单元格里的内容
	 * @throws Exception
	 */
	public static Map<Integer,List<List<String>>> readExcel(InputStream is) throws Exception {
		
		Map<Integer,List<List<String>>> sheets = new HashMap<Integer,List<List<String>>>();
		
		Workbook wb = WorkbookFactory.create(is);
		
		System.out.println("一共 " + (wb.getNumberOfSheets()) +"个单元格");
		
		for(int i = 0; i < wb.getNumberOfSheets(); i++) {
			Sheet sheet = wb.getSheetAt(i);   //一个单元格
			List<List<String>> listExcel = new ArrayList<List<String>>(); // 每个单元格里面，所有的行和列数据
			
			for(Row row : sheet) {
				List<String> listRow = new ArrayList<String>();
				
				//遍历一行，所有的列
				for(Cell cell : row) {
					if("".equals(cell.toString())) {
						break;
					}
					listRow.add(cell.toString());
				}
				listExcel.add(listRow);
			}
			
			sheets.put(i, listExcel);
			
		}
		
		is.close();
		
		return sheets;
	}
	
}
