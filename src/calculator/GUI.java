package calculator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField displayField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		Machine a = new Machine();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel display = new JPanel();
		contentPane.add(display, BorderLayout.NORTH);
		display.setLayout(new BoxLayout(display, BoxLayout.Y_AXIS));
		
		textField = new JTextField();
		textField.setEditable(false);
		display.add(textField);
		textField.setColumns(30);
		textField.setText(a.getUser());
		
		displayField = new JTextField();
		displayField.setEditable(false);
		display.add(displayField);
		displayField.setColumns(30);
		displayField.setText("0");
		
		JPanel button = new JPanel();
		contentPane.add(button, BorderLayout.CENTER);
		button.setLayout(new GridLayout(5, 5, 0, 0));
		
		JButton btnNewButton = new JButton("New button");
		button.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		button.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		button.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		button.add(btnNewButton_3);
		
		JButton ac = new JButton("AC");
		ac.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				a.clean();
				displayField.setText("0");
				textField.setText("");
			}
		});
		button.add(ac);
		
		JButton seven = new JButton("7");
		seven.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(a.isOperatorClicked){
					displayField.setText("");
					a.isOperatorClicked = false;
				}
				a.appendUser("7");
				displayField.setText(displayField.getText()+"7");
			}
		});
		button.add(seven);
		
		JButton eight = new JButton("8");
		eight.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(a.isOperatorClicked){
					displayField.setText("");
					a.isOperatorClicked = false;
				}
				a.appendUser("8");
				displayField.setText(displayField.getText()+"8");
			}
		});
		button.add(eight);
		
		JButton nine = new JButton("9");
		nine.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(a.isOperatorClicked){
					displayField.setText("");
					a.isOperatorClicked = false;
				}
				a.appendUser("9");
				displayField.setText(displayField.getText()+"9");
			}
		});
		button.add(nine);
		
		JButton plus = new JButton("+");
		plus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {displayField.setText(a.getAnswer());
			a.appendUser("+");
			textField.setText(a.getUser());
			a.isOperatorClicked = true;
			}
		});
		button.add(plus);
		
		JButton btnNewButton_9 = new JButton("New button");
		button.add(btnNewButton_9);
		
		JButton four = new JButton("4");
		four.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(a.isOperatorClicked){
					displayField.setText("");
					a.isOperatorClicked = false;
				}
				a.appendUser("4");
				displayField.setText(displayField.getText()+"4");
			}
		});
		button.add(four);
		
		JButton five = new JButton("5");
		five.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(a.isOperatorClicked){
					displayField.setText("");
					a.isOperatorClicked = false;
				}
				a.appendUser("5");
				displayField.setText(displayField.getText()+"5");
			}
		});
		button.add(five);
		
		JButton six = new JButton("6");
		six.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(a.isOperatorClicked){
					displayField.setText("");
					a.isOperatorClicked = false;
				}
				a.appendUser("6");
				displayField.setText(displayField.getText()+"6");
			}
		});
		button.add(six);
		
		JButton minus = new JButton("-");
		minus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				displayField.setText(a.getAnswer());
				a.appendUser("-");
				textField.setText(a.getUser());
				a.isOperatorClicked = true;
			}
		});
		button.add(minus);
		
		JButton btnNewButton_14 = new JButton("New button");
		button.add(btnNewButton_14);
		
		JButton one = new JButton("1");
		one.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(a.isOperatorClicked){
					displayField.setText("");
					a.isOperatorClicked = false;
				}
				a.appendUser("1");
				displayField.setText(displayField.getText()+"1");
			}
		});
		button.add(one);
		
		JButton two = new JButton("2");
		two.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(a.isOperatorClicked){
					displayField.setText("");
					a.isOperatorClicked = false;
				}
				a.appendUser("2");
				displayField.setText(displayField.getText()+"2");
			}
		});
		button.add(two);
		
		JButton three = new JButton("3");
		three.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(a.isOperatorClicked){
					displayField.setText("");
					a.isOperatorClicked = false;
				}
				a.appendUser("3");
				displayField.setText(displayField.getText()+"3");
			}
		});
		button.add(three);
		
		JButton times = new JButton("×");
		times.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				displayField.setText(a.getAnswer());
				a.appendUser("*");
				textField.setText(a.getUser());
				a.isOperatorClicked = true;
			}
		});
		button.add(times);
		
		JButton btnNewButton_19 = new JButton("New button");
		button.add(btnNewButton_19);
		
		JButton zero = new JButton("0");
		zero.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(a.isOperatorClicked){
					displayField.setText("");
					a.isOperatorClicked = false;
				}
				a.appendUser("0");
				displayField.setText(displayField.getText()+"0");
			}
		});
		button.add(zero);
		
		JButton point = new JButton(".");
		point.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				a.appendUser(".");
				displayField.setText(displayField.getText()+".");
			}
		});
		button.add(point);
		
		JButton equal = new JButton("=");
		equal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				displayField.setText(a.getAnswer());
				textField.setText(a.getUser());
			}
		});
		button.add(equal);
		
		JButton divide = new JButton("÷");
		divide.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				displayField.setText(a.getAnswer());
				a.appendUser("/");
				textField.setText(a.getUser());
				a.isOperatorClicked = true;
			}
		});
		button.add(divide);
	}

}
