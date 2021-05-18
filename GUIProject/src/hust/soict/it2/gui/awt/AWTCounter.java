package hust.soict.it2.gui.awt;

import java.awt.*;
import java.awt.event.*;

public class AWTCounter extends Frame {

	private Label lblCount;
	private TextField tfCount;
	private Button btnCount,btnCountReset,btnCountDown;
	private int count = 0;
	
	public AWTCounter() {
		setLayout(new FlowLayout());
		lblCount = new Label("Counter");
		add(lblCount);
		
		tfCount = new TextField(count + "" ,10);
		tfCount.setEditable(false);
		add(tfCount);
		
		btnCount = new Button("Count");
		add(btnCount);
		btnCount.addActionListener(new BtnListener());
		
		btnCountDown = new Button("Count down");
		add(btnCountDown);
		btnCountDown.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				--count;
				tfCount.setText(count + "");
			}
		});
		
		btnCountReset = new Button("Reset");
		add(btnCountReset);
		btnCountReset.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				count=0;
				tfCount.setText(count + "");
			}
		});
		
		setTitle("AWT Counter");
		setSize(250, 100);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new AWTCounter();
	}
	
	private class BtnListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			++count;
			tfCount.setText(count + "");
		}
		
	}
	
}
