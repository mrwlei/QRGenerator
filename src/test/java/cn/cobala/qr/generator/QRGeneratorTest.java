package cn.cobala.qr.generator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

import com.google.zxing.WriterException;

public class QRGeneratorTest {
	
	@Test
	public void testGFile() throws IOException, WriterException{
		
//		QRGenerator qg = new QRGenerator("扫一下，就会出现此内容偶。", "png");
//		qg.generateQRToFile(new File("F://aaa.png"));
		
		
//		QRGenerator qg = new QRGenerator("扫一下，就会出现此内容偶。并且二维码中间还会有自己的logo,logo图片应放在classpath下", 
//												"png", "/logo.jpg");
//		qg.generateQRToFile(new File("F://aaa.png"));
		
		
		QRGenerator qg = new QRGenerator("扫一下，就会出现此内容偶。并且二维码中间还会有自己的logo,logo图片应放在classpath下",
										"png", 150, 150, "UTF-8", "/logo.jpg");
		qg.generateQRToFile(new File("F://aaa.png"));
		
	}
}
