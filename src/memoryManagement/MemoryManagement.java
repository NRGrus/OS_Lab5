package memoryManagement;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import algorithm.Algorithm;


public class MemoryManagement extends JFrame {
	
	
	private static int windowWidth = 450;
	private static int windowHeight = 300;
	private static Dimension frameSize = new Dimension(windowWidth, windowHeight);
	
	
	private static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();		
	
	private Algorithm alg = new Algorithm();
	
	
	private Label msgMemoryManagement = new Label("MEMORY MANAGEMENT");
	private Label msgNext = new Label("NEXT FIT");
	private Label msgFirst = new Label("FIRST FIT");
	private Label msgBest = new Label("BEST FIT");
	private Label msgSize = new Label("SIZE: ");
	private Label msgErr = new Label();
	
	private JRadioButton btn_next = new JRadioButton("next");
	private JRadioButton btn_best = new JRadioButton("best");
	private JRadioButton btn_first = new JRadioButton("first");
	private ButtonGroup btn_group = new ButtonGroup();
	
	private JButton btn_calc = new JButton("CALCULATE");
	
	private JTextArea text = new JTextArea();
	private JTextField fld_size = new JTextField();
	
	private Label test = new Label(".");
	
	private Label [] memory = new Label[5];
	
	public MemoryManagement() {
		
		JPanel contentPane = (JPanel) this.getContentPane();
		
		
		this.setTitle("Zhumabek Ruslan");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		msgMemoryManagement.setFont(new Font("Dialog", Font.PLAIN, 20));
		msgMemoryManagement.setBounds(new Rectangle(120, 10, 240, 30));
		
		msgFirst.setFont(new Font("Dialog", Font.PLAIN, 15));
		msgFirst.setBounds(new Rectangle(50, 115, 70, 20));

		msgBest.setFont(new Font("Dialog", Font.PLAIN, 15));
		msgBest.setBounds(new Rectangle(50, 140, 70, 20));
		
		msgNext.setFont(new Font("Dialog", Font.PLAIN, 15));
		msgNext.setBounds(new Rectangle(50, 165, 70, 20));

		msgSize.setFont(new Font("Dialog", Font.PLAIN, 15));
		msgSize.setBounds(new Rectangle(10, 60, 40, 20));
		
		msgErr.setFont(new Font("Dialog", Font.PLAIN, 15));
		msgErr.setBounds(new Rectangle(30, 80, 150, 20));
		msgErr.setForeground(Color.RED);
		
		
		fld_size.setFont(new Font("Dialog", Font.PLAIN, 15));
		fld_size.setBounds(new Rectangle(60, 60, 80, 20));
		
		
		btn_first.setBounds(new Rectangle(30, 120, 20, 20));
		btn_best.setBounds(new Rectangle(30, 145, 20, 20));
		btn_next.setBounds(new Rectangle(30, 170, 20, 20));
		
		btn_calc.setFont(new Font("Dialog", Font.BOLD, 15));
		btn_calc.setBounds(new Rectangle(100, 220, 125, 30));
		btn_calc.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent ae) {calc(ae);}});

		text.setFont(new Font("Dialog", Font.PLAIN, 20));
		text.setBounds(new Rectangle(180, 70, 250, 130));
		text.setBorder(BorderFactory.createLineBorder(Color.black));
		text.setBackground(Color.WHITE);
		text.setEditable(false);
		text.setLineWrap(true);
		
		btn_group.add(btn_first);
		btn_group.add(btn_best);
		btn_group.add(btn_next);
		
		contentPane.add(msgMemoryManagement);
		contentPane.add(msgFirst);
		contentPane.add(msgBest);
		contentPane.add(msgNext);
		contentPane.add(msgSize);
		contentPane.add(msgErr);
		
		contentPane.add(fld_size);
		
		contentPane.add(btn_next);
		contentPane.add(btn_first);
		contentPane.add(btn_best);
		
		contentPane.add(btn_calc);
		
		contentPane.add(text);
		
		contentPane.add(test);
		
		
		
		if (windowHeight > screenSize.height) { frameSize.height = screenSize.height; }
		if (windowWidth > screenSize.width) { frameSize.width = screenSize.width; }
		this.setSize(frameSize.width + 10, frameSize.height + 10); // + 10 for Windows computers
		this.setLocation( (screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

		
		this.setVisible(true);
	}
	
	public void calc(ActionEvent ae) {
		int size;
		String str = "";
		text.setText("");
		msgErr.setText("");
		
		if (fld_size.getText() == null || fld_size.getText().equals("")) {
			msgErr.setText("Size field is empty!!!");
			return;
		} else {
			try {
				size = Integer.parseInt(fld_size.getText());
				for (Enumeration<AbstractButton> btns = btn_group.getElements(); btns.hasMoreElements();) {
		            AbstractButton btn = btns.nextElement();
		
		            if (btn.isSelected()) {
		            	switch (btn.getText()){
		            	case "first": str = alg.firstFit(size);
		            				  break;
		            	case "best": str = alg.bestFit(size);
		            				 break;
		            	case "next": str = alg.nextFit(size);
		            				 break;
		            	}
		            }
				}
				
				text.setText(str);
			} catch (Exception e){
				msgErr.setText("Unavailable symbol!!!");
				return;
			}
		}		
		
	}
}