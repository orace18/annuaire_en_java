package dao;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Year;
import java.util.Calendar;

public class PersonnePannel extends JPanel implements ActionListener {
    private JPanel panelEnregistrement;
    int currentYear= Calendar.getInstance().get(Calendar.YEAR);
    private JTextField nomField;
    private JTextField prenomsField;
    private JTextField adresseField;
    private JTextField telField;
    private JComboBox ageBox;
    public PersonnePannel(){
        super(new GridLayout());
        init();
        add(panelEnregistrement);
    }
    private void init(){
        panelEnregistrement =new JPanel();
        BoxLayout boxLayout=new BoxLayout(panelEnregistrement, BoxLayout.Y_AXIS);
        panelEnregistrement.setLayout(boxLayout);
        panelEnregistrement.getInsets(new Insets(32,3,32,32));

        TitledBorder border=new TitledBorder( new LineBorder((Color.GREEN)));
        border.getBorderInsets(panelEnregistrement, new Insets(32,32,32,32));
        panelEnregistrement.setBorder(border);
        //Form to nom
        nomField=buildTextFormAndAddToPanel(panelEnregistrement, "Nom");
        prenomsField=buildTextFormAndAddToPanel(panelEnregistrement, "Prénoms");
        adresseField=buildTextFormAndAddToPanel(panelEnregistrement, "Adresse");
        telField=buildTextFormAndAddToPanel(panelEnregistrement, "Telephone");
        Integer[] data=new Integer[100];

        int j=0;
        for (int i =currentYear; j<100 ; i--) {
            data[j]=i;
                    j++;
        }
        ageBox=buildComboBoxAndAddToPanel(panelEnregistrement,"Annee de naissance",data);
        JButton button=new JButton("Enregistrer");
        JPanel panelButton=new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panelButton.add(button);
        panelEnregistrement.add(panelButton);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        button.addActionListener(this);
    }
    private  JTextField buildTextFormAndAddToPanel(JPanel panel, String labelName){
        JPanel panelGrid=new JPanel(new GridLayout(2,1,8,8));
        JLabel label=new JLabel(labelName);
        label.getInsets(new Insets(16,16,8,16));
        JTextField textField=new JTextField();
        textField.getInsets(new Insets(8,16,8,16));
        panelGrid.add(label);
        panelGrid.add(textField);
        panel.add(panelGrid);
        return textField;
    }
    private<T>  JComboBox<T> buildComboBoxAndAddToPanel(JPanel panel, String labelName,T[] data){
        JPanel panelGrid=new JPanel(new GridLayout(2,1));
        JLabel label=new JLabel(labelName);
        label.getInsets(new Insets(8,16,8,16));
        JComboBox<T> comboBox=new JComboBox<T>(data);
        comboBox.getInsets(new Insets(0,16,8,16));
        panelGrid.add(label);
        panelGrid.add(comboBox);
        panel.add(panelGrid);
        return comboBox;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {


        String lastName=nomField.getText();
        String firstName=prenomsField.getText();
        String adress=adresseField.getText();
        String phoneNumber=telField.getText();
        Integer birthYear= (Integer) ageBox.getModel().getSelectedItem();
        int age=birthYear==null ? 0 : currentYear-birthYear;

        Personne personne1=new Personne();
        DBManager dbManager=DBManager.getInstance();
        personne1.setNom(lastName);
        personne1.setPrenoms(firstName);
        personne1.setTel(phoneNumber);
        personne1.setAdresse(adress);
        personne1.setAge(age);
       // dbManager.ajouterPersonne(personne1);

        /*StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Nom : ");
        stringBuilder.append(lastName);
        stringBuilder.append("\n");
        stringBuilder.append("Prénoms : ");
        stringBuilder.append(firstName);
        stringBuilder.append("\n");
        stringBuilder.append("Adresse : ");
        stringBuilder.append(adress);
        stringBuilder.append("\n");
        stringBuilder.append("Telephone : ");
        stringBuilder.append(phoneNumber);
        stringBuilder.append("\n");
        stringBuilder.append("Age : ");
        stringBuilder.append(age);
        System.out.println(stringBuilder);*/
    }
}
