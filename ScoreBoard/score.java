


package ScoreBoard;
import java.awt.event.KeyEvent;
import java.awt.Label;
import java.awt.event.KeyEvent;

import main.GamePanel;

/**
 *
 * @author DELL
 */
public class score extends javax.swing.JDialog {

    /**
     * Creates new form NewJDialog
     */

    public score(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tri = new Tri(this);
                      
                     
      

    }
        private Tri tri;
        GamePanel gp;
    public score(java.awt.Frame parent, boolean modal,GamePanel gp){
        super(parent, modal);
        this.gp = gp;

  
    
        initComponents();
             tri = new Tri(this);
                 
        //   this.setLocation(48,48);
        this.setLocationRelativeTo(parent);
      
        this.setResizable(false);
        this.setFocusable(true);
  
           this.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosed(java.awt.event.WindowEvent e) {
                      
                       
            
                        gp.start.pause = false;
                        if(gp.finish == true){
                            gp.restart();
                            gp.finish = false;
                         
                        }
                        reset();
             

                    
                }
                });
        // set();
           
         
    }
    public void insert(String name,int score){
     tri.insert(name,score);
    }
    public void finish(){
               tri.finish(gp.getScore());
             reset();
    }
    public void set(){
        text.append("Rank\tUsername\tScore\n");
        tri.execute();
            }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        jLabel1 = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                formComponentHidden(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
       

        text.setEditable(false);
        text.setBackground(new java.awt.Color(255, 255, 255));
        text.setColumns(3);
        text.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        text.setForeground(new java.awt.Color(0, 0, 0));
        text.setRows(5);
        text.setBorder(null);
        text.setVerifyInputWhenFocusTarget(false);
        
        jScrollPane1.setViewportView(text);

        jLabel1.setAlignment(java.awt.Label.CENTER);
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabel1.setEnabled(false);
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 255));
        jLabel1.setName("SCORE BOARD"); // NOI18N
        jLabel1.setText("SCORE BOARD");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                    

    private void formComponentHidden(java.awt.event.ComponentEvent evt) {                                     
System.out.println(2);
    }                                    

    private void jPanel1KeyPressed(java.awt.event.KeyEvent evt) {                                   
      
    }                                  

                                
    public void reset(){
            text.setText(" ");
            // set();
    }
    private void formKeyPressed(java.awt.event.KeyEvent evt) {                                
          if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
          
                    // Close the dialog when the space key is pressed
                    this.dispose();
                          this.gp.start.pause = false;
                  reset();
                }        // TODO add your handling code here:
    }                               

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(score.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(score.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(score.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(score.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                score dialog = new score(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    private Label jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextArea text;
    // End of variables declaration              
    // End of variables declaration                   
}