/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package barri;

/**
 *
 * @author eDU
 */
import javax.swing.*;
import javax.swing.table.*;

public class TableIcon extends JFrame
{
    public TableIcon()
    {
        
        JLabel etiqueta = new JLabel();
       
        
        ImageIcon aboutIcon = new ImageIcon("about16.gif");
        ImageIcon addIcon = new ImageIcon("add.png");
        ImageIcon copyIcon = new ImageIcon("copy16.gif");
        
         etiqueta.setIcon(addIcon);

        
        String[] columnNames = {"Picture", "Description"};
        Object[][] data =
        {
            {aboutIcon, "About"},
            {addIcon, addIcon},
            {copyIcon, "Copy"},
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable( model )
        {
            //  Returning the Class of each column will allow different
            //  renderers to be used based on Class
            @Override
            public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
        };
        table.setPreferredScrollableViewportSize(table.getPreferredSize());

        JScrollPane scrollPane = new JScrollPane( table );
        getContentPane().add( scrollPane );
    }

    public static void main(String[] args)
    {
        TableIcon frame = new TableIcon();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setVisible(true);
    }

}
