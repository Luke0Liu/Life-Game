package cellmachine;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mthread.upDate;
import cells.Cell;
import field.Field;
import field.View;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.Event;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CellMachine2 extends JFrame {

	private JPanel contentPane;
	//@default
	static JPanel panel = new JPanel();
	static Field field = new Field(50,50);
	private JTextField textField;
	public String updateTime;
	public static JButton btnNewButton; 
	static JFrame frame=new CellMachine2();
	private boolean mark=true;
	upDate temp=new upDate();
	 
	
	public static void main(String[] args) {
			
			
		for ( int row = 0; row<field.getHeight(); row++ ) {
		for ( int col = 0; col<field.getWidth(); col++ ) {
				field.place(row, col, new Cell());
			}
		}
		for ( int row = 0; row<field.getHeight(); row++ ) {
			for ( int col = 0; col<field.getWidth(); col++ ) {
				Cell cell = field.get(row, col);
				if ( Math.random() < 0.1 ) {
					cell.reborn();
				}
			}
		}
//		View view = new View(field);
//		JFrame frame = new JFrame();
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setResizable(false);
//		frame.setTitle("Cells");
//		frame.getContentPane().add(view, BorderLayout.SOUTH);
//		frame.getContentPane().setBounds(100,100,100,100);
//		frame.pack();
//		CellMachine2 frame=new CellMachine2();
		frame.setVisible(true);

		
		}
		
	

	public CellMachine2()
	{
		setTitle("\u751F\u547D\u6E38\u620F Made By LukeLiu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		panel.setBounds(0, 10, 550, 550);
		contentPane.add(panel);
		panel.setLayout(new CardLayout(0, 0));
		View view = new View(field);
		panel.add(view, "name_12983483438784");
		view.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8BBE\u5B9A\u5237\u65B0\u65F6\u95F4");
		lblNewLabel.setFont(new Font("ËÎÌו", Font.PLAIN, 13));
		lblNewLabel.setBounds(570, 10, 94, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(570, 35, 94, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int time=Integer.parseInt(textField.getText());
				try {
					Thread.sleep(time);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				temp.set(time, field, panel);
				temp.start();
			}
		});
		
		
		btnNewButton.setBounds(570, 66, 93, 23);
		
		
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("\u6682\u505C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mark==true)
				{
					temp.setSuspend(true);
					mark=false;
				}
				else
				{
					temp.setSuspend(false);
					mark=true;
				}
				
			}
		});
		button.setBounds(571, 110, 93, 23);
		contentPane.add(button);
		setResizable(false);
		
	}
}
