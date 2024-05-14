
package ds_projj;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class DS_projj {

    
    public static void main(String[] args) {
          SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CrowdManagementGUI gui = new CrowdManagementGUI();
                gui.setVisible(true);
            }
        }); 

    }
    
}
