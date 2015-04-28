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
import java.awt.Font;
import javax.swing.SwingConstants;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField displayField;
	private JTextField secondDisplay;

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
		
		secondDisplay = new JTextField();
		secondDisplay.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		secondDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		secondDisplay.setEditable(false);
		display.add(secondDisplay);
		secondDisplay.setColumns(30);
		secondDisplay.setText(a.getUser());
		
		displayField = new JTextField();
		displayField.setHorizontalAlignment(SwingConstants.RIGHT);
		displayField.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		displayField.setEditable(false);
		display.add(displayField);
		displayField.setColumns(30);
		displayField.setText("0");
		
		JPanel button = new JPanel();
		contentPane.add(button, BorderLayout.CENTER);
		button.setLayout(new GridLayout(5, 7, 0, 0));
		
		JButton btnNewButton = new JButton("New button");
		button.add(btnNewButton);
		
		
		JButton leftParenthesis = new JButton("(");
		leftParenthesis.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(a.isOperatorClicked){
					a.appendUser("(");
					a.isLeftParenthesisClicked += 1;
					secondDisplay.setText(secondDisplay.getText()+"(");
				}
			}
		});
		button.add(leftParenthesis );
		
		JButton rightParenthesis  = new JButton(")");
		rightParenthesis.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(a.isLeftParenthesisClicked > 0){
					a.appendUser(")");
					a.isLeftParenthesisClicked -= 1;
					secondDisplay.setText(a.getUser());
				}
			}
		});
		button.add(rightParenthesis );
		
		JButton delete = new JButton("DEL");
		delete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				a.removeLastChar();
				displayField.setText(displayField.getText().substring(0,displayField.getText().length()-1));
			}
		});
		button.add(delete);
		
		
		JButton ac = new JButton("AC");
		ac.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				a.clean();
				displayField.setText("0");
				secondDisplay.setText("");
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
			public void mouseClicked(MouseEvent e) {
				displayField.setText(a.getAnswer());
				a.appendUser("+");
				secondDisplay.setText(a.getUser());
				a.isOperatorClicked = true;
			}
		});
		button.add(plus);
		
		JButton sin = new JButton("sin");
		sin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(a.isOperatorClicked)
					a.appendUser("1");
				a.appendUser("*SIN(1/180*"+Math.PI+"*");
				a.isLeftParenthesisClicked++;
				secondDisplay.setText(a.getUser());
			}
		});
		button.add(sin);
		
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
				secondDisplay.setText(a.getUser());
				a.isOperatorClicked = true;
			}
		});
		button.add(minus);
		
		JButton cos = new JButton("cos");
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(a.isOperatorClicked)
					a.appendUser("1");
				a.appendUser("*COS(1/180*"+Math.PI+"*");
				a.isLeftParenthesisClicked++;
				secondDisplay.setText(a.getUser());
			}
		});
		button.add(cos);
		
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
				secondDisplay.setText(a.getUser());
				a.isOperatorClicked = true;
			}
		});
		button.add(times);
		
		JButton tan = new JButton("tan");
		tan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(a.isOperatorClicked)
					a.appendUser("1");
				a.appendUser("*TAN(1/180*"+Math.PI+"*");
				a.isLeftParenthesisClicked++;
				secondDisplay.setText(a.getUser());
			}
		});
		button.add(tan);
		
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
				secondDisplay.setText(a.getUser());
			}
		});
		button.add(equal);
		
		JButton divide = new JButton("÷");
		divide.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				displayField.setText(a.getAnswer());
				a.appendUser("/");
				secondDisplay.setText(a.getUser());
				a.isOperatorClicked = true;
			}
		});
		button.add(divide);
	}

}
