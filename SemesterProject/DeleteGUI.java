package JavaOOP.SemesterProject;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DeleteGUI {
    protected JTextField idText;
    private JButton delBtn;
    private JButton backBtn;
    Admin admin = new Admin();
    
    public DeleteGUI() {
// FRAME
        JFrame frame = new JFrame();
        frame.setSize(300, 280);
        frame.setLocation(530, 150);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
// PANEL
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        frame.add(panel);
        
// LABEL
        //Delete Customer
        JLabel delLabel = new JLabel("Delete");
        delLabel.setBounds(100, 20, 100, 25);
        delLabel.setForeground(Color.red);
        delLabel.setFont(new Font("Serif", Font.BOLD, 25));
        panel.add(delLabel);

        //Enter ID
        JLabel idLabel = new JLabel("Enter ID");
        idLabel.setBounds(103,60,60,25);
        idLabel.setFont(new Font("Serif",Font.BOLD,15));
        idLabel.setForeground(Color.BLACK);
        panel.add(idLabel);
        
// TEXT FIELD
        idText = new JTextField();
        panel.add(idText);
        idText.setBounds(103,90,60,25);
        idText.setVisible(true);
            
// Delete Button
        delBtn = new JButton("Delete");
        panel.add(delBtn);
        delBtn.setBounds(90, 140, 90, 25);
        delBtn.setForeground(Color.WHITE);
        delBtn.setBackground(Color.red);
        delBtn.setFont(new Font("Tahoma",Font.BOLD,15));
        delBtn.setBorderPainted(false);
        delBtn.addActionListener(e-> {
            String id = idText.getText();
            admin.delCustomer(id);
            JOptionPane.showMessageDialog(null, "Done");
        });

// BACK Button
        backBtn = new JButton("Back");
        panel.add(backBtn);
        backBtn.setBounds(90, 180, 90, 25);
        backBtn.setForeground(Color.WHITE);
        backBtn.setBackground(Color.black);
        backBtn.setFont(new Font("Tahoma",Font.BOLD,15));
        backBtn.setBorderPainted(false);

        backBtn.addActionListener(e->{
                frame.dispose();
                AdminGUI a =new AdminGUI();
        });

    }
}
