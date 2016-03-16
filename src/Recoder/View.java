package Recoder;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class View extends JFrame{

	private JPanel outPanel;
	private JPanel logPanel;
	private JMenu menu;
	private JMenuBar menuBar;
	private JMenuItem loadItem;
	private JMenuItem saveItem;
	private JTextArea outputText;
	private JTextArea logText;
	private JLabel logHeader;
	private JLabel outHeader;
	private JFileChooser fc;
	private File file; 
public View (){
	fc = new JFileChooser();
	outPanel = new JPanel(new FlowLayout());
	logPanel = new JPanel(new FlowLayout());
	menu = new JMenu("Opções");
	menuBar = new JMenuBar();
	loadItem = new JMenuItem("Carregar");
	saveItem = new JMenuItem("Salvar");
	outputText = new JTextArea("Output appears on this area\n", 10, 50);
	logText = new JTextArea("Application log appears on this area\n",10,50);
	logHeader = new JLabel("Log:");
	outHeader = new JLabel("Out:");
	setUp();
}
public void setUp(){
	//set up the menu items
	menu.add(loadItem);
	menu.add(saveItem);
	menuBar.add(menu);
	setJMenuBar(menuBar);
	//set up the GUI items
	outPanel.add(outHeader);
	outPanel.add(new JScrollPane(outputText));
	logPanel.add(logHeader);
	logPanel.add(new JScrollPane(logText));
	//set up menu functions
	loadItem.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			int returnVal = fc.showOpenDialog(View.this);
			 
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                file = fc.getSelectedFile();
                //This is where a real application would open the file.
                logText.append("Opening: " + file.getName() + " on "+ file.getPath() + "\n");
            } else {
                logText.append("Open command cancelled by user.\n");
            }
            logText.setCaretPosition(logText.getDocument().getLength());
            Recoder recoder = new Recoder();
            recoder.outputTree(file.getPath());
            outputText.append("Analysing File "+file.getName()+": \n"+recoder.getOutput());
		}
	});
	//set up the screen components
	this.getContentPane().setLayout(new BorderLayout());
	this.getContentPane().add(outPanel, BorderLayout.NORTH);
	this.getContentPane().add(logPanel, BorderLayout.SOUTH);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.pack();
	this.setVisible(true);
}

}
