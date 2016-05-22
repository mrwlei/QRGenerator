package cn.cobala.poi;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.cobala.poi.util.POIUtils;

public class POITest {
	
	@Test
	public void testReadExcel() throws Exception{
		Map<Integer,List<List<String>>> sheets = POIUtils.readExcel("E://Book1.xlsx");
		
		Integer keys = sheets.keySet().size();
			
		for(int i = 0; i < keys; i++) {
			
			List<List<String>> sheet = sheets.get(i); //第i个单元格
			
			for(int j = 0; j < sheet.size(); j++) { //每行
				
				List<String> lie = sheet.get(j); 
				
				for(String s : lie) { //每列的值
					
					System.out.println(s);
				}
				
			}
			
		}
		
	}
}
