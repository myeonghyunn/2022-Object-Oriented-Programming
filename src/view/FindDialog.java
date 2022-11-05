package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import control.CLogin;
import global.Constants.EBasictopPanel;
import global.Constants.EErrorDialog;
import global.Constants.EFindDialog;
import view.LoginDialog.WindowHandler;

public class FindDialog extends JDialog {
	private ActionListener actionHandler;

	// All Container
	private Container c;

	// TOP Panel's
	private FindtopPanel findtopPanel;
	// Center Panel's
	private FindCenterPanel findCenterPanel;

	// Component - BasicPanel

	private FindBottomPanel findBottomPanel;

	public FindDialog(WindowHandler windowHandler, ActionListener actionHandler) {
		// attributes
		this.setSize(400, 700);
		this.setBackground(Color.white);
		this.setTitle(EFindDialog.title.getString());
		this.addWindowListener(windowHandler);

		// handler
		this.actionHandler = actionHandler;

		// set component
		this.c = getContentPane();
		c.setLayout(new BorderLayout());
		
		this.findtopPanel = new FindtopPanel(this.actionHandler);
		c.add(findtopPanel, BorderLayout.NORTH);

		this.findCenterPanel = new FindCenterPanel(this.actionHandler);
		this.findCenterPanel.setBackground(Color.white);
		c.add(findCenterPanel, BorderLayout.CENTER );
		
		this.findBottomPanel = new FindBottomPanel();
		this.findBottomPanel.setBackground(Color.white);
		c.add(findBottomPanel, BorderLayout.SOUTH);

	}

	public void initialize() {
		this.findtopPanel.initialize();
		this.findCenterPanel.initialize();
		this.findBottomPanel.initialize();

		this.setVisible(true);
	}
	public void refresh() {
		this.findtopPanel.refresh();
		this.findCenterPanel.refresh();
		this.findBottomPanel.refresh();

	}

	public boolean AfternewDialog(int codeNum) {
		boolean canFinResult = false;
		if(codeNum==0) { //new Join
			canFinResult=true;
		} else if(codeNum==1) { //find id
			findCenterPanel.ValidateUser(1); 
		} else if(codeNum==2) { //find pw
			canFinResult=findCenterPanel.ValidateUser(2); //����� ����ͼ� ���ο� â�� ���ο� ����� �Է¹ٴ� �װ� ������� ����
		}
		return canFinResult;
		
	}
	

}
