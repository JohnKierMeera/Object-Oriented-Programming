import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtusername;
	private JPasswordField txtpassword;	
	public static String USERNAME;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		initialize();
			
	}
		private void initialize() {
		setTitle("Login / Sign-in");
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\LPU - LAGUNA\\2nd YEAR\\3rd Sem\\Object Oriented Programming Lab & Lec\\New folder\\icons8-enter-50.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Login Form");
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		lblNewLabel.setBounds(116, 21, 201, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblUsername.setBounds(60, 82, 120, 26);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblPassword.setBounds(60, 128, 120, 26);
		contentPane.add(lblPassword);
		
		txtusername = new JTextField();
		txtusername.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		txtusername.setBounds(209, 87, 155, 30);
		contentPane.add(txtusername);
		txtusername.setColumns(10);
		
		txtpassword = new JPasswordField();		
		txtpassword.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		txtpassword.setColumns(10);
		txtpassword.setBounds(209, 128, 155, 30);
		contentPane.add(txtpassword);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTextfield();
			}
		});
		btnClear.setBackground(new Color(250, 128, 114));
		btnClear.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnClear.setBounds(164, 177, 95, 35);
		contentPane.add(btnClear);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				try {					
					Class.forName("com.mysql.cj.jdbc.Driver");//set the my sql JDBC driver	
					
					//set the my sql connection string
					Connection connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/finals_db","root","");
					Statement stmt = (Statement) connect.createStatement();
					//sql query for the login
					String sql = "Select * from registration_tbl where username='"+ txtusername.getText().toString() +"' and password='"+ txtpassword.getText().toString()+"'";					
					ResultSet rs = stmt.executeQuery(sql);						
					//condition for the user name and password
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "Login is Successful","Login Alert",2);
						dashboard window = new dashboard();
						window.show();
						dispose();
						USERNAME = txtusername.getText();;
						window.txtUser.setText(" Welcome User: " + USERNAME);
					}
					else if(txtusername.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "Username is Required", "Login Warning", 2);						
					}else if(txtpassword.getText().trim().equals("")) {
						JOptionPane.showMessageDialog(null, "Password is Required", "Login Warning", 2);	
					}else {						
						JOptionPane.showMessageDialog(null, "Username/Password is Incorrect", "Login Warning", 2);
					}
					
				}catch(Exception ex){
					System.out.print(ex);
				}
			}
		});
				
		btnLogin.setBackground(new Color(127, 255, 212));
		btnLogin.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnLogin.setBounds(269, 177, 95, 35);
		contentPane.add(btnLogin);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBackground(new Color(255, 182, 193));
		btnExit.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnExit.setBounds(60, 177, 95, 35);
		contentPane.add(btnExit);
		
		JButton btnsignup = new JButton("Create Account Here ");
		btnsignup.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				registration window = new registration();
				window.show();
				dispose();
			}
		});
		btnsignup.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnsignup.setBackground(new Color(72, 209, 204));
		btnsignup.setBounds(99, 228, 223, 25);
		contentPane.add(btnsignup);
	}	
	// Clear Method
	private void clearTextfield() {	
		txtusername.setText("");
		txtpassword.setText("");	
	}
}
