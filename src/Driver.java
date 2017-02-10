import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class Driver implements ActionListener {
    private JFrame mainFrame;
    private JLabel someText;
    private JEditorPane editBox;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem save;
    private JFileChooser fileChooser;
    
    public Driver() {
        prepGUI();
    }

    private void prepGUI() {
        mainFrame = new JFrame("TroutBrowser");
        mainFrame.setSize(600, 400);
        //mainFrame.setLayout(new GridLayout(2, 1)); //i don't think i need this just yet.

        someText = new JLabel("", JLabel.CENTER);
        editBox = new JEditorPane();
	fileChooser = new JFileChooser();
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
        mainFrame.add(editBox);	
	mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }

    // private void show() { // can probably delete this.
    //     //editBox.setText("Hello Trout!");
    // }

    public void actionPerformed(ActionEvent e) {
	if (e.getActionCommand().equals("Save")) {
	    String buffer = editBox.getText();
	    
	    int r = fileChooser.showSaveDialog(null);
	    if (r == JFileChooser.APPROVE_OPTION) {
		try {
		    FileWriter f = new FileWriter(fileChooser.getSelectedFile());
		    f.write(buffer);
		    f.flush();
		    f.close();
		} catch(Exception a) {
		    System.out.println(a.getMessage());
		}
	    }
	}
    }

    public static void main(String[] args) {
        Driver d = new Driver();
        //d.show();
    }
}
