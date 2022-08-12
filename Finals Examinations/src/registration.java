import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class registration extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtfirstname;
	private JTextField txtlastname;
	private JTextField txtusername;
	private JComboBox txtgender;
	private JPasswordField txtpassword;
	private JPasswordField txtconfirmpass;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registration frame = new registration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public registration(){
		initialize();
	}
	/**
	 * Create the frame.
	 */
		private void initialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\LPU - LAGUNA\\2nd YEAR\\3rd Sem\\Object Oriented Programming Lab & Lec\\New folder\\icons8-register-64.png"));
		setTitle("Registration");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 389, 406);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewUserRegistration = new JLabel("New User Registration");
		lblNewUserRegistration.setBackground(Color.WHITE);
		lblNewUserRegistration.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		lblNewUserRegistration.setBounds(28, 10, 273, 54);
		contentPane.add(lblNewUserRegistration);
		
		JLabel lblfirstname = new JLabel("First Name");
		lblfirstname.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblfirstname.setBounds(28, 74, 147, 25);
		contentPane.add(lblfirstname);
		
		JLabel lbllastname = new JLabel("Last Name");
		lbllastname.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lbllastname.setBounds(28, 109, 147, 25);
		contentPane.add(lbllastname);
		
		JLabel lblgender = new JLabel("Gender");
		lblgender.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblgender.setBounds(28, 144, 147, 25);
		contentPane.add(lblgender);
		
		JLabel lblusername = new JLabel("Username");
		lblusername.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblusername.setBounds(28, 179, 147, 25);
		contentPane.add(lblusername);
		
		JLabel lblpassword = new JLabel("Password");
		lblpassword.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblpassword.setBounds(28, 214, 147, 25);
		contentPane.add(lblpassword);
		
		JLabel lblconfirmpassword = new JLabel("Confirm Password");
		lblconfirmpassword.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		lblconfirmpassword.setBounds(28, 249, 147, 25);
		contentPane.add(lblconfirmpassword);
		
		txtfirstname = new JTextField();
		txtfirstname.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		txtfirstname.setBounds(191, 74, 168, 25);
		contentPane.add(txtfirstname);
		txtfirstname.setColumns(10);
		
		txtlastname = new JTextField();
		txtlastname.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		txtlastname.setColumns(10);
		txtlastname.setBounds(191, 109, 168, 25);
		contentPane.add(txtlastname);
		
		txtusername = new JTextField();
		txtusername.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		txtusername.setColumns(10);
		txtusername.setBounds(191, 179, 168, 25);
		contentPane.add(txtusername);
		
		txtpassword = new JPasswordField();
		//JPasswordField txtpassword= new JPasswordField();
		txtpassword.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		txtpassword.setColumns(10);
		txtpassword.setBounds(191, 214, 168, 25);
		contentPane.add(txtpassword);
		
		txtconfirmpass = new JPasswordField();
		//JPasswordField txtconfirmpass= new JPasswordField();
		txtconfirmpass.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		txtconfirmpass.setColumns(10);
		txtconfirmpass.setBounds(191, 249, 168, 25);
		contentPane.add(txtconfirmpass);
		
		txtgender = new JComboBox();
		txtgender.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		txtgender.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female", "Others"}));
		txtgender.setBounds(191, 144, 168, 26);
		contentPane.add(txtgender);
		
		JButton btnregister = new JButton("Register");
		btnregister.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {								
							
				 if(txtfirstname.getText().equals("")) {					
					JOptionPane.showMessageDialog(null, "First Name is Required", "Login Warning", 2);
				}else if(txtlastname.getText().equals("")) {					
					JOptionPane.showMessageDialog(null, "Last Name is Required", "Login Warning", 2);
				}else if(txtusername.getText().equals("")) {					
					JOptionPane.showMessageDialog(null, "Username is Required", "Login Warning", 2);
				}else if(txtpassword.getText().equals("")) {					
					JOptionPane.showMessageDialog(null, "Password is Required", "Login Warning", 2);
				}else if(txtconfirmpass.getText().equals("")) {					
					JOptionPane.showMessageDialog(null, "Confirm Password is Required", "Login Warning", 2);				
				}else {	
					 register();
				 }
			}
		});
		btnregister.setBackground(new Color(176, 196, 222));
		btnregister.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnregister.setBounds(251, 284, 108, 35);
		contentPane.add(btnregister);
		
		JButton btnclear = new JButton("Clear");
		btnclear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTextfield();
			}
		});
		btnclear.setBackground(new Color(255, 182, 193));
		btnclear.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnclear.setBounds(133, 284, 108, 35);
		contentPane.add(btnclear);
		
		JButton btnexit = new JButton("Exit");
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnexit.setBackground(new Color(255, 160, 122));
		btnexit.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnexit.setBounds(23, 284, 95, 35);
		contentPane.add(btnexit);
		
		JButton btnaccount = new JButton("Already have an account ?");
		btnaccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login window = new login();
				 window.show();
				 dispose();
			}
		});
		
		btnaccount.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnaccount.setBackground(new Color(72, 209, 204));
		btnaccount.setBounds(62, 337, 259, 25);
		contentPane.add(btnaccount);
		}
		//Data Base Connection
				static Connection connect () {
					try {
						// set the my sql driver
						String myDriver = "com.mysql.cj.jdbc.Driver";				
						// Connection String
						String url = "jdbc:mysql://localhost:3306/finals_db";
						Class.forName(myDriver);
						return(Connection) DriverManager.getConnection(url, "root","");				
						
					}catch(Exception e){
						System.out.print("Cannot connect to the Database....");
					}
					return null;
				}			
				// add register method
						private void register() {					
							Connection conn = connect(); // to insert into the database	
							if(txtpassword.getText().equals(txtconfirmpass.getText())) {
								 JOptionPane.showMessageDialog(null, "Registration Successfull ");
								 login window = new login();
								 window.show();
								 dispose();
							
							try {					
							String sql = "INSERT INTO registration_tbl (first_name, last_name, gender, username, password, confirm_password) values(?,?,?,?,?,?)";
							PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sql);
								//components that will be added
							ps.setString(1, txtfirstname.getText());
							ps.setString(2, txtlastname.getText());
							ps.setString(3, txtgender.getSelectedItem().toString());
							ps.setString(4, txtusername.getText());
							ps.setString(5, txtpassword.getText());
							ps.setString(6, txtconfirmpass.getText());			
							ps.execute();
							
							}catch(Exception e){
								System.out.print("Error has occur...." + e);
							}
							}else {
								 JOptionPane.showMessageDialog(null, "Password Mismatch ");
							}
						}
							
				// Clear Method
				private void clearTextfield() {
					txtfirstname.setText("");
					txtlastname.setText("");
					txtusername.setText("");
					txtpassword.setText("");
					txtconfirmpass.setText("");
			}			
}
