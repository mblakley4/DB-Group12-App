import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Vector;

public class Main {
    public static int selectedTableIndex = -1;
    public static String[] tableNames = { "book", "subject", "customer", "employee", "shipper", "supplier", "`order`", "order_detail"};
    public static Statement stmt;
    public static JTable queryResultTable;
    public static JLabel lblResult;
    public static JTextArea sql_text;

    public static void runQuery(String queryText) {
        try {
            ResultSet rs = stmt.executeQuery(queryText);
            ResultSetMetaData metadata = rs.getMetaData();
            int columnCount = metadata.getColumnCount();
            Vector<String> columnNames = new Vector<>();
            Vector<Vector<String>> data = new Vector<>();
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(metadata.getColumnName(i));
            }
            while (rs.next()) {
                Vector<String> row = new Vector<>();
                for (int i = 0; i < columnCount; i++) {
                    row.add(rs.getString(columnNames.get(i)));
                }
                data.add(row);
            }
            queryResultTable.setModel(new DefaultTableModel(data, columnNames));
            lblResult.setText("Query success!");
        } catch (SQLException ex) {
            lblResult.setText("SQLException: " + ex.getMessage());
            lblResult.setText("SQLState: " + ex.getSQLState());
            lblResult.setText("VendorError: " + ex.getErrorCode());
        }
        catch (Exception ex)
        {
            lblResult.setText("Unkown Error:" + ex.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor()
                    .newInstance();
            String dbName = "group12db";
            String port = "3306";
            String pwd = "";
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:"
                    + port + "/" + dbName + "?" +
                    "user=root&password=" + pwd + "&serverTimezone=UTC");
            stmt = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        catch (Exception e)
        {
            System.out.println("Unkown Error:" + e.getMessage());
        }

        // Creating the Frame
        JFrame frame = new JFrame("Ecommerce");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        // add spacer
        JLabel topSpacer = new JLabel();
        topSpacer.setPreferredSize(new Dimension(0, 10));
        frame.getContentPane().add(BorderLayout.NORTH, topSpacer);

        JLabel rightSpacer = new JLabel();
        rightSpacer.setPreferredSize(new Dimension(10, 0));
        frame.getContentPane().add(BorderLayout.EAST, rightSpacer);

        JLabel leftSpacer = new JLabel();
        leftSpacer.setPreferredSize(new Dimension(10, 0));
        frame.getContentPane().add(BorderLayout.WEST, leftSpacer);

        JLabel bottomSpacer = new JLabel();
        bottomSpacer.setPreferredSize(new Dimension(0, 10));
        frame.getContentPane().add(BorderLayout.SOUTH, bottomSpacer);

        // create main panel
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        // add left list-view to the main panel
        String[] table_names = { "Book", "Subject", "Customer", "Employee", "Shipper", "Supplier", "Order", "OrderDetails"};
        JList<String> table_list = new JList<>(table_names);
        mainPanel.add(BorderLayout.WEST, table_list);
        table_list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (selectedTableIndex != table_list.getSelectedIndex()) {
                    selectedTableIndex = table_list.getSelectedIndex();
                    runQuery("SELECT * FROM " + tableNames[selectedTableIndex]);
                }
            }
        });

        // add query textarea to the main panel
        JPanel queryPanel = new JPanel(); // the panel is not visible in output
        sql_text = new JTextArea();
        JButton btn_submit = new JButton("Submit");
        queryPanel.setLayout(new BorderLayout(10, 10));
        queryPanel.add(BorderLayout.CENTER, sql_text);
        queryPanel.add(BorderLayout.SOUTH, btn_submit);
        mainPanel.add(BorderLayout.CENTER, queryPanel);

        btn_submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runQuery(sql_text.getText());
            }
        });

        JPanel resultPanel = new JPanel(new BorderLayout());
        queryResultTable = new JTable();
        JScrollPane sp = new JScrollPane(queryResultTable);
        sp.setPreferredSize(new Dimension(300, 150));
        resultPanel.add(sp, BorderLayout.CENTER);
        lblResult = new JLabel("");
        resultPanel.add(lblResult, BorderLayout.SOUTH);
        mainPanel.add(resultPanel, BorderLayout.SOUTH);

        // Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setVisible(true);
    }
}
