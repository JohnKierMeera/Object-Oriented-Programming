import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class dashboard extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;	
	JTextField txtUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dashboard frame = new dashboard();
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
	public dashboard() {
		setTitle("Dashboard");
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\LPU - LAGUNA\\2nd YEAR\\3rd Sem\\Object Oriented Programming Lab & Lec\\New folder\\icons8-application-64.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 221);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 228, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUser = new JTextField();
		txtUser.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		txtUser.setBackground(new Color(255, 228, 225));
		txtUser.setFont(new Font("Century Gothic", Font.PLAIN, 23));
		txtUser.setEditable(false);
		txtUser.setBounds(60, 40, 318, 68);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		txtUser.setText(login.USERNAME);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBackground(new Color(240, 128, 128));
		btnExit.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnExit.setBounds(84, 134, 100, 30);
		contentPane.add(btnExit);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login window = new login();
				 window.show();
				 dispose();
			}
		});
		btnLogOut.setBackground(new Color(255, 182, 193));
		btnLogOut.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		btnLogOut.setBounds(263, 134, 100, 30);
		contentPane.add(btnLogOut);
	}
}
