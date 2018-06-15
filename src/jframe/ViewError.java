package jframe;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


import java.awt.Window.Type;
import java.util.ArrayList;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import javax.swing.JFormattedTextField;
import javax.swing.border.CompoundBorder;
import java.awt.Insets;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewError extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private JLabel lblNewLabel_1;
    
    DefaultTableModel MH = new DefaultTableModel();
    private JLabel lblJavaBasicExmination;
    private JButton button_1;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Throwable e) {
            e.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewError frame = new ViewError(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    void LoadError (ArrayList<Error> List){
        DefaultTableModel MH = new DefaultTableModel();
        MH.addColumn("Dong");
        MH.addColumn("Nam Sinh");
        MH.addColumn("So Dien Thoai");
        MH.addColumn("Dia Chi Email");
        MH.addColumn(" So Nam Kinh Nghiem");
        MH.addColumn("Thua Du Lieu");
        for(Error ele: List){
            Object[] t = new Object[6];
            int stt = 0;
//            t[stt++] = ele.getDong();
//            t[stt++] = (ele.isNgaySinh()) ? "Yes" : "";
//            t[stt++] = (ele.isSoDienThoai()) ? "Yes" : "";
//            t[stt++] = (ele.isEmail()) ? "Yes" : "";
//            t[stt++] = (ele.isNamKinhNgiem()) ? "Yes" : "";
//            t[stt++] = (ele.isThuaDuLieu()) ? "Yes" : "";
//            
            MH.addRow(t);
        }
        table.setModel(MH);
    }
    public ViewError(ArrayList<Error> error) {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent arg0) {
                LoadError(error);
            }
            
        });
        setTitle("List Error");
        setType(Type.POPUP);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 417);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(144, 238, 144));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setBounds(10, 134, 664, 233);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 11, 644, 211);
        panel.add(scrollPane);
        
        table = new JTable();
        table.setRowSelectionAllowed(false);
        table.setName("A");
        table.setIntercellSpacing(new Dimension(10, 5));
        table.setColumnSelectionAllowed(true);
        table.setAlignmentY(Component.BOTTOM_ALIGNMENT);
        table.setAlignmentX(Component.RIGHT_ALIGNMENT);
        table.setFocusable(false);
        table.setInheritsPopupMenu(true);
        table.setDragEnabled(true);
        table.setGridColor(new Color(0, 100, 0));
        table.setFillsViewportHeight(true);
        table.setFont(new Font("Tahoma", Font.BOLD, 13));
        table.setForeground(new Color(255, 255, 255));
        table.setBackground(new Color(60, 179, 113));
        scrollPane.setViewportView(table);
        
        lblNewLabel_1 = new JLabel("Picture");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\HunG\\Documents\\Eclipse\\DeThiMauJava01\\images.png"));
        lblNewLabel_1.setBounds(10, 11, 79, 69);
        contentPane.add(lblNewLabel_1);
        
        lblJavaBasicExmination = new JLabel("Title");
        lblJavaBasicExmination.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                System.out.println("ahuhu");
            }
        });
        lblJavaBasicExmination.setForeground(new Color(255, 255, 255));
        lblJavaBasicExmination.setFont(new Font("Tekton Pro", Font.PLAIN, 29));
        lblJavaBasicExmination.setHorizontalAlignment(SwingConstants.CENTER);
        lblJavaBasicExmination.setBounds(101, 11, 110, 36);
        contentPane.add(lblJavaBasicExmination);
        
        JButton btnNewButton = new JButton("Button");
        btnNewButton.setFocusable(false);
        btnNewButton.setFocusTraversalKeysEnabled(false);
        btnNewButton.setFocusPainted(false);
        btnNewButton.setBorder(UIManager.getBorder("CheckBoxMenuItem.border"));
        btnNewButton.setForeground(new Color(60, 179, 113));
        btnNewButton.setFont(new Font("Tekton Pro", Font.PLAIN, 17));
        btnNewButton.setBounds(325, 11, 110, 29);
        contentPane.add(btnNewButton);
        
        JButton button = new JButton("Button");
        button.setFocusTraversalKeysEnabled(false);
        button.setFocusable(false);
        button.setBackground(new Color(148, 0, 211));
        button.setForeground(new Color(255, 255, 255));
        button.setFont(new Font("Tekton Pro", Font.PLAIN, 17));
        button.setBounds(445, 11, 110, 29);
        contentPane.add(button);
        
        button_1 = new JButton("Button");
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        button_1.setBackground(new Color(169, 169, 169));
        button_1.setForeground(new Color(47, 79, 79));
        button_1.setFont(new Font("Tekton Pro", Font.PLAIN, 17));
        button_1.setFocusable(false);
        button_1.setFocusTraversalKeysEnabled(false);
        button_1.setFocusPainted(false);
        button_1.setBorder(UIManager.getBorder("DesktopIcon.border"));
        button_1.setBounds(564, 11, 110, 29);
        contentPane.add(button_1);
    }
}
