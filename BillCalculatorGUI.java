import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class BillCalculatorGUI {
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Bill Calculator");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        
        JLabel lblSelectBills = new JLabel("Select Bills");
        lblSelectBills.setBounds(20, 20, 100, 25);
        frame.add(lblSelectBills);

        JRadioButton rbWaterBill = new JRadioButton("Water Bill");
        rbWaterBill.setBounds(20, 50, 100, 25);
        JRadioButton rbElectricBill = new JRadioButton("Electric Bill");
        rbElectricBill.setBounds(20, 80, 100, 25);

        ButtonGroup billGroup = new ButtonGroup();
        billGroup.add(rbWaterBill);
        billGroup.add(rbElectricBill);

        frame.add(rbWaterBill);
        frame.add(rbElectricBill);

        
        JLabel lblLastMeter = new JLabel("Last Meter");
        lblLastMeter.setBounds(20, 120, 100, 25);
        JTextField txtLastMeter = new JTextField();
        txtLastMeter.setBounds(120, 120, 100, 25);
        frame.add(lblLastMeter);
        frame.add(txtLastMeter);

        
        JLabel lblCurrentMeter = new JLabel("Current Meter");
        lblCurrentMeter.setBounds(20, 160, 100, 25);
        JTextField txtCurrentMeter = new JTextField();
        txtCurrentMeter.setBounds(120, 160, 100, 25);
        frame.add(lblCurrentMeter);
        frame.add(txtCurrentMeter);

        
        JLabel lblUnitAmount = new JLabel("Unit Amount");
        lblUnitAmount.setBounds(20, 200, 100, 25);
        JTextField txtUnitAmount = new JTextField();
        txtUnitAmount.setBounds(120, 200, 100, 25);
        frame.add(lblUnitAmount);
        frame.add(txtUnitAmount);

        
        JLabel lblResult = new JLabel("Result");
        lblResult.setBounds(20, 240, 100, 25);
        JTextField txtResult = new JTextField();
        txtResult.setBounds(120, 240, 100, 25);
        frame.add(lblResult);
        frame.add(txtResult);

        
        JLabel lblRoomType = new JLabel("Room Type");
        lblRoomType.setBounds(250, 20, 100, 25);
        frame.add(lblRoomType);

        String[] roomTypes = {"Please Select", "Standard", "Single Bed", "Double Bed"};
        JComboBox<String> comboRoomType = new JComboBox<>(roomTypes);
        comboRoomType.setBounds(350, 20, 120, 25);
        frame.add(comboRoomType);

        
        JLabel lblTotalRental = new JLabel("Total Rental");
        lblTotalRental.setBounds(250, 120, 100, 25);
        JTextField txtTotalRental = new JTextField();
        txtTotalRental.setBounds(350, 120, 120, 25);
        txtTotalRental.setEditable(false);
        frame.add(lblTotalRental);
        frame.add(txtTotalRental);

        
        JButton btnCalculate = new JButton("Calculate Bill");
        btnCalculate.setBounds(120, 300, 150, 30);
        frame.add(btnCalculate);

        
        JButton btnReset = new JButton("Reset");
        btnReset.setBounds(300, 300, 100, 30);
        frame.add(btnReset);

        
        btnCalculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int lastMeter = Integer.parseInt(txtLastMeter.getText());
                    int currentMeter = Integer.parseInt(txtCurrentMeter.getText());
                    String roomType = (String) comboRoomType.getSelectedItem();

                    if (currentMeter < lastMeter) {
                        JOptionPane.showMessageDialog(frame, "Current Meter must be greater than Last Meter!");
                        return;
                    }

                    int usage = currentMeter - lastMeter;
                    int unitAmount = usage;
                    txtUnitAmount.setText(String.valueOf(unitAmount));

                    int billAmount = 0;
                    if (rbWaterBill.isSelected()) {
                        billAmount = unitAmount * 5;
                    } else if (rbElectricBill.isSelected()) {
                        billAmount = unitAmount * 6;
                    } else {
                        JOptionPane.showMessageDialog(frame, "Please select a bill type!");
                        return;
                    }

                    txtResult.setText(String.valueOf(billAmount));

                    int roomCost = 0;
                    switch (roomType) {
                        case "Standard":
                            roomCost = 3000;
                            break;
                        case "Deluxe":
                            roomCost = 5000;
                            break;
                        case "Suite":
                            roomCost = 8000;
                            break;
                        default:
                            JOptionPane.showMessageDialog(frame, "Please select a room type!");
                            return;
                    }

                    int totalRental = billAmount + roomCost;
                    txtTotalRental.setText(String.valueOf(totalRental));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter valid numbers!");
                }
            }
        });

        
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtLastMeter.setText("");
                txtCurrentMeter.setText("");
                txtUnitAmount.setText("");
                txtResult.setText("");
                txtTotalRental.setText("");
                billGroup.clearSelection();
                comboRoomType.setSelectedIndex(0);
            }
        });

        
        frame.setVisible(true);
    }
}
