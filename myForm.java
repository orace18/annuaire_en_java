package dao;

import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.multi.MultiLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class myForm {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton saveButton;
    public myForm(){

    }


    private JPanel pannel;
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        JFrame frame = new JFrame("myForm");
        ListPersonnelPanel listpersonnePannel=new ListPersonnelPanel();
        JScrollPane scrollPane=new JScrollPane();
        JViewport viewport=new JViewport();
       // UIManager.setLookAndFeel(new MetalLookAndFeel());
        viewport.setView(listpersonnePannel);
        viewport.por
        scrollPane.setViewportView(viewport);frame.setContentPane(scrollPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setSize(400,500);
        frame.setVisible(true);
    }
}
