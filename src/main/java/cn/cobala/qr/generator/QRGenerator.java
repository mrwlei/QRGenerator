package cn.cobala.qr.generator;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import cn.cobala.qr.generator.util.MatrixToImageWriter;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class QRGenerator {
	
	private String contents;         //二维码信息
	private String format = "png";   //二维码图片类型
	
	private int width = 400;
	private int height = 400;
	
	private String unicode = "UTF-8";
	
	private String logoClassPathURL; //图片logo的相对路径，添加在classpath下面
	
	
	public QRGenerator(String contents) {
		this.contents = contents;
	}
	
	public QRGenerator(String contents, String logoClassPathURL) {
		this.contents = contents;
		this.logoClassPathURL = logoClassPathURL;
	}
	
	public QRGenerator(String contents, String format, String logoClassPathURL) {
		this.contents = contents;
		this.format = format;
		this.logoClassPathURL = logoClassPathURL;
	}
	
	public QRGenerator(String contents, String format, String unicode,
			String logoClassPathURL) {
		this.contents = contents;
		this.format = format;
		this.unicode = unicode;
		this.logoClassPathURL = logoClassPathURL;
	}

	public QRGenerator(String contents, String format, int width, int height,
			String unicode, String logoClassPathURL) {
		this.contents = contents;
		this.format = format;
		this.width = width;
		this.height = height;
		this.unicode = unicode;
		this.logoClassPathURL = logoClassPathURL;
	}
	
	
	/**
	 * 二维码图片以字节数组的方式返回
	 * @return byte[]
	 * @throws WriterException
	 * @throws IOException
	 */
	public byte[] generateQRToByteAraay() throws WriterException, IOException {
		Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
		// 指定纠错等级,纠错级别（L 7%、M 15%、Q 25%、H 30%）  
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);  
        // 内容所使用字符集编码  
        hints.put(EncodeHintType.CHARACTER_SET, unicode);     
//      hints.put(EncodeHintType.MAX_SIZE, 350);//设置图片的最大值  
//      hints.put(EncodeHintType.MIN_SIZE, 100);//设置图片的最小值  
        hints.put(EncodeHintType.MARGIN, 1);//设置二维码边的空度，非负数  
		
        BitMatrix bitMatrix = new MultiFormatWriter().encode(contents,//要编码的内容  
                //编码类型，目前zxing支持：Aztec 2D,CODABAR 1D format,Code 39 1D,Code 93 1D ,Code 128 1D,  
                //Data Matrix 2D , EAN-8 1D,EAN-13 1D,ITF (Interleaved Two of Five) 1D,  
                //MaxiCode 2D barcode,PDF417,QR Code 2D,RSS 14,RSS EXPANDED,UPC-A 1D,UPC-E 1D,UPC/EAN extension,UPC_EAN_EXTENSION  
                BarcodeFormat.QR_CODE,  
                width, //条形码的宽度  
                height, //条形码的高度  
                hints);//生成条形码时的一些配置,此项可选  
        
        
		return MatrixToImageWriter.writeToByteArray(bitMatrix, format, logoClassPathURL);
	}
	
	/**
	 * 二维码图片以File的方式保存到磁盘的指定位置
	 * @return byte[]
	 * @throws WriterException
	 * @throws IOException
	 */
	public void generateQRToFile(File file) throws IOException, WriterException {
		Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
		// 指定纠错等级,纠错级别（L 7%、M 15%、Q 25%、H 30%）  
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);  
        // 内容所使用字符集编码  
        hints.put(EncodeHintType.CHARACTER_SET, unicode);     
//      hints.put(EncodeHintType.MAX_SIZE, 350);//设置图片的最大值  
//      hints.put(EncodeHintType.MIN_SIZE, 100);//设置图片的最小值  
        hints.put(EncodeHintType.MARGIN, 1);//设置二维码边的空度，非负数  
		
        BitMatrix bitMatrix = new MultiFormatWriter().encode(contents,//要编码的内容  
                //编码类型，目前zxing支持：Aztec 2D,CODABAR 1D format,Code 39 1D,Code 93 1D ,Code 128 1D,  
                //Data Matrix 2D , EAN-8 1D,EAN-13 1D,ITF (Interleaved Two of Five) 1D,  
                //MaxiCode 2D barcode,PDF417,QR Code 2D,RSS 14,RSS EXPANDED,UPC-A 1D,UPC-E 1D,UPC/EAN extension,UPC_EAN_EXTENSION  
                BarcodeFormat.QR_CODE,  
                width, //条形码的宽度  
                height, //条形码的高度  
                hints);//生成条形码时的一些配置,此项可选  
        
        
		MatrixToImageWriter.writeToFile(bitMatrix, format, file, logoClassPathURL);
	}
	
	/**
	 * 二维码图片以输出流的方式返回
	 * @return byte[]
	 * @throws WriterException
	 * @throws IOException
	 */
	public void generateQRToOutputStream(OutputStream out) throws WriterException, IOException {
		Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
		// 指定纠错等级,纠错级别（L 7%、M 15%、Q 25%、H 30%）  
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H);  
        // 内容所使用字符集编码  
        hints.put(EncodeHintType.CHARACTER_SET, unicode);     
//      hints.put(EncodeHintType.MAX_SIZE, 350);//设置图片的最大值  
//      hints.put(EncodeHintType.MIN_SIZE, 100);//设置图片的最小值  
        hints.put(EncodeHintType.MARGIN, 1);//设置二维码边的空度，非负数  
		
        BitMatrix bitMatrix = new MultiFormatWriter().encode(contents,//要编码的内容  
                //编码类型，目前zxing支持：Aztec 2D,CODABAR 1D format,Code 39 1D,Code 93 1D ,Code 128 1D,  
                //Data Matrix 2D , EAN-8 1D,EAN-13 1D,ITF (Interleaved Two of Five) 1D,  
                //MaxiCode 2D barcode,PDF417,QR Code 2D,RSS 14,RSS EXPANDED,UPC-A 1D,UPC-E 1D,UPC/EAN extension,UPC_EAN_EXTENSION  
                BarcodeFormat.QR_CODE,  
                width, //条形码的宽度  
                height, //条形码的高度  
                hints);//生成条形码时的一些配置,此项可选  
        
        MatrixToImageWriter.writeToStream(bitMatrix, format, out, logoClassPathURL);
	}
	
}
