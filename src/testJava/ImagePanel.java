package testJava;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
//	Image image;
//	Toolkit toolkit = getToolkit();	// 이미지 가져오기 위함
//
//	public void setPath(String src) {
//		image = toolkit.getImage(src);	// 경로 설정
//	}
//	
//	@Override
//	public void paint(Graphics g) {
//		g.clearRect(0, 0, 423, 424);
//		if (image != null) {
//			System.out.println("그림그리는중..");
//			g.drawImage(image, 0, 0, this);
//		}
//	}
	
	private Image backgroundImage;
	public void JPanelWithBackground(String fileName) throws IOException {
		  backgroundImage = ImageIO.read(new File(fileName));
	}
	
	public void paintComponent(Graphics g) {
		  super.paintComponent(g);
		  
		  g.clearRect(0, 0, 423, 348);
		  g.drawImage(backgroundImage, 0, 0, null);
	}
}
