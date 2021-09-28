package Pages;

import Models.Trainee;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileWriter;
import java.io.IOException;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;

public class RegisterPage extends JFrame{
    private JPanel RegisterPanel;
    private JTextField NameFiled;
    private JTextField EmailField;
    private JComboBox MonthCB;
    private JComboBox YearCB;
    private JComboBox DayCB;
    private JPasswordField passwordPasswordField;
    private JTextField PhoneField;
    private JButton RegisterButton;
    private JTextField IdField;

    public RegisterPage(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(500,360));
        this.setContentPane(RegisterPanel);

        MonthCB.addItem("Month");
        for (int i = 1;i<=12;i++){
             MonthCB.addItem(i);
        }
        YearCB.addItem("Year");
        for(int i =1900;i<= Calendar.getInstance().get(Calendar.YEAR);i++){
            YearCB.addItem(i);
        }
        YearMonth yearMonthObject = YearMonth.of(1900, 1);
        int daysInMonth = yearMonthObject.lengthOfMonth();
        DayCB.addItem("Day");
        for (int i =1;i<=daysInMonth;i++){
            DayCB.addItem(i);
        }
        this.pack();

        RegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)  {
                try {
                Trainee trainee = new Trainee(Integer.parseInt(IdField.getText()), NameFiled.getText(), EmailField.getText() ,PhoneField.getText(),new Date(Integer.parseInt(YearCB.getSelectedItem().toString()),Integer.parseInt(MonthCB.getSelectedItem().toString()),Integer.parseInt(DayCB.getSelectedItem().toString())),String.valueOf(passwordPasswordField.getPassword()));
                FileWriter myWriter = new FileWriter("src/Files/Trainees.txt");
                myWriter.write(trainee.toString());
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
                }catch (IOException ex) {
                    System.out.println("An error occurred.");
                    ex.printStackTrace();
                }
            }
        });
        MonthCB.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                YearMonth yearMonthObject = YearMonth.of(1900, Integer.parseInt(MonthCB.getSelectedItem().toString()));
                int daysInMonth = yearMonthObject.lengthOfMonth();
                DayCB.removeAllItems();
                for (int i =1;i<=daysInMonth;i++){
                    DayCB.addItem(i);
                }
            }
        });
    }
}
