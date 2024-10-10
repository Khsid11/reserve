package Reservationform;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class scratch {

    private JFrame frame;
    private JTextField txtName;
    private JTextField txtAge;
    private JTextField txtTrainNumber;
    private JTextField txtSeats;
    private JComboBox<String> comboBoxClass;
    private JComboBox<String> comboBoxDestination;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    scratch window = new scratch();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public scratch() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(200, 200, 600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblTitle = new JLabel("Railway Ticket Reservation System");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblTitle.setBounds(120, 20, 350, 30);
        frame.getContentPane().add(lblTitle);

        JLabel lblName = new JLabel("Name:");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblName.setBounds(50, 80, 100, 25);
        frame.getContentPane().add(lblName);

        txtName = new JTextField();
        txtName.setBounds(150, 80, 150, 25);
        frame.getContentPane().add(txtName);

        JLabel lblAge = new JLabel("Age:");
        lblAge.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblAge.setBounds(50, 120, 100, 25);
        frame.getContentPane().add(lblAge);

        txtAge = new JTextField();
        txtAge.setBounds(150, 120, 150, 25);
        frame.getContentPane().add(txtAge);

        JLabel lblTrainNumber = new JLabel("Train Number:");
        lblTrainNumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblTrainNumber.setBounds(50, 160, 100, 25);
        frame.getContentPane().add(lblTrainNumber);

        txtTrainNumber = new JTextField();
        txtTrainNumber.setBounds(150, 160, 150, 25);
        frame.getContentPane().add(txtTrainNumber);

        JLabel lblClass = new JLabel("Class:");
        lblClass.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblClass.setBounds(50, 200, 100, 25);
        frame.getContentPane().add(lblClass);

        comboBoxClass = new JComboBox<String>();
        comboBoxClass.setBounds(150, 200, 150, 25);
        comboBoxClass.addItem("Sleeper");
        comboBoxClass.addItem("AC 1st Class");
        comboBoxClass.addItem("AC 2nd Class");
        comboBoxClass.addItem("AC 3rd Class");
        comboBoxClass.addItem("General");
        frame.getContentPane().add(comboBoxClass);

        JLabel lblDestination = new JLabel("Destination:");
        lblDestination.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblDestination.setBounds(50, 240, 100, 25);
        frame.getContentPane().add(lblDestination);

        comboBoxDestination = new JComboBox<String>();
        comboBoxDestination.setBounds(150, 240, 150, 25);
        comboBoxDestination.addItem("Delhi");
        comboBoxDestination.addItem("Mumbai");
        comboBoxDestination.addItem("Chennai");
        comboBoxDestination.addItem("Kolkata");
        comboBoxDestination.addItem("Hyderabad");
        frame.getContentPane().add(comboBoxDestination);

        JLabel lblSeats = new JLabel("Seats:");
        lblSeats.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblSeats.setBounds(50, 280, 100, 25);
        frame.getContentPane().add(lblSeats);

        txtSeats = new JTextField();
        txtSeats.setBounds(150, 280, 150, 25);
        frame.getContentPane().add(txtSeats);

        JButton btnReserve = new JButton("Reserve");
        btnReserve.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnReserve.setBounds(100, 320, 100, 30);
        btnReserve.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = txtName.getText();
                String ageStr = txtAge.getText();
                String trainNumber = txtTrainNumber.getText();
                String trainClass = (String) comboBoxClass.getSelectedItem();
                String destination = (String) comboBoxDestination.getSelectedItem();
                String seatsStr = txtSeats.getText();

                // Validate input
                if (name.isEmpty() || ageStr.isEmpty() || trainNumber.isEmpty() || seatsStr.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all the details", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    int age = Integer.parseInt(ageStr);
                    int seats = Integer.parseInt(seatsStr);
                    reserveTicket(name, age, trainNumber, trainClass, destination, seats);
                }
            }
        });
        frame.getContentPane().add(btnReserve);

        JButton btnReset = new JButton("Reset");
        btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnReset.setBounds(250, 320, 100, 30);
        btnReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtName.setText(null);
                txtAge.setText(null);
                txtTrainNumber.setText(null);
                txtSeats.setText(null);
                comboBoxClass.setSelectedIndex(0);
                comboBoxDestination.setSelectedIndex(0);
            }
        });
        frame.getContentPane().add(btnReset);

        JSeparator separator = new JSeparator();
        separator.setBounds(20, 70, 540, 2);
        frame.getContentPane().add(separator);
    }

    private void reserveTicket(String name, int age, String trainNumber, String trainClass, String destination, int seats) {
        JOptionPane.showMessageDialog(null, "Ticket Reserved Successfully!\n\n" +
                "Name: " + name + "\n" +
                "Age: " + age + "\n" +
                "Train Number: " + trainNumber + "\n" +
                "Class: " + trainClass + "\n" +
                "Destination: " + destination + "\n" +
                "Seats: " + seats, "Success", JOptionPane.INFORMATION_MESSAGE);
    }
}
