import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class FontSwingDemo extends JFrame implements ActionListener
{
	public static final int WIDTH = 400;
	public static final int HEIGHT = 225;
	public static final int X_START = 35;
	public static final int Y_START = 113;
	
	
//	change point size eventually
	private Color penColor = Color.BLACK;
	
	public String style = "";
	public int fontStyle = 0;
	public int pointSize = 55;
	
	public JTextArea inputArea;
	public String dispText=" default text";
	public Font fontObject = new Font("Comic Sans MS", Font.PLAIN, pointSize);
	public static void main(String [] args)
	{
		FontSwingDemo runner = new FontSwingDemo();
		runner.setVisible(true);		
	}
	
	public FontSwingDemo()
	{
		setSize(WIDTH,HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("FontSwingDemo");
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(new BorderLayout());
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.GRAY);

		JMenu styleMenu = new JMenu("Font Name");
		
		JMenuItem serifItem = new JMenuItem("Serif");
		serifItem.addActionListener(new serifListener());
//		need to make the LISTENERS
		styleMenu.add(serifItem);
		
		JMenuItem sansItem = new JMenuItem("SansSerif");
		sansItem.addActionListener(new sansListener());
		styleMenu.add(sansItem);
		
		JMenuItem monoItem = new JMenuItem("Monospaced");
		monoItem.addActionListener(new monoListener());
		styleMenu.add(monoItem);
		
		JMenuItem comicItem = new JMenuItem("Comic Sans");
		comicItem.addActionListener(new comicListener());
		styleMenu.add(comicItem);
		
		JMenuItem helItem = new JMenuItem("Helvetica");
		helItem.addActionListener(new helListener());
		styleMenu.add(helItem);				
//		end of style part
		
		JMenu effectMenu = new JMenu("Font Style");
		
		JMenuItem plainItem = new JMenuItem("Plain");
		plainItem.addActionListener(new plainListener());
		effectMenu.add(plainItem);
		
		JMenuItem boldItem = new JMenuItem("Bold");
		boldItem.addActionListener(new boldListener());
		effectMenu.add(boldItem);
		
		JMenuItem italItem = new JMenuItem("Italicized");
		italItem.addActionListener(new italListener());
		effectMenu.add(italItem);
		
		JMenuItem boltalItem = new JMenuItem("Bold/Talic");
		boltalItem.addActionListener(new boltalListener());
		effectMenu.add(boltalItem);
		
		// need 9 10 12 14 16 24 32	
		JMenu sizeMenu = new JMenu("Font Size");
		
		JMenuItem nine = new JMenuItem("9");
		nine.addActionListener(new nineListener());
		sizeMenu.add(nine);
		
		JMenuItem ten = new JMenuItem("10");
		ten.addActionListener(new tenListener());
		sizeMenu.add(ten);
		
		JMenuItem twelve = new JMenuItem("12");
		twelve.addActionListener(new twelveListener());
		sizeMenu.add(twelve);
		
		JMenuItem fourteen = new JMenuItem("14");
		fourteen.addActionListener(new fourteenListener());
		sizeMenu.add(fourteen);
		
		JMenuItem sixteen = new JMenuItem("16");
		sixteen.addActionListener(new sixteenListener());
		sizeMenu.add(sixteen);
		
		JMenuItem twentyfour = new JMenuItem("24");
		twentyfour.addActionListener(new twentyfourListener());
		sizeMenu.add(twentyfour);
		
		JMenuItem thirtytwo = new JMenuItem("32");
		thirtytwo.addActionListener(new thirtytwoListener());
		sizeMenu.add(thirtytwo);
		//end of SIZE MENU
		
		//adding each menu
		menuBar.add(styleMenu);
		menuBar.add(effectMenu);
		menuBar.add(sizeMenu);		
		//end of menus
		setJMenuBar(menuBar);	
		
		
		
		//beginning of BOTTOM PANE, basically display button/text
		JPanel botPane = new JPanel();
		botPane.setBackground(Color.LIGHT_GRAY);	
		botPane.setLayout(new BorderLayout());
		
		//beginning textArea input
		
		inputArea = new JTextArea(1,(WIDTH-10));
		inputArea.setBackground(Color.YELLOW);
		inputArea.setText("Enter text here!");
		botPane.add(inputArea);
		
		
		JButton dispButton = new JButton("Display");
		dispButton.addActionListener(this);
		botPane.add(dispButton,BorderLayout.EAST);
		add(botPane, BorderLayout.SOUTH);
		
		
	}
	//to get text on the gui
	public void paint(Graphics g)
	{
		super.paint(g);
		g.setFont(fontObject);
		g.setColor(penColor);
		g.drawString(dispText, X_START, Y_START);
	}
	
	// actionPerformed for DISPLAY button
	public void actionPerformed(ActionEvent e)
	{
		fontObject = new Font(style, fontStyle , pointSize);
		dispText = inputArea.getText();
		
		repaint();
	}
	
	//beginning of listeners for STYLES , with printlns for CHECKING
	private class serifListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
	    repaint();
		style = "Serif";
		System.out.println("Serif clicked");
		}		
	}
	
	private class sansListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
		repaint();
		style = "SanSerif";
		System.out.println("SanSerif clicked");
		}		
	}
	
	private class monoListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			repaint();
		style = "Monospaced";
		System.out.println("Mono clicked");
		}		
	}
	
	private class comicListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			repaint();
		style = "Comic Sans MS";
		System.out.println("Comic clicked");
		}		
	}
	
	private class helListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			repaint();
		style = "Helvetica";
		System.out.println("Helv clicked");
		}		
	}
	// END OF STYLE LISTENERS
	//
	// BEGINNING OF BOLDTALICS LISTENERS
	private class plainListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			repaint();
			fontStyle = Font.PLAIN;
			System.out.println("PLAIN||");
		}
	}
	
	private class boldListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			repaint();
			fontStyle = Font.BOLD;
			System.out.println("BOLD||");
		}
	}
	
	private class italListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			repaint();
			fontStyle = Font.ITALIC;
			System.out.println("ITALIC||");
		}
	}
	
	private class boltalListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			repaint();
			fontStyle = Font.BOLD + Font.ITALIC; // hw12 notes and/or italic... bitmagic?
			System.out.println("BOLDTALIC||");
		}
	}
	// END OF BOLDTALICS LISTENERS
	//
	//BEGINNING OF POINT SIZE
	private class nineListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			repaint();
			pointSize = 9;
			System.out.println("NINE");
		}
	}
	
	private class tenListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			repaint();
			pointSize = 10;
			System.out.println("TEN");
		}
	}
	
	private class twelveListener implements ActionListener
	{
		
		public void actionPerformed(ActionEvent e)
		{
			repaint();
			pointSize = 12;
			System.out.println("TWELVE");
		}
	}
	
	private class fourteenListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			repaint();
			pointSize = 14;
			System.out.println("FOURTEEN");
		}
	}
	
	private class sixteenListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			repaint();
			pointSize = 16;
			System.out.println("SIXTEEN");
		}
	}
	
	private class twentyfourListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			repaint();
			pointSize = 24;
			System.out.println("TWENTYFOUR");
		}
	}
	
	private class thirtytwoListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			repaint();
			pointSize = 32;
			System.out.println("THIRYTWO");
		}
	}
	// END OF POINTSIZE LISTENERS
	//
	//
	
	
	
}
