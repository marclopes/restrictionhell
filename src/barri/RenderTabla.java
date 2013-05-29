/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package barri;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Carlos
 */
class RenderTabla implements TableCellRenderer
{
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)  {
        
// Creamos la etiqueta
JLabel etiqueta = new JLabel();

// Ponemos un color distinto para la etiqueta según si la celda está o no seleccionada.
if (isSelected)
    etiqueta.setBackground (Color.CYAN);
else
    etiqueta.setBackground (Color.YELLOW); 

// Si el objeto que nos pasan es un String, lo ponemos en el JLabel.
if (value instanceof String)
{ 
    // Para que el JLabel haga caso al color de fondo, tiene que ser opaco. 
    etiqueta.setOpaque(true);
    etiqueta.setText((String)value);
} 

// Si el objeto que nos pasan es Integer, metemos un icono en la etiqueta, en función del valor del Integer.
if (value instanceof Integer) 
{ 
    int valor = ((Integer)value).intValue(); 

    // Ponemos como tooltip el valor
    etiqueta.setToolTipText (Integer.toString (valor)); 
} 

// Devolvemos la etiqueta que acabamos de crear.
return etiqueta;
 
    }
}
