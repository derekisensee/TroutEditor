import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

class Driver implements ActionListener {
    private JFrame mainFrame;
    private JEditorPane editBox;
    
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem save;
    private JMenuItem open;
    
    private JFileChooser fileChooser;
    
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
        if (e.getActionCommand().equals("Open")) {
            int r = fileChooser.showOpenDialog(null);
            if (r == JFileChooser.APPROVE_OPTION) {
                File f = fileChooser.getSelectedFile();
                try {
                    Scanner in = new Scanner(f);
                    String fileText = "";
                    while (in.hasNext()) {
                        fileText += in.nextLine() + "\n";
                    }
                    editBox.setText(fileText);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
    public static void main(String[] args) {
        Driver d = new Driver();
    }

    public Driver() {
        prepGUI();
    }

    private void prepGUI() {
        mainFrame = new JFrame("TroutBrowser");
        mainFrame.setSize(600, 400);
        //mainFrame.setLayout(new GridLayout(2, 1)); //i don't think i need this just yet.

        editBox = new JEditorPane();
        fileChooser = new JFileChooser();
        // menu stuff
        menuBar = new JMenuBar();
        menu = new JMenu("File");
        save = new JMenuItem("Save");
        open = new JMenuItem("Open");
        menu.getAccessibleContext().setAccessibleDescription("File Stuff");
        save.addActionListener(this);
        open.addActionListener(this);
        menu.add(save); menu.add(open);

        menuBar.add(menu);

        // add everything to the frame
        mainFrame.setJMenuBar(menuBar);
        mainFrame.add(editBox);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
    }
}