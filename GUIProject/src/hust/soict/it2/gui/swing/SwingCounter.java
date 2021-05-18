package hust.soict.it2.gui.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class SwingCounter extends JFrame{
	private JTextField tfCount;
	private JButton btn;
	private int count = 0;
	
	public SwingCounter() {
		JPanel ctn = new JPanel();
		
		ctn.add(new JLabel("Counter"));
		tfCount = new JTextField("0");
		tfCount.setEditable(false);
		ctn.add(tfCount);
		
		btn = new JButton("click");
		ctn.add(btn);
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				++count;
				tfCount.setText(count + "");
			}
		});
		
		this.add(ctn);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setTitle("Swing Counter");
		setSize(250,250);
		setVisible(true);

		
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new SwingCounter();
				
			}
		});
	}

}
