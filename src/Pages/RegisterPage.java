package Pages;
import Models.Gym;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterPage extends JFrame {
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
    private Gym gym;

    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static final Pattern VALID_Phone_REGEX =
            Pattern.compile("^\\d{10}$", Pattern.CASE_INSENSITIVE);
    public static final Pattern VALID_Number_REGEX =
            Pattern.compile("\\d+", Pattern.CASE_INSENSITIVE);
    public RegisterPage(String title, Gym gym) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(500, 360));
        this.setContentPane(RegisterPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.gym = gym;

        MonthCB.addItem("Month");
        for (int i = 1; i <= 12; i++) {
            MonthCB.addItem(i);
        }
        YearCB.addItem("Year");
        for (int i = 1900; i <= Calendar.getInstance().get(Calendar.YEAR); i++) {
            YearCB.addItem(i);
        }
        YearMonth yearMonthObject = YearMonth.of(1900, 1);
        int daysInMonth = yearMonthObject.lengthOfMonth();
        DayCB.addItem("Day");
        for (int i = 1; i <= daysInMonth; i++) {
            DayCB.addItem(i);
        }


        RegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Matcher emailMatcher = VALID_EMAIL_ADDRESS_REGEX.matcher(EmailField.getText());
                Matcher phoneMatcher = VALID_Phone_REGEX.matcher(PhoneField.getText());
                Matcher yearMatcher =VALID_Number_REGEX.matcher(YearCB.getSelectedItem().toString());
                Matcher monthMatcher =VALID_Number_REGEX.matcher(MonthCB.getSelectedItem().toString());
                Matcher dayMatcher =VALID_Number_REGEX.matcher(DayCB.getSelectedItem().toString());
                Matcher idMatcher =VALID_Number_REGEX.matcher(IdField.getText());
                boolean flag = true;
                if(!emailMatcher.find()){
                    JOptionPane.showMessageDialog(null, "Email is in the incorrect Format", "Wrong Email Input", JOptionPane.ERROR_MESSAGE);
                    flag = false;
                }
                if(String.valueOf(passwordPasswordField.getPassword())==""){
                    JOptionPane.showMessageDialog(null, "Please Insert Password", "Missing Password", JOptionPane.ERROR_MESSAGE);
                    flag = false;
                }
                if(!idMatcher.find()){
                    JOptionPane.showMessageDialog(null, "Please Insert Your ID", "Missing ID", JOptionPane.ERROR_MESSAGE);
                    flag = false;
                }
                if(NameFiled.getText() == ""){
                    JOptionPane.showMessageDialog(null, "Please Insert Your Full Name", "Missing Full Name", JOptionPane.ERROR_MESSAGE);
                    flag = false;
                }
                if(!phoneMatcher.find()){
                    JOptionPane.showMessageDialog(null, "Please Insert Your Correct Phone Number", "Wrong Phone Number Input", JOptionPane.ERROR_MESSAGE);
                    flag = false;
                }
                if(!yearMatcher.find()||!monthMatcher.find()||!dayMatcher.find()){
                    JOptionPane.showMessageDialog(null, "Please Insert Your Correct Birth Date", "Wrong Birth Date Input", JOptionPane.ERROR_MESSAGE);
                    flag = false;
                }
                if(flag) {
                    Trainee trainee = new Trainee(Integer.parseInt(IdField.getText()), NameFiled.getText(), EmailField.getText(), PhoneField.getText(), new Date(Integer.parseInt(YearCB.getSelectedItem().toString()), Integer.parseInt(MonthCB.getSelectedItem().toString()), Integer.parseInt(DayCB.getSelectedItem().toString())), String.valueOf(passwordPasswordField.getPassword()), new Date());
                    Runnable asyncFileOperation = () -> {
                        try {
                            FileWriter myWriter = new FileWriter("src/Files/Trainees.txt", true);
                            myWriter.write("\n" + trainee.getDetails());
                            myWriter.close();
                            System.out.println("Successfully wrote to the file.");
                        } catch (IOException ex) {
                            System.out.println("An error occurred.");
                            ex.printStackTrace();
                        }
                    };
                    new Thread(asyncFileOperation).start();
                    setVisible(false);
                    JFrame frame = new MainPage("SAN Fitness Club", trainee, gym.getWorkouts());
                    frame.setVisible(true);
                    JOptionPane.showMessageDialog(null, "Please Remember Your Details For Login:\n Trainee Id:" + trainee.getTraineeId() + "\n Password:" + trainee.getPassword(), "Details", JOptionPane.INFORMATION_MESSAGE);
                }
            }

        });
        MonthCB.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                YearMonth yearMonthObject = YearMonth.of(1900, Integer.parseInt(MonthCB.getSelectedItem().toString()));
                int daysInMonth = yearMonthObject.lengthOfMonth();
                DayCB.removeAllItems();
                for (int i = 1; i <= daysInMonth; i++) {
                    DayCB.addItem(i);
                }
            }
        });
    }
}
