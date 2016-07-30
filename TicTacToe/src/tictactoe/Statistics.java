/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;


/**
 *
 * @author Wendy
 */
public class Statistics extends javax.swing.JFrame {
Game game = new Game();
    /**
     * Creates new form Statistics
     */
    public Statistics() {
        
        initComponents();
            refreshScores();
    }
    private void refreshScores(){
        txtEasy.setText("Times Won: " + game.intEasyWins + "\n" + "Times Lost: " + game.intEasyLosses+ "\n" + "Times Tied: " + game.intEasyTies);
            txtMedium.setText("Times Won: " + game.intMedWins + "\n" + "Times Lost: " + game.intMedLosses + "\n" + "Times Tied: " + game.intMedTies);
            txtHard.setText("Times Won: " + game.intHardWins+ "\n" + "Times Lost: " + game.intHardLosses+ "\n" + "Times Tied: " + game.intHardTies);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMedium = new javax.swing.JTextArea();
        txtEasy = new javax.swing.JTextArea();
        txtHard = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));
        setMinimumSize(new java.awt.Dimension(455, 250));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Hobo Std", 0, 18)); // NOI18N
        jLabel1.setText("STATISTICS");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(170, 20, 120, 20);

        jLabel3.setFont(new java.awt.Font("Hobo Std", 0, 12)); // NOI18N
        jLabel3.setText("MEDIUM");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(200, 50, 49, 13);

        jLabel2.setFont(new java.awt.Font("Hobo Std", 0, 12)); // NOI18N
        jLabel2.setText("EASY");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(54, 52, 30, 13);

        jLabel4.setFont(new java.awt.Font("Hobo Std", 0, 12)); // NOI18N
        jLabel4.setText("HARD");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(350, 50, 33, 13);

        txtMedium.setEditable(false);
        txtMedium.setBackground(new java.awt.Color(204, 255, 204));
        txtMedium.setColumns(20);
        txtMedium.setFont(new java.awt.Font("Hobo Std", 0, 12)); // NOI18N
        txtMedium.setLineWrap(true);
        txtMedium.setRows(5);
        getContentPane().add(txtMedium);
        txtMedium.setBounds(155, 70, 140, 100);

        txtEasy.setEditable(false);
        txtEasy.setBackground(new java.awt.Color(204, 255, 204));
        txtEasy.setColumns(20);
        txtEasy.setFont(new java.awt.Font("Hobo Std", 0, 12)); // NOI18N
        txtEasy.setLineWrap(true);
        txtEasy.setRows(5);
        getContentPane().add(txtEasy);
        txtEasy.setBounds(10, 70, 140, 100);

        txtHard.setEditable(false);
        txtHard.setBackground(new java.awt.Color(204, 255, 204));
        txtHard.setColumns(20);
        txtHard.setFont(new java.awt.Font("Hobo Std", 0, 12)); // NOI18N
        txtHard.setLineWrap(true);
        txtHard.setRows(5);
        getContentPane().add(txtHard);
        txtHard.setBounds(300, 70, 140, 100);

        jButton1.setFont(new java.awt.Font("Hobo Std", 0, 12)); // NOI18N
        jButton1.setText("Return to Game");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(320, 180, 120, 30);

        jButton2.setFont(new java.awt.Font("Hobo Std", 0, 12)); // NOI18N
        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(10, 180, 120, 30);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tictactoe/background.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");
        jLabel5.setMinimumSize(new java.awt.Dimension(460, 240));
        jLabel5.setOpaque(true);
        jLabel5.setRequestFocusEnabled(false);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 450, 220);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        game.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        game.intEasyWins=0;
        game.intEasyLosses=0;
        game.intEasyTies=0;
        game.intMedWins=0;
        game.intMedLosses=0;
        game.intMedTies=0;
        game.intHardWins=0;
        game.intHardLosses=0;
        game.intHardTies=0;
        game.updateFiles();
        refreshScores();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextArea txtEasy;
    private javax.swing.JTextArea txtHard;
    private javax.swing.JTextArea txtMedium;
    // End of variables declaration//GEN-END:variables
}