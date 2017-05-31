package testJava;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ImageView extends JFrame implements ActionListener {
	private JPanel panel;
	private JTextField textField;
	private JButton btnNewButton;
	
	private ImagePanel imgPanel;
	private QrCreate qrCode = null;
		
	private ButtonGroup bg = new ButtonGroup();
	private JRadioButton radioBtnRed;
	private JRadioButton radioBtnBlue;
	private JRadioButton radioBtnBlack;
	
	public ImageView() {
		setTitle("QR Code");
		this.setSize(450, 351);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		qrCode = new QrCreate();
		
		panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(12, 10, 298, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		imgPanel = new ImagePanel();
//		try {
//			imgPanel.JPanelWithBackground(qrCode.getPath());
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		imgPanel.setBounds(12, 79, 423, 231);
		panel.add(imgPanel);
		
		btnNewButton = new JButton("생성");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(310, 9, 125, 23);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 41, 193, 28);
		panel.add(panel_1);
		
		radioBtnRed = new JRadioButton("빨간색");
		radioBtnBlue = new JRadioButton("파란색");
		radioBtnBlack = new JRadioButton("검은색");
		radioBtnBlack.setSelected(true);
		bg.add(radioBtnBlack);
		bg.add(radioBtnBlue);
		bg.add(radioBtnRed);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(radioBtnRed)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(radioBtnBlue)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(radioBtnBlack)
					.addGap(46))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(radioBtnRed)
						.addComponent(radioBtnBlue)
						.addComponent(radioBtnBlack)))
		);
		panel_1.setLayout(gl_panel_1);
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		panel.repaint();
		qrCode.setLink(textField.getText());
		if (radioBtnRed.isSelected()) {
			qrCode.setColor(Color.RED);
		}
		else if (radioBtnBlue.isSelected()) {
			qrCode.setColor(Color.BLUE);
		}
		else if (radioBtnBlack.isSelected()) {
			qrCode.setColor(Color.BLACK);
		}
		qrCode.createQrCode();
		try {
			imgPanel.JPanelWithBackground(qrCode.getPath());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		imgPanel.repaint();
	}
}