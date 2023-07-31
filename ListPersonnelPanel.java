package dao;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListPersonnelPanel extends JPanel {

    public ListPersonnelPanel(){
        super();
        BoxLayout boxLayout = new BoxLayout(this, BoxLayout.Y_AXIS);
        init();

    }
    private void init(){
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton addBtn = new JButton("Ajouter");
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame = new JFrame("myForm");
                PersonnePannel personnePannel=new PersonnePannel();
                JScrollPane scrollPane=new JScrollPane();
                JViewport viewport=new JViewport();
                // UIManager.setLookAndFeel(new MetalLookAndFeel());
                viewport.setView(personnePannel);
                scrollPane.setViewportView(viewport);frame.setContentPane(scrollPane);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocationRelativeTo(null);
                frame.pack();
                JDialog dialog = new JDialog(frame,"Ajouter de personnes", true);
                dialog.pack();
                dialog.setVisible(true);
            }
        });
        panel.add(addBtn);
        panel.setBorder(new EmptyBorder(16,16,16,15));
        this.add(panel);

    }
}
