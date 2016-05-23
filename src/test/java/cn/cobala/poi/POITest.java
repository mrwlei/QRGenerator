package cn.cobala.poi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.cobala.poi.util.POIUtils;

/**
 * 代码示例
 * @author wang-lei
 */
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
	
	@Test
	public void testExport() {
		
		//1.获取从数据库查询的数据
//		List data = new ArrayList();
		
		//2.组织数据
//		List<Map> exportData = new ArrayList<Map>();、
		
		
//		for(int i = 0; i < data.size(); i++) {
//			DataModel dm = data.get(i);
//			Map map = new HashMap();
//			map.put("fields_1", dm.getFields_1);
//			map.put("fields_2", dm.getFields_2);
//			    ...
			
//			exportData.add(map);
//		}
		
		//3.excel第一行
//		String[] title = {"fields_1_name","fields_2_name"};
		
//		String fileName = System.currentTimeMillis() + "填写你的文件名";
		
		
		//4.调用函数
//		POIUtils.exportExcel(response, exportData, title, fileName);
		
		
	}
	
}
