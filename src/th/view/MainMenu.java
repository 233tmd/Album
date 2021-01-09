package th.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import th.client.Main;
import th.dao.UserDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JPasswordField;

public class MainMenu extends JFrame {

	private JPanel contentPane;
	private JTextField userField;
	private JPasswordField passField;
	
	/**
	 * Create the frame.
	 */
	public MainMenu() {
		
		setTitle("\u6B22\u8FCE\u767B\u5F55");
		setBackground(new Color(0, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel userlabel = new JLabel("\u8D26\u6237\uFF1A");
		userlabel.setFont(new Font("楷体", Font.BOLD, 15));
		userlabel.setBounds(30, 60, 50, 30);
		contentPane.add(userlabel);
		
		JLabel passlabel = new JLabel("\u5BC6\u7801\uFF1A");
		passlabel.setFont(new Font("楷体", Font.BOLD, 15));
		passlabel.setBounds(30, 120, 50, 30);
		contentPane.add(passlabel);
		
		JLabel usererror = new JLabel("");
		usererror.setFont(new Font("楷体", Font.BOLD, 15));
		usererror.setForeground(Color.RED);
		usererror.setBounds(305, 60, 120, 30);
		contentPane.add(usererror);
		
		userField = new JTextField();
		userField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
						//当账户输入框失去焦点时会调用此方法
//						System.out.println("账户输入框失去焦点");
						String username = userField.getText();
						if (username== null || username.trim().length() == 0) {
//				 			System.out.println("账户必须大于6位");
							usererror.setText("账户不能为空！");
						}else{
							usererror.setText("");
						}
					}
				});
		userField.setBounds(100, 60, 200, 30);
		contentPane.add(userField);
		userField.setColumns(10);
		
		JLabel passerror = new JLabel("");
		passerror.setFont(new Font("楷体", Font.BOLD, 15));
		passerror.setForeground(Color.RED);
		passerror.setBounds(305, 120, 120, 30);
		contentPane.add(passerror);
		
		passField = new JPasswordField();
		passField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				//当密码输入框失去焦点时会调用此方法
//				System.out.println("密码输入框失去焦点");
				String password = passField.getText();
				if (password== null || password.trim().length() == 0) {
//		 			System.out.println("密码必须大于6位");
					passerror.setText("密码不能为空！");
				}else{
					passerror.setText("");
				}
			}
		});
		passField.setFont(new Font("宋体", Font.PLAIN, 15));
		passField.setBounds(100, 120, 200, 30);
		contentPane.add(passField);
		
		JLabel landingerror = new JLabel("");
		landingerror.setFont(new Font("楷体", Font.BOLD, 15));
		landingerror.setForeground(Color.RED);
		landingerror.setBounds(25, 15, 350, 30);
		contentPane.add(landingerror);
		
		//注册
		JButton newbutton = new JButton("\u6CE8\u518C");
		newbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 NewUser n=new NewUser();
				 n.show();
				 dispose();
			}
		});
		newbutton.setFont(new Font("楷体", Font.BOLD, 15));
		newbutton.setBounds(175, 180, 100, 30);
		contentPane.add(newbutton);
		
		//登录		
		JButton landingbutton = new JButton("\u767B\u5F55");
		landingbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserDao u=new UserDao();
				boolean b=u.Login(userlabel.getText(),passlabel.getText());
				if(b){//登陆失败
					JOptionPane.showMessageDialog(null, "登陆失败!");
				}else{//登陆成功,跳转页面
				    JOptionPane.showMessageDialog(null, "登陆成功!");
				    Main m=new Main();//登陆成功跳转到主页面
				}
			}
		});
		landingbutton.setFont(new Font("楷体", Font.BOLD, 15));
		landingbutton.setBounds(30, 180, 100, 30);
		contentPane.add(landingbutton);
		
		JButton button = new JButton("\u91CD\u7F6E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userField.setText("");
				passField.setText("");
			}
		});
		button.setFont(new Font("楷体", Font.BOLD, 15));
		button.setBounds(315, 180, 100, 30);
		contentPane.add(button);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
