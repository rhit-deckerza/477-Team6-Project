package scp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Scp {
    private JFrame frame;
    private JTextField serverField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JTextField destinationField;

    public static void runSCPTo(String incomingSource) {
        EventQueue.invokeLater(() -> {
            try {
            	Scp window = new Scp(incomingSource, false);
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    
    public static void runSCPFrom(String incomingSource) {
        EventQueue.invokeLater(() -> {
            try {
            	Scp window = new Scp(incomingSource, true);
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Scp(String incomingSource, Boolean from) {
    	frame = new JFrame();
    	frame.setBounds(100, 100, 450, 300);
    	frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	frame.getContentPane().setLayout(null);

    	serverField = new JTextField();
    	serverField.setBounds(115, 36, 130, 26);
    	frame.getContentPane().add(serverField);
    	serverField.setColumns(10);

    	usernameField = new JTextField();
    	usernameField.setBounds(115, 74, 130, 26);
    	frame.getContentPane().add(usernameField);
    	usernameField.setColumns(10);

    	passwordField = new JPasswordField();
    	passwordField.setBounds(115, 112, 130, 26);
    	frame.getContentPane().add(passwordField);

    	destinationField = new JTextField();
    	destinationField.setBounds(115, 150, 130, 26);
    	frame.getContentPane().add(destinationField);
    	destinationField.setColumns(10);

    	JLabel lblServer = new JLabel("Server:");
    	lblServer.setBounds(65, 41, 61, 16);
    	frame.getContentPane().add(lblServer);

    	JLabel lblUsername = new JLabel("Username:");
    	lblUsername.setBounds(45, 79, 71, 16);
    	frame.getContentPane().add(lblUsername);

    	JLabel lblPassword = new JLabel("Password:");
    	lblPassword.setBounds(45, 117, 61, 16);
    	frame.getContentPane().add(lblPassword);

    	JLabel lblDestination = new JLabel("Destination:");
    	lblDestination.setBounds(34, 155, 80, 16);
    	frame.getContentPane().add(lblDestination);

    	JButton btnScp = new JButton("SCP");
    	btnScp.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {
    	    	if (from) {
    	    		scpFileFrom(incomingSource);
    	    	}else {
        	    	scpFileTo(incomingSource);
    	    	}
    	    }
    	});
    	btnScp.setBounds(155, 193, 117, 29);
    	frame.getContentPane().add(btnScp);
    }

    private void scpFileTo(String incomingSource) {
        String server = serverField.getText();
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String source = incomingSource;
        String destination = destinationField.getText();

        JSch jsch = new JSch();
        Session session = null;
        Channel channel = null;

        try {
            session = jsch.getSession(username, server, 22);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(password);
            session.connect();

            channel = session.openChannel("sftp");
            channel.connect();

            ChannelSftp sftpChannel = (ChannelSftp) channel;
            sftpChannel.put(source, destination);

            sftpChannel.exit();
            session.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (channel != null && channel.isConnected()) {
                channel.disconnect();
            }
            if (session != null && session.isConnected()) {
                session.disconnect();
            }
        }
    }
    
    private void scpFileFrom(String remoteSource) {
    	String server = serverField.getText();
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String source = remoteSource;
        String destination = destinationField.getText();

        JSch jsch = new JSch();
        Session session = null;
        Channel channel = null;

        try {
            session = jsch.getSession(username, server, 22);
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword(password);
            session.connect();

            channel = session.openChannel("sftp");
            channel.connect();

            ChannelSftp sftpChannel = (ChannelSftp) channel;
            sftpChannel.get(sftpChannel.pwd() + source, destination); // Changed .put to .get to transfer from remote to local

            sftpChannel.exit();
            session.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (channel != null && channel.isConnected()) {
                channel.disconnect();
            }
            if (session != null && session.isConnected()) {
                session.disconnect();
            }
        }
    }
}
