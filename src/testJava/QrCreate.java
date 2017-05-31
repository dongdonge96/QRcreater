package testJava;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QrCreate {
	private String path = "C:\\qrcode";
	private String link = "www.naver.com";
	private Color color; //0xFF2e4e96;
	public String getPath() {
		return path + "\\qr_code.png";
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public void setLink(String link) {
		this.link = link;
	}
	
	public void setColor(Color clr) {
		this.color = clr;
	}
	public void createQrCode() {
		try {
			File file = null;
			// 큐알이미지를 저장할 디렉토리 지정
			file = new File(path);
			if (!file.exists()) {
				file.mkdirs();
			}
			// 코드인식시 링크걸 URL주소
			String codeurl = new String(link.getBytes("UTF-8"), "ISO-8859-1");
			// 큐알코드 바코드 색상값
			int qrcodeColor = this.color.getRGB();
			// 큐알코드 배경색상값
			int backgroundColor = 0xFFFFFFFF;

			QRCodeWriter qrCodeWriter = new QRCodeWriter();
			// 3,4번째 parameter값 : width/height값 지정
			BitMatrix bitMatrix = qrCodeWriter.encode(codeurl, BarcodeFormat.QR_CODE, 200, 200);
			//
			MatrixToImageConfig matrixToImageConfig = new MatrixToImageConfig(qrcodeColor, backgroundColor);
			BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix, matrixToImageConfig);
			// ImageIO를 사용한 바코드 파일쓰기
			ImageIO.write(bufferedImage, "png", new File(path + "\\qr_code.png"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
