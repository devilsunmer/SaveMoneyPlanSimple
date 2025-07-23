package com;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class SaveUi extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField start;
	private JTextField spend;
	private JTextField life;
	private JTextField fun;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	Save saveModel=new Save();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SaveUi frame = new SaveUi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SaveUi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 193));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(233, 254, 167));
		panel.setBounds(10, 90, 235, 296);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("起始金額：");
		lblNewLabel_1.setBounds(10, 10, 69, 25);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("存錢占比：");
		lblNewLabel_1_1.setBounds(10, 64, 69, 25);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("固定消費：");
		lblNewLabel_1_2.setBounds(10, 117, 69, 25);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("生活開支：");
		lblNewLabel_1_3.setBounds(10, 158, 69, 25);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("娛樂消費：");
		lblNewLabel_1_4.setBounds(10, 196, 69, 25);
		panel.add(lblNewLabel_1_4);
		
		start = new JTextField();
		start.setFont(new Font("新細明體", Font.PLAIN, 14));
		start.setHorizontalAlignment(SwingConstants.RIGHT);
		start.setText("0");
		start.setBounds(75, 12, 96, 21);
		panel.add(start);
		start.setColumns(10);
		
		spend = new JTextField();
		spend.setEnabled(false);
		spend.setFont(new Font("新細明體", Font.PLAIN, 14));
		spend.setHorizontalAlignment(SwingConstants.RIGHT);
		spend.setText("0");
		spend.setColumns(10);
		spend.setBounds(75, 119, 96, 21);
		panel.add(spend);
		
		life = new JTextField();
		life.setEnabled(false);
		life.setFont(new Font("新細明體", Font.PLAIN, 14));
		life.setHorizontalAlignment(SwingConstants.RIGHT);
		life.setText("0");
		life.setColumns(10);
		life.setBounds(75, 160, 96, 21);
		panel.add(life);
		
		fun = new JTextField();
		fun.setEnabled(false);
		fun.setFont(new Font("新細明體", Font.PLAIN, 14));
		fun.setHorizontalAlignment(SwingConstants.RIGHT);
		fun.setText("0");
		fun.setColumns(10);
		fun.setBounds(75, 198, 96, 21);
		panel.add(fun);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("元");
		lblNewLabel_1_4_1.setBounds(182, 196, 43, 25);
		panel.add(lblNewLabel_1_4_1);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("元");
		lblNewLabel_1_3_1.setBounds(182, 158, 43, 25);
		panel.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("元");
		lblNewLabel_1_2_1.setBounds(182, 117, 43, 25);
		panel.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_5 = new JLabel("元");
		lblNewLabel_1_5.setBounds(182, 10, 43, 25);
		panel.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel = new JLabel("月份存錢目標");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 40));
		lblNewLabel.setBounds(110, 10, 270, 73);
		contentPane.add(lblNewLabel);
		
		//存錢占比
		JComboBox save = new JComboBox();
		save.setEnabled(false);
		save.setEditable(true);
		save.setModel(new DefaultComboBoxModel(new String[] {"30", "50", "70"}));
		save.setBounds(89, 65, 63, 23);
		panel.add(save);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(255, 90, 219, 296);
		contentPane.add(scrollPane);
		
		JTextArea output = new JTextArea(saveModel.rules());
		scrollPane.setViewportView(output);
		
		/****************操作介面********************/
		//模式切換部分
		JRadioButton normal = new JRadioButton("經濟模式");
		normal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save.setEnabled(true); 
				spend.setEnabled(false); 
				life.setEnabled(false);
				fun.setEnabled(false);
			}
		});
		buttonGroup.add(normal);
		normal.setBackground(new Color(233, 254, 167));
		normal.setBounds(6, 37, 107, 23);
		panel.add(normal);
		
		JRadioButton creat = new JRadioButton("自定義模式");
		creat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save.setEnabled(false); 
				spend.setEnabled(true); 
				life.setEnabled(true);
				fun.setEnabled(true);
			}
		});
		buttonGroup.add(creat);
		creat.setBackground(new Color(233, 254, 167));
		creat.setBounds(6, 88, 107, 23);
		panel.add(creat);
		
		JRadioButton overhead = new JRadioButton("極限模式");
		overhead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save.setEnabled(false); 
				spend.setEnabled(false); 
				life.setEnabled(false);
				fun.setEnabled(false);
			}
		});
		buttonGroup.add(overhead);
		overhead.setBackground(new Color(233, 254, 167));
		overhead.setBounds(10, 227, 107, 23);
		panel.add(overhead);
		
		//開始計算跟規劃
		JButton planfinish = new JButton("計畫完畢");
		planfinish.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				/*
				 * 1.接收-->getText()
				 * 2.轉型->String-->int
				 * 3.new Order();
				 * 4.輸出 show()
				 */
				
				if(normal.isSelected()) {
					Save.normalCount(start,save);
					String show=Save.showNormal()+"\n"+Save.endPose();
					output.setText(show);
					
				}else if(creat.isSelected()) {
					Save.creatCount(start,spend,life,fun);
					String show=Save.showCreat()+"\n"+Save.endPose();
					output.setText(show);
				}else {
					Save.overheadCount(start);
					String show=Save.showOverhead()+"\n"+Save.endPose();
					output.setText(show);				}

			}
		});
		planfinish.setBounds(10, 256, 87, 23);
		panel.add(planfinish);
		
		//清除歸零
		JButton restart = new JButton("重新規劃");
		restart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				start.setText("0");
				save.setSelectedIndex(-1);
				spend.setText("0");
				life.setText("0");
				fun.setText("0");
				buttonGroup.clearSelection();
				output.setText(Save.rules());
				
			}
		});
		restart.setBounds(123, 256, 87, 23);
		panel.add(restart);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("%");
		lblNewLabel_1_5_1.setBounds(167, 64, 43, 25);
		panel.add(lblNewLabel_1_5_1);
		
		//列印按鈕
		JButton printbutton = new JButton("列印");
		printbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					output.print();
				} catch (PrinterException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		printbutton.setBounds(91, 428, 87, 23);
		contentPane.add(printbutton);

		//關閉視窗
		JButton closebutton = new JButton("關閉視窗");
		closebutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		closebutton.setBounds(293, 428, 87, 23);
		contentPane.add(closebutton);
		
		
	}
}
