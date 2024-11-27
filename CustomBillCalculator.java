import javax.swing.*;

public class CustomBillCalculator {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            
            JFrame frame = new JFrame("Custom Bill Calculator");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(500, 300);
            frame.setLayout(null);

            
            JLabel selectBillLabel = new JLabel("Select Bills:");
            selectBillLabel.setBounds(20, 20, 100, 25);
            frame.add(selectBillLabel);

            JRadioButton waterBillButton = new JRadioButton("Water Bill");
            waterBillButton.setBounds(120, 20, 100, 25);

            JRadioButton electricBillButton = new JRadioButton("Electric Bill");
            electricBillButton.setBounds(220, 20, 100, 25);

            ButtonGroup billGroup = new ButtonGroup();
            billGroup.add(waterBillButton);
            billGroup.add(electricBillButton);

            frame.add(waterBillButton);
            frame.add(electricBillButton);

            
            JLabel lastMeterLabel = new JLabel("Last Meter:");
            lastMeterLabel.setBounds(20, 60, 100, 25);
            frame.add(lastMeterLabel);

            JTextField lastMeterField = new JTextField();
            lastMeterField.setBounds(120, 60, 100, 25);
            frame.add(lastMeterField);

            
            JLabel currentMeterLabel = new JLabel("Current Meter:");
            currentMeterLabel.setBounds(20, 100, 100, 25);
            frame.add(currentMeterLabel);

            JTextField currentMeterField = new JTextField();
            currentMeterField.setBounds(120, 100, 100, 25);
            frame.add(currentMeterField);

            
            JLabel unitAmountLabel = new JLabel("Unit Amount:");
            unitAmountLabel.setBounds(20, 140, 100, 25);
            frame.add(unitAmountLabel);

            JTextField unitAmountField = new JTextField();
            unitAmountField.setBounds(120, 140, 100, 25);
            frame.add(unitAmountField);

            
            JLabel roomTypeLabel = new JLabel("Room Type:");
            roomTypeLabel.setBounds(250, 60, 100, 25);
            frame.add(roomTypeLabel);

            String[] roomTypes = {"Please Select", "Standard", "Deluxe", "Suite"};
            JComboBox<String> roomTypeComboBox = new JComboBox<>(roomTypes);
            roomTypeComboBox.setBounds(350, 60, 120, 25);
            frame.add(roomTypeComboBox);

            
            JLabel totalRentalLabel = new JLabel("Total Rental:");
            totalRentalLabel.setBounds(250, 100, 100, 25);
            frame.add(totalRentalLabel);

            JLabel totalRentalValue = new JLabel("____________");
            totalRentalValue.setBounds(350, 100, 120, 25);
            frame.add(totalRentalValue);

            
            JLabel resultLabel = new JLabel("Result:");
            resultLabel.setBounds(20, 180, 100, 25);
            frame.add(resultLabel);

            JTextField resultField = new JTextField();
            resultField.setBounds(120, 180, 350, 25);
            resultField.setEditable(false);
            frame.add(resultField);

            
            JButton calculateButton = new JButton("Calculate Bill");
            calculateButton.setBounds(120, 220, 150, 30);
            frame.add(calculateButton);

            
            JButton resetButton = new JButton("Reset");
            resetButton.setBounds(300, 220, 100, 30);
            frame.add(resetButton);

            
            calculateButton.addActionListener(e -> {
                try {
                    int lastMeter = Integer.parseInt(lastMeterField.getText());
                    int currentMeter = Integer.parseInt(currentMeterField.getText());

                    if (currentMeter < lastMeter) {
                        JOptionPane.showMessageDialog(frame,
                                "Current Meter must be greater than Last Meter!",
                                "Error",
                                JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    int unitAmount = Integer.parseInt(unitAmountField.getText());
                    int billRate = waterBillButton.isSelected() ? 5 : 6; // Water = 5, Electric = 6

                    int totalBill = unitAmount * billRate;
                    resultField.setText("Total Bill: " + totalBill);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame,
                            "Please enter valid numbers!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            });

            
            resetButton.addActionListener(e -> {
                billGroup.clearSelection();
                lastMeterField.setText("");
                currentMeterField.setText("");
                unitAmountField.setText("");
                roomTypeComboBox.setSelectedIndex(0);
                totalRentalValue.setText("____________");
                resultField.setText("");
            });

            
            frame.setVisible(true);
        });
    }
}
