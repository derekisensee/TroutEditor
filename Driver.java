import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Driver implements ActionListener/*, ItemListener*/ {
    private JFrame mainFrame;
    private JLabel someText;
    private JEditorPane editBox;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem save;

    public Driver() {
	prepGUI();
    }

    private void prepGUI() {
	mainFrame = new JFrame("TroutBrowser");
	mainFrame.setSize(600, 400);
	//mainFrame.setLayout(new GridLayout(2, 1)); //i don't think i need this just yet.

	someText = new JLabel("", JLabel.CENTER);
	editBox = new JEditorPane();
	// menu stuff
	menuBar = new JMenuBar();
	menu = new JMenu("File");
	save = new JMenuItem("Save");
	menu.getAccessibleContext().setAccessibleDescription("File Stuff");

	save.addActionListener(this);
	menu.add(save);

	menuBar.add(menu);
        // add everything to the frame
	mainFrame.setJMenuBar(menuBar);
	//mainFrame.add(someText);
	mainFrame.add(editBox);
	
	mainFrame.setVisible(true);
    }

    private void show() {
	someText.setText("Hello Trout!");
    }

    public void actionPerformed(ActionEvent e) {
	
    }

    public static void main(String[] args) {
	Driver d = new Driver();
	d.show();
    }
}
