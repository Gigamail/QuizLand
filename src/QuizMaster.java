import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class QuizMaster {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(850, 450);

        // Create a JPanel for the top section with a background GIF
        JPanel topPanel = new JPanel() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Load and draw your background GIF here
                ImageIcon background = new ImageIcon("./img/wallpaper.gif");
                background.paintIcon(this, g, 0, 0);
            }
        };

        JLabel welcomeLabel = new JLabel();
        welcomeLabel.setFont(new Font("Jokerman", Font.BOLD, 36));
        welcomeLabel.setText("<html><u>Welcome to Quizzland!</u></html>");
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        welcomeLabel.setForeground(Color.WHITE);

        JPanel buttonPanel = new JPanel(new GridLayout(0, 3, 20, 20)); // 2 rows, 3 columns, with spacing

        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50)); 

        // Create buttons for each quiz with different fonts and backgrounds
        JButton calculusButton = createStyledButton("Calculus", "Breathe Fire", "./img/calculus.jpg");
        JButton harryPotterButton = createStyledButton("Harry Potter", "Breathe Fire", "./img/harry_potter.jpg");
        JButton ChessGameButton = createStyledButton("Chess Game", "Breathe Fire", "./img/chess.jpeg");
        JButton pyGameButton = createStyledButton("Py Game", "Breathe Fire", "./img/pygame.png");

        calculusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	  CalculusQuiz CQ = new CalculusQuiz();
            }
        });
        ChessGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	  chessMaster Ch = new chessMaster();
            }
        });
        pyGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	  Pygame py = new Pygame();
            }
        });
        harryPotterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 HarryPotterQuiz HP = new HarryPotterQuiz();
            	}
        });

        buttonPanel.add(calculusButton);
        buttonPanel.add(harryPotterButton);
        buttonPanel.add(ChessGameButton);
        buttonPanel.add(pyGameButton);
  
        // Add the top, welcome label, and button panel to the frame
        topPanel.add(welcomeLabel);
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }


    // Function to create a styled button with custom font and background image
    private static JButton createStyledButton(String text, String fontName, String imagePath) {
        JButton button = new JButton(text);
        button.setFont(new Font(fontName, Font.PLAIN, 36));
        button.setIcon(new ImageIcon(imagePath));
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.CENTER);
        button.setForeground(Color.WHITE);
        button.setBorderPainted(false);

        JPanel overlayPanel = new JPanel() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(0, 0, 0, 64)); // Transparent black color
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };

        overlayPanel.setLayout(new BorderLayout());
        overlayPanel.setOpaque(false);

        // Add hover effect
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                overlayPanel.setVisible(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                overlayPanel.setVisible(false);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // Add your click event handling code here
            }
        });

        button.setLayout(new BorderLayout());
        button.add(overlayPanel, BorderLayout.CENTER);

        return button;
    }
}
