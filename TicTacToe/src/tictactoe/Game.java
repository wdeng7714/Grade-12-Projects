package tictactoe;
// Wendy Deng
// ICS3U assignment #3 TIC TAC TOE
// Ms.Kutchke
// April 2, 2015

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.border.LineBorder;
import java.util.Random;
import javax.swing.JLabel;

public class Game extends javax.swing.JFrame {

    /**
     *
     */
    public Game() {
        initComponents();
        btnBack.setVisible(false);
        btnQuit.setVisible(false);
        btnAgain.setVisible(false);
        lblMsg.setText("");
        this.setLayout(null);
        this.setSize(400, 275);
        //Read in scores from text files
        try {
            easy = new FileReader("Easy.txt");
            med = new FileReader("Medium.txt");
            hard = new FileReader("Hard.txt");
            reader = new BufferedReader(easy);
            intEasyWins = Integer.parseInt(reader.readLine());
            intEasyLosses = Integer.parseInt(reader.readLine());
            intEasyTies = Integer.parseInt(reader.readLine());
            reader.close();

            reader = new BufferedReader(med);
            intMedWins = Integer.parseInt(reader.readLine());
            intMedLosses = Integer.parseInt(reader.readLine());
            intMedTies = Integer.parseInt(reader.readLine());
            reader.close();

            reader = new BufferedReader(hard);
            intHardWins = Integer.parseInt(reader.readLine());
            intHardLosses = Integer.parseInt(reader.readLine());
            intHardTies = Integer.parseInt(reader.readLine());
            reader.close();

        } catch (IOException e) {
            System.out.println("File Not Found");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myGroup = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        rbtnEasy = new javax.swing.JRadioButton();
        rbtnMedium = new javax.swing.JRadioButton();
        rbtnHard = new javax.swing.JRadioButton();
        btnBack = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();
        btnAgain = new javax.swing.JButton();
        lblDifficulty = new javax.swing.JLabel();
        lblMsg = new javax.swing.JLabel();
        btnStats = new javax.swing.JButton();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridLayout(3, 3));

        jLabel1.setFont(new java.awt.Font("Hobo Std", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("T");
        jPanel2.add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Hobo Std", 0, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("I");
        jPanel2.add(jLabel2);

        jLabel3.setFont(new java.awt.Font("Hobo Std", 0, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("C");
        jPanel2.add(jLabel3);

        jLabel4.setFont(new java.awt.Font("Hobo Std", 0, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("T");
        jPanel2.add(jLabel4);

        jLabel5.setFont(new java.awt.Font("Hobo Std", 0, 36)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("A");
        jPanel2.add(jLabel5);

        jLabel6.setFont(new java.awt.Font("Hobo Std", 0, 36)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("C");
        jPanel2.add(jLabel6);

        jLabel7.setFont(new java.awt.Font("Hobo Std", 0, 36)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("T");
        jPanel2.add(jLabel7);

        jLabel8.setFont(new java.awt.Font("Hobo Std", 0, 36)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("O");
        jPanel2.add(jLabel8);

        jLabel9.setFont(new java.awt.Font("Hobo Std", 0, 36)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("E");
        jPanel2.add(jLabel9);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(185, 55, 200, 200);

        lblTitle.setFont(new java.awt.Font("Hobo Std", 0, 24)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("TIC TAC TOE");
        getContentPane().add(lblTitle);
        lblTitle.setBounds(-3, 20, 400, 25);

        btnStart.setFont(new java.awt.Font("Hobo Std", 0, 12)); // NOI18N
        btnStart.setText("Start Game");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        getContentPane().add(btnStart);
        btnStart.setBounds(30, 160, 120, 35);

        myGroup.add(rbtnEasy);
        rbtnEasy.setFont(new java.awt.Font("Hobo Std", 0, 12)); // NOI18N
        rbtnEasy.setText("Easy");
        rbtnEasy.setOpaque(false);
        getContentPane().add(rbtnEasy);
        rbtnEasy.setBounds(40, 91, 80, 20);

        myGroup.add(rbtnMedium);
        rbtnMedium.setFont(new java.awt.Font("Hobo Std", 0, 12)); // NOI18N
        rbtnMedium.setText("Medium");
        rbtnMedium.setOpaque(false);
        getContentPane().add(rbtnMedium);
        rbtnMedium.setBounds(40, 111, 71, 30);

        myGroup.add(rbtnHard);
        rbtnHard.setFont(new java.awt.Font("Hobo Std", 0, 12)); // NOI18N
        rbtnHard.setText("Hard");
        rbtnHard.setOpaque(false);
        getContentPane().add(rbtnHard);
        rbtnHard.setBounds(40, 140, 80, 21);

        btnBack.setFont(new java.awt.Font("Hobo Std", 0, 12)); // NOI18N
        btnBack.setText("Back");
        btnBack.setOpaque(false);
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        getContentPane().add(btnBack);
        btnBack.setBounds(50, 260, 65, 30);

        btnQuit.setFont(new java.awt.Font("Hobo Std", 0, 12)); // NOI18N
        btnQuit.setText("Quit");
        btnQuit.setOpaque(false);
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });
        getContentPane().add(btnQuit);
        btnQuit.setBounds(185, 260, 65, 30);

        btnAgain.setFont(new java.awt.Font("Hobo Std", 0, 12)); // NOI18N
        btnAgain.setText("Again");
        btnAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgainActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgain);
        btnAgain.setBounds(117, 260, 65, 30);
        btnAgain.getAccessibleContext().setAccessibleName("btnAgain");

        lblDifficulty.setFont(new java.awt.Font("Hobo Std", 0, 14)); // NOI18N
        lblDifficulty.setText("Pick A Difficulty");
        getContentPane().add(lblDifficulty);
        lblDifficulty.setBounds(30, 70, 140, 15);

        lblMsg.setFont(new java.awt.Font("Hobo Std", 0, 12)); // NOI18N
        lblMsg.setText("lblMessage");
        getContentPane().add(lblMsg);
        lblMsg.setBounds(50, 290, 230, 30);

        btnStats.setFont(new java.awt.Font("Hobo Std", 0, 12)); // NOI18N
        btnStats.setText("Statistics");
        btnStats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatsActionPerformed(evt);
            }
        });
        getContentPane().add(btnStats);
        btnStats.setBounds(30, 200, 120, 35);

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tictactoe/background.jpg"))); // NOI18N
        getContentPane().add(lblBackground);
        lblBackground.setBounds(0, 0, 450, 330);

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void updateFiles() {
        //Print updated scores into text file
        try {
            Easy = new FileWriter("Easy.txt");
            Med = new FileWriter("Medium.txt");
            Hard = new FileWriter("Hard.txt");

            printer = new PrintWriter(Easy);
            printer.println(intEasyWins);
            printer.println(intEasyLosses);
            printer.println(intEasyTies);
            printer.close();

            printer = new PrintWriter(Med);
            printer.println(intMedWins);
            printer.println(intMedLosses);
            printer.println(intMedTies);
            printer.close();

            printer = new PrintWriter(Hard);
            printer.println(intHardWins);
            printer.println(intHardLosses);
            printer.println(intHardTies);
            printer.close();
        } catch (IOException ex) {
            System.out.println("error");
        }
    }
    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        if (rbtnEasy.isSelected()) {
            difficulty = EASY;
            initialize();
        } else if (rbtnMedium.isSelected()) {
            difficulty = MED;
            initialize();
        } else if (rbtnHard.isSelected()) {
            difficulty = HARD;
            initialize();
        }
    }//GEN-LAST:event_btnStartActionPerformed
    private void initialize() {
        //clear the board and initialize variables, prepare board for game
        jPanel2.removeAll();
        intTurn = 0;
        win = false;
        setBoard();
        corner = false;
        edge = false;
        moved = false;
        center = false;
        temp_i = 0;
        temp_j = 0;

        lblClicked = lblTitle;
        clickLabel();
        lblTitle.setText("TIC TAC TOE");
        rbtnEasy.setVisible(false);
        rbtnMedium.setVisible(false);
        rbtnHard.setVisible(false);
        btnStart.setVisible(false);
        lblDifficulty.setVisible(false);
        btnBack.setVisible(true);
        btnQuit.setVisible(true);
        btnStats.setVisible(false);
        lblMsg.setVisible(true);

        this.setSize(300, 350);
        jPanel2.setLocation(50, jPanel2.getY());
        lblTitle.setSize(300, lblTitle.getHeight());
        lblMsg.setText("");
        btnAgain.setVisible(false);
    }
    private void btnStatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatsActionPerformed
        Statistics stats = new Statistics();
        stats.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnStatsActionPerformed
    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnQuitActionPerformed
    private void btnAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgainActionPerformed
        initialize();
    }//GEN-LAST:event_btnAgainActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:

        jPanel2.removeAll();

        rbtnEasy.setVisible(true);
        rbtnMedium.setVisible(true);
        rbtnHard.setVisible(true);
        btnStart.setVisible(true);
        lblDifficulty.setVisible(true);
        btnBack.setVisible(false);
        btnQuit.setVisible(false);
        btnStats.setVisible(true);
        lblMsg.setVisible(false);

        this.setSize(400, 275);
        jPanel2.setLocation(185, jPanel2.getY());
        lblTitle.setSize(400, lblTitle.getHeight());
        btnAgain.setVisible(false);
        jPanel2.add(jLabel1);
        jPanel2.add(jLabel2);
        jPanel2.add(jLabel3);
        jPanel2.add(jLabel4);
        jPanel2.add(jLabel5);
        jPanel2.add(jLabel6);
        jPanel2.add(jLabel7);
        jPanel2.add(jLabel8);
        jPanel2.add(jLabel9);
    }//GEN-LAST:event_btnBackActionPerformed
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Game game = new Game();
                game.setVisible(true);

            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgain;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnQuit;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStats;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblDifficulty;
    private javax.swing.JLabel lblMsg;
    private javax.swing.JLabel lblTitle;
    private javax.swing.ButtonGroup myGroup;
    private javax.swing.JRadioButton rbtnEasy;
    private javax.swing.JRadioButton rbtnHard;
    private javax.swing.JRadioButton rbtnMedium;
    // End of variables declaration//GEN-END:variables
    private final handlerClass handler = new handlerClass();
    private JLabel lblClicked = new JLabel();
    private final JLabel[][] lblBoard = new JLabel[3][3];
    private final Color UNFOCUSED = new Color(255, 228, 140);
    private final Color FOCUSED = new Color(255, 157, 40);
    private final Color WIN = new Color(255, 74, 60);
    private boolean win = false, center = false, moved = false, corner = false, edge = false;
    private final int EASY = 1, MED = 2, HARD = 3;
    public int difficulty, intTurn = 0, intEasyWins, intEasyLosses, intEasyTies, intMedWins, intMedLosses, intMedTies, intHardWins, intHardLosses, intHardTies, temp_i, temp_j, cornerX1, cornerX2, cornerY1, cornerY2;
    public FileReader easy, med, hard;
    public BufferedReader reader;
    public FileWriter Easy, Med, Hard;
    public PrintWriter printer;

    private void clickLabel() {
        if (win == false) {
            //Places an X at user's selected spot, increment turn count and check for win
            if (lblClicked.getText().equals("")) {
                lblClicked.setText(" X");
                intTurn++;
                if (intTurn > 2) {
                    checkWin();
                }
                if (intTurn < 5 && win == false) {
                    //CPU generates a spot based on selected difficulty
                    switch (difficulty) {
                        case EASY:
                            pickSpot(EASY);
                            break;
                        case MED:
                            pickSpot(MED);
                            break;
                        case HARD:
                            pickSpot(HARD);
                            break;
                    }
                    //check for win again after CPU makes a move
                    if (intTurn > 2) {
                        checkWin();
                    }
                }
                if (intTurn == 5 && win == false) {
                    //if no wins after 5 turns (board is full), declare tie and update file records
                    switch (difficulty) {
                        case EASY:
                            intEasyTies++;
                            break;
                        case MED:
                            intMedTies++;
                            break;
                        case HARD:
                            intHardTies++;
                            break;
                    }
                    updateFiles();
                    lblMsg.setText("TIE! THERE IS NO WINNER");
                    btnAgain.setVisible(true);
                }
            } else if (lblClicked.getText().equals("TIC TAC TOE")) {
                lblClicked.setText("x");
            }

        }

    }

    private void setBoard() {
        //create and add labels to board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                lblBoard[i][j] = new JLabel();
                lblBoard[i][j].setText("");
                lblBoard[i][j].setFont(lblBoard[i][j].getFont().deriveFont(50f));
                lblBoard[i][j].setForeground(Color.BLACK);
                lblBoard[i][j].setBackground(UNFOCUSED);
                lblBoard[i][j].setBorder(LineBorder.createGrayLineBorder());
                lblBoard[i][j].setOpaque(true);
                lblBoard[i][j].addMouseListener(handler);
                jPanel2.add(lblBoard[i][j]);
            }
        }

    }

    private void checkWin() {
        //horizontal check
        for (int i = 0; i < 3; i++) {
            //player wins
            win = (lblBoard[i][0].getText().equals(" X") && lblBoard[i][1].getText().equals(" X") && lblBoard[i][2].getText().equals(" X"));
            if (win) {
                playerWin();
                lblBoard[i][0].setBackground(WIN);
                lblBoard[i][1].setBackground(WIN);
                lblBoard[i][2].setBackground(WIN);
                break;
            } else {
                //CPU wins
                win = (lblBoard[i][0].getText().equals(" O") && lblBoard[i][1].getText().equals(" O") && lblBoard[i][2].getText().equals(" O"));
                if (win) {
                    playerLoss();
                    lblBoard[i][0].setBackground(WIN);
                    lblBoard[i][1].setBackground(WIN);
                    lblBoard[i][2].setBackground(WIN);
                    break;
                }
            }
        }
        //vertical check
        if (win == false) {
            for (int j = 0; j < 3; j++) {
                win = (lblBoard[0][j].getText().equals(" X") && lblBoard[1][j].getText().equals(" X") && lblBoard[2][j].getText().equals(" X"));
                if (win) {
                    //player wins
                    playerWin();
                    lblBoard[0][j].setBackground(WIN);
                    lblBoard[1][j].setBackground(WIN);
                    lblBoard[2][j].setBackground(WIN);
                    break;
                } else {
                    win = (lblBoard[0][j].getText().equals(" O") && lblBoard[1][j].getText().equals(" O") && lblBoard[2][j].getText().equals(" O"));
                    if (win) {
                        //cpu wins
                        playerLoss();
                        lblBoard[0][j].setBackground(WIN);
                        lblBoard[1][j].setBackground(WIN);
                        lblBoard[2][j].setBackground(WIN);
                        break;
                    }
                }
            }
        }
        //diagonal check
        if (win == false) {
            win = (lblBoard[0][0].getText().equals(" X") && lblBoard[1][1].getText().equals(" X") && lblBoard[2][2].getText().equals(" X"));
            if (win) {
                //player wins \ direction
                playerWin();
                lblBoard[0][0].setBackground(WIN);
                lblBoard[1][1].setBackground(WIN);
                lblBoard[2][2].setBackground(WIN);
            }
        }
        if (win == false) {
            win = (lblBoard[0][2].getText().equals(" X") && lblBoard[1][1].getText().equals(" X") && lblBoard[2][0].getText().equals(" X"));
            if (win) {
                //player wins / direction
                playerWin();
                lblBoard[1][1].setBackground(WIN);
                lblBoard[2][0].setBackground(WIN);
                lblBoard[0][2].setBackground(WIN);
            }
        }
        if (win == false) {

            win = (lblBoard[0][0].getText().equals(" O") && lblBoard[1][1].getText().equals(" O") && lblBoard[2][2].getText().equals(" O"));
            if (win) {
                //cpu wins \ direction
                playerLoss();
                lblBoard[0][0].setBackground(WIN);
                lblBoard[1][1].setBackground(WIN);
                lblBoard[2][2].setBackground(WIN);
            }
        }
        if (win == false) {
            win = (lblBoard[0][2].getText().equals(" O") && lblBoard[1][1].getText().equals(" O") && lblBoard[2][0].getText().equals(" O"));
            if (win) {
                //cpu wins / direction
                playerLoss();
                lblBoard[0][2].setBackground(WIN);
                lblBoard[1][1].setBackground(WIN);
                lblBoard[2][0].setBackground(WIN);
            }
        }
    }

    private void playerWin() {
        //update label text and win count
        lblMsg.setText("CONGRATIONS YOU WIN!");
        btnAgain.setVisible(true);
        switch (difficulty) {
            case EASY:
                intEasyWins++;
                break;
            case MED:
                intMedWins++;
                break;
            case HARD:
                intHardWins++;
                break;
            default:
        }
        updateFiles();
    }

    private void playerLoss() {
        //update label text and loss count
        lblMsg.setText("GAME OVER YOU LOSE");
        btnAgain.setVisible(true);
        switch (difficulty) {
            case EASY:
                intEasyLosses++;
                break;
            case MED:
                intMedLosses++;
                break;
            case HARD:
                intHardLosses++;
                break;
            default:

        }
        updateFiles();
    }

    private void pickSpot(int DIFFICULTY) {
        int i = 0, j = 0;
        //cpu picks a spot depending on selected difficulty
        Random rndNumber = new Random();
        switch (DIFFICULTY) {
            // picks random spot
            case EASY:
                do {
                    i = rndNumber.nextInt(3);
                    j = rndNumber.nextInt(3);
                } while (lblBoard[i][j].getText().equals("") == false);
                lblBoard[i][j].setText(" O");
                break;
            case MED:
                //check for horizontally connectable lines
                checkConnectHorizontal(i, j);
                if (moved == false) {
                    //check for vertically connectable lines
                    checkConnectVertical(i, j);
                }
                if (moved == false) {
                    //check for diagonally connectable lines
                    checkConnectDiagonal();
                }
                if (moved == false) {
                    //check for block: horizontal
                    checkBlockHorizontal(i, j);
                }
                if (moved == false) {
                    //check for block: vertical
                    checkBlockVertical(i, j);
                }
                if (moved == false) {
                    //check for block: diagonal
                    checkBlockDiagonal();
                }
                if (moved == false) {
                    //if there are no connectable lines or blocks, pick a random spot
                    do {
                        i = rndNumber.nextInt(3);
                        j = rndNumber.nextInt(3);
                    } while (lblBoard[i][j].getText().equals("") == false);
                    lblBoard[i][j].setText(" O");
                    moved = true;
                }
                break;
            case HARD:
                //specifics for the first turn
                if (intTurn == 1) {
                    //force a draw if player puts x in a corner on first turn 
                    if (lblBoard[0][0].getText().equals(" X") || lblBoard[0][2].getText().equals(" X") || lblBoard[2][0].getText().equals(" X") || lblBoard[2][2].getText().equals(" X")) {
                        lblBoard[1][1].setText(" O");
                        //if player starts with x in corner, places o in center
                        for (int x = 0; x < 3; x++) {
                            for (int y = 0; y < 3; y++) {
                                if (lblBoard[x][y].getText().equals(" X")) {
                                    temp_i = x;
                                    temp_j = y;
                                    //find the spots cpu must avoid pick next turn if player picks a certain spot
                                    if (temp_i + 1 < 3) {
                                        cornerX1 = temp_i + 1;
                                    } else {
                                        cornerX1 = temp_i - 1;
                                    }
                                    cornerY1 = temp_j;
                                    if (temp_j + 1 < 3) {
                                        cornerY2 = temp_j + 1;
                                    } else {
                                        cornerY2 = temp_j - 1;
                                    }
                                    cornerX2 = temp_i;
                                    break;
                                }
                            }
                        }
                        corner = true;
                    }
                    //try to win if player puts x on an edge
                    if (lblBoard[0][1].getText().equals(" X") || lblBoard[1][0].getText().equals(" X") || lblBoard[1][2].getText().equals(" X") || lblBoard[2][1].getText().equals(" X")) {
                        // if player starts with x on edge, place o in center
                        lblBoard[1][1].setText(" O");
                        edge = true;
                    }
                    //force a draw if player puts x in center on first turn
                    if (lblBoard[1][1].getText().equals(" X")) {
                        //if player starts with x in center, place o on a corner, take note of the corner opposite to the selected one
                        switch (rndNumber.nextInt(4)) {
                            case 0:
                                lblBoard[0][0].setText(" O");
                                temp_i = 2;
                                temp_j = 2;
                                break;
                            case 1:
                                lblBoard[0][2].setText(" O");
                                temp_i = 2;
                                temp_j = 0;
                                break;
                            case 2:
                                lblBoard[2][0].setText(" O");
                                temp_i = 0;
                                temp_j = 2;
                                break;
                            case 3:
                                lblBoard[2][2].setText(" O");
                                temp_i = 0;
                                temp_j = 0;
                                break;
                            default:
                        }
                        center = true;
                    }
                    moved = true;
                }
                //check for connects
                if (moved == false) {
                    checkConnectHorizontal(i, j);
                }
                if (moved == false) {
                    checkConnectVertical(i, j);
                }
                if (moved == false) {
                    checkConnectDiagonal();
                }
                //check for blocks
                if (moved == false) {
                    checkBlockHorizontal(i, j);
                }
                if (moved == false) {
                    checkBlockVertical(i, j);
                }
                if (moved == false) {
                    checkBlockDiagonal();
                }
                //specifics for second turn
                if (intTurn == 2) {
                    if (corner && moved == false) {
//                        if player put x in corner on first turn, place second move on an edge while avoiding the spots adject to players first move
                        do {//loops until finds a valid spot
                            switch (rndNumber.nextInt(4)) {
                                case 0:
                                    if ((lblBoard[0][1] != lblBoard[cornerX1][cornerY1] && lblBoard[0][1] != lblBoard[cornerX2][cornerY2])) {
                                        if (lblBoard[0][1].getText().equals("")) {
                                            lblBoard[0][1].setText(" O");
                                            moved = true;
                                        }
                                    }
                                    break;
                                case 1:
                                    if ((lblBoard[1][0] != lblBoard[cornerX1][cornerY1] && lblBoard[1][0] != lblBoard[cornerX2][cornerY2])) {
                                        if (lblBoard[1][0].getText().equals("")) {
                                            lblBoard[1][0].setText(" O");
                                            moved = true;
                                        }
                                    }
                                    break;
                                case 2:
                                    if ((lblBoard[1][2] != lblBoard[cornerX1][cornerY1] && lblBoard[1][2] != lblBoard[cornerX2][cornerY2])) {
                                        if (lblBoard[1][2].getText().equals("")) {
                                            lblBoard[1][2].setText(" O");
                                            moved = true;
                                        }
                                    }
                                    break;
                                case 3:
                                    if ((lblBoard[2][1] != lblBoard[cornerX1][cornerY1] && lblBoard[2][1] != lblBoard[cornerX2][cornerY2])) {
                                        if (lblBoard[2][1].getText().equals("")) {
                                            lblBoard[2][1].setText(" O");
                                            moved = true;
                                        }
                                    }
                                    break;
                            }
                        } while (moved == false);
                    }
                    if (edge && moved == false) {
                        // if player starts with x on an edge, then puts x in opposite edge, place o in corner
                        if ((lblBoard[1][0].getText().equals(" X") && lblBoard[1][2].getText().equals(" X")) || (lblBoard[0][1].getText().equals(" X") && lblBoard[2][1].getText().equals(" X"))) {
                            switch (rndNumber.nextInt(4)) {
                                case 0:
                                    lblBoard[0][0].setText(" O");
                                    break;
                                case 1:
                                    lblBoard[0][2].setText(" O");
                                    break;
                                case 2:
                                    lblBoard[2][0].setText(" O");
                                    break;
                                case 3:
                                    lblBoard[2][2].setText(" O");
                                    break;
                                default:
                            }
                            moved = true;
                        }
                    }
                    if (center && moved == false) {
                        //if player starts with x in center and then places x in the opposite corner, place o in one of the remaining corners
                        if (lblBoard[temp_i][temp_j].getText().equals(" X")) {
                            do {
                                switch (rndNumber.nextInt(4)) {
                                    case 0:
                                        if (lblBoard[0][0].getText().equals("")) {
                                            lblBoard[0][0].setText(" O");
                                            moved = true;
                                        }
                                        break;
                                    case 1:
                                        if (lblBoard[0][2].getText().equals("")) {
                                            lblBoard[0][2].setText(" O");
                                            moved = true;
                                        }
                                        break;
                                    case 2:
                                        if (lblBoard[2][0].getText().equals("")) {
                                            lblBoard[2][0].setText(" O");
                                            moved = true;
                                        }
                                        break;
                                    case 3:
                                        if (lblBoard[2][2].getText().equals("")) {
                                            lblBoard[2][2].setText(" O");
                                            moved = true;
                                        }
                                        break;
                                    default:
                                }
                            } while (moved == false);
                        }
                    }
                }
                if (moved == false) {
                    //pick a random spot 
                    do {
                        i = rndNumber.nextInt(3);
                        j = rndNumber.nextInt(3);
                    } while (lblBoard[i][j].getText().equals("") == false);
                    lblBoard[i][j].setText(" O");
                    moved = true;
                }
                break;
        }
        moved = false;
    }

    private void checkBlockHorizontal(int i, int j) {
        //checking and block a possible horizontal win from player
        for (i = 0; i < 3; i++) {
            if (lblBoard[i][0].getText().equals(" X") && lblBoard[i][1].getText().equals(" X")) {
                j = 2;
                if (lblBoard[i][j].getText().equals("")) {
                    lblBoard[i][j].setText(" O");
                    moved = true;
                    break;
                }
            } else if (lblBoard[i][0].getText().equals(" X") && lblBoard[i][2].getText().equals(" X")) {
                j = 1;
                if (lblBoard[i][j].getText().equals("")) {
                    lblBoard[i][j].setText(" O");
                    moved = true;
                    break;
                }
            } else if (lblBoard[i][1].getText().equals(" X") && lblBoard[i][2].getText().equals(" X")) {
                j = 0;
                if (lblBoard[i][j].getText().equals("")) {
                    lblBoard[i][j].setText(" O");
                    moved = true;
                    break;
                }
            }
        }
    }

    private void checkBlockVertical(int i, int j) {
        //checking and block a possible vertical win from player
        for (j = 0; j < 3; j++) {
            if (lblBoard[0][j].getText().equals(" X") && lblBoard[1][j].getText().equals(" X")) {
                i = 2;
                if (lblBoard[i][j].getText().equals("")) {
                    lblBoard[i][j].setText(" O");
                    moved = true;
                    break;
                }
            } else if (lblBoard[0][j].getText().equals(" X") && lblBoard[2][j].getText().equals(" X")) {
                i = 1;
                if (lblBoard[i][j].getText().equals("")) {
                    lblBoard[i][j].setText(" O");
                    moved = true;
                    break;
                }
            } else if (lblBoard[2][j].getText().equals(" X") && lblBoard[1][j].getText().equals(" X")) {
                i = 0;
                if (lblBoard[i][j].getText().equals("")) {
                    lblBoard[i][j].setText(" O");
                    moved = true;
                    break;
                }
            }
        }
    }

    private void checkBlockDiagonal() {
        //checking and block a possible diagonal win from player
        if (lblBoard[0][0].getText().equals(" X") && lblBoard[1][1].getText().equals(" X")) {
            if (lblBoard[2][2].getText().equals("")) {
                lblBoard[2][2].setText(" O");
                moved = true;
            }
        } else if (lblBoard[0][0].getText().equals(" X") && lblBoard[2][2].getText().equals(" X")) {
            if (lblBoard[1][1].getText().equals("")) {
                lblBoard[1][1].setText(" O");
                moved = true;
            }
        } else if (lblBoard[1][1].getText().equals(" X") && lblBoard[2][2].getText().equals(" X")) {
            if (lblBoard[0][0].getText().equals("")) {
                lblBoard[0][0].setText(" O");
                moved = true;
            }
        } else if (lblBoard[0][2].getText().equals(" X") && lblBoard[1][1].getText().equals(" X")) {
            if (lblBoard[2][0].getText().equals("")) {
                lblBoard[2][0].setText(" O");
                moved = true;
            }
        } else if (lblBoard[0][2].getText().equals(" X") && lblBoard[2][0].getText().equals(" X")) {
            if (lblBoard[1][1].getText().equals("")) {
                lblBoard[1][1].setText(" O");
                moved = true;
            }
        } else if (lblBoard[2][0].getText().equals(" X") && lblBoard[1][1].getText().equals(" X")) {
            if (lblBoard[0][2].getText().equals("")) {
                lblBoard[0][2].setText(" O");
                moved = true;
            }
        }
    }

    private void checkConnectHorizontal(int i, int j) {
        //check for a possible horizontal win
        for (i = 0; i < 3; i++) {
            if (lblBoard[i][0].getText().equals(" O") && lblBoard[i][1].getText().equals(" O")) {
                j = 2;
                if (lblBoard[i][j].getText().equals("")) {
                    lblBoard[i][j].setText(" O");
                    moved = true;
                    break;
                }
            } else if (lblBoard[i][0].getText().equals(" O") && lblBoard[i][2].getText().equals(" O")) {
                j = 1;
                if (lblBoard[i][j].getText().equals("")) {
                    lblBoard[i][j].setText(" O");
                    moved = true;
                    break;
                }
            } else if (lblBoard[i][1].getText().equals(" O") && lblBoard[i][2].getText().equals(" O")) {
                j = 0;
                if (lblBoard[i][j].getText().equals("")) {
                    lblBoard[i][j].setText(" O");
                    moved = true;
                    break;
                }
            }
        }
    }

    private void checkConnectVertical(int i, int j) {
        //check for a possible vertical win
        for (j = 0; j < 3; j++) {
            if (lblBoard[0][j].getText().equals(" O") && lblBoard[1][j].getText().equals(" O")) {
                i = 2;
                if (lblBoard[i][j].getText().equals("")) {
                    lblBoard[i][j].setText(" O");
                    moved = true;
                    break;
                }
            } else if (lblBoard[0][j].getText().equals(" O") && lblBoard[2][j].getText().equals(" O")) {
                i = 1;
                if (lblBoard[i][j].getText().equals("")) {
                    lblBoard[i][j].setText(" O");
                    moved = true;
                    break;
                }
            } else if (lblBoard[2][j].getText().equals(" O") && lblBoard[1][j].getText().equals(" O")) {
                i = 0;
                if (lblBoard[i][j].getText().equals("")) {
                    lblBoard[i][j].setText(" O");
                    moved = true;
                    break;
                }
            }
        }
    }

    private void checkConnectDiagonal() {
        //check for a possible diagonal win
        if (lblBoard[0][0].getText().equals(" O") && lblBoard[1][1].getText().equals(" O")) {
            if (lblBoard[2][2].getText().equals("")) {
                lblBoard[2][2].setText(" O");
                moved = true;
            }
        }
        if (lblBoard[0][0].getText().equals(" O") && lblBoard[2][2].getText().equals(" O")) {
            if (lblBoard[1][1].getText().equals("")) {
                moved = true;
            }
        }
        if (lblBoard[1][1].getText().equals(" O") && lblBoard[2][2].getText().equals(" O")) {
            if (lblBoard[0][0].getText().equals("")) {
                lblBoard[0][0].setText(" O");
                moved = true;
            }
        }
        if (lblBoard[0][2].getText().equals(" O") && lblBoard[1][1].getText().equals(" O")) {

            if (lblBoard[2][0].getText().equals("")) {
                lblBoard[2][0].setText(" O");
                moved = true;
            }
        }
        if (lblBoard[0][2].getText().equals(" O") && lblBoard[2][0].getText().equals(" O")) {
            if (lblBoard[1][1].getText().equals("")) {
                lblBoard[1][1].setText(" O");
                moved = true;
            }
        }
        if (lblBoard[2][0].getText().equals(" O") && lblBoard[1][1].getText().equals(" O")) {
            if (lblBoard[0][2].getText().equals("")) {
                lblBoard[0][2].setText(" O");
                moved = true;
            }
        }
    }

    private class handlerClass implements MouseListener {
//adds mouse listener to the dynamically created labels

        @Override
        public void mouseClicked(MouseEvent me) {
            lblClicked = (JLabel) me.getSource();
            clickLabel();
        }

        @Override
        public void mousePressed(MouseEvent me) {
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            lblClicked = (JLabel) me.getSource();
            if (win == false) {
                lblClicked.setBackground(FOCUSED);
            }
        }

        @Override
        public void mouseExited(MouseEvent me) {
            lblClicked = (JLabel) me.getSource();
            if (win == false) {
                lblClicked.setBackground(UNFOCUSED);
            }
        }
    }
}
