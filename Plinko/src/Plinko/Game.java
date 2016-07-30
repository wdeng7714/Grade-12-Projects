/* Wendy Deng 
 ICS3U Assignment #2
 Ms Kutschke
 Feb 06, 2015
 Plinko
  */
package Plinko;

import java.util.Random;
import javax.swing.*;
import java.awt.event.*;
public final class Game extends javax.swing.JFrame {

    public Timer displayText;
    public Timer time;
    public Timer dropChip;
    public Timer displayQuestion;
    int txtCounter = 0;

    public Game() {
        //timer that allows text to display 1 letter at a time
            this.displayText = new Timer(50, (ActionEvent e) -> {
            if (txtCounter < msg1.length()) {
                lblMsg1.setText(lblMsg1.getText() + String.valueOf(msg1.charAt(txtCounter)));
            } else if (txtCounter >= msg1.length() && txtCounter < msg1.length() + msg2.length()) {
                lblMsg2.setText(lblMsg2.getText() + String.valueOf(msg2.charAt(txtCounter - msg1.length())));

            } else {
                displayText.stop();
                lblPrize1.setVisible(true);
                lblPrize2.setVisible(true);
                picPrize.setVisible(true);
            }

            txtCounter++;

        });

        //timer that shirnks the question panel
        this.time = new Timer(10, (ActionEvent e) -> {
            pnlQuestion.setSize(pnlQuestion.getWidth() - 20, pnlQuestion.getHeight() - 20);
            pnlQuestion.setLocation(pnlQuestion.getX() + 10, pnlQuestion.getY() + 10);
            if (pnlQuestion.getWidth() < 21 || pnlQuestion.getHeight() < 21) {
                time.stop();
                pnlQuestion.setVisible(false);
            }
        });

        //timer overseeing the chip dropping
        this.dropChip = new Timer(10, (ActionEvent e) -> {
            lblClicked.setLocation(lblClicked.getX(), lblClicked.getY() + 1);
            //check if chip hits bottom
            if (lblClicked.getLocation().y >= pnlChips.getHeight() - lblClicked.getHeight()) {
                dropChip.stop();
                //which point did it land on
                landChip();
            } else {
                //switches direction of chip
                if (intMove >= 10) {
                    switch (generateRndNumber(OPERATOR)) {
                        case ADD:
                            distX = 1;
                            break;
                        case SUBTRACT:
                            distX = -1;
                            break;
                        default:
                    }
                    intMove = 0;
                }
                lblClicked.setLocation(lblClicked.getX() + distX, lblClicked.getY());
                //check if chip hits side
                switch (lblClicked.getX()) {
                    case 0:
                        distX = 1;
                        break;
                    case 280:
                        distX = -1;
                        break;
                    default:
                }
                intMove++;
            }
        });

        initComponents();

        setLayout(null);
        pnlChips.setLayout(null);
        pnlQuestion.setSize(630, 550);
        btnPlayAgain.setVisible(false);
        btnPlayAgain.setEnabled(false);
        btnGo.setVisible(false);
        txtAnswer.setVisible(false);
        lblPrize1.setVisible(false);
        lblPrize2.setVisible(false);
        picPrize.setVisible(false);
    }

    void landChip() {
        //determines which slot chip landed in
        if (lblClicked.getX() > 0 && lblClicked.getX() < lblClicked.getWidth() / 2) {
            lblClicked.setLocation(0 * spaceX, lblClicked.getY());
            intPoints = countPoints(0, intPoints);
        } else if (lblClicked.getX() > spaceX - lblClicked.getWidth() / 2 && lblClicked.getX() < spaceX + lblClicked.getWidth() / 2) {
            lblClicked.setLocation(1 * spaceX, lblClicked.getY());
            intPoints = countPoints(1, intPoints);
        } else if (lblClicked.getX() > 2 * spaceX - lblClicked.getWidth() / 2 && lblClicked.getX() < 2 * spaceX + lblClicked.getWidth() / 2) {
            lblClicked.setLocation(2 * spaceX, lblClicked.getY());
            intPoints = countPoints(2, intPoints);
        } else if (lblClicked.getX() > 3 * spaceX - lblClicked.getWidth() / 2 && lblClicked.getX() < 3 * spaceX + lblClicked.getWidth() / 2) {
            lblClicked.setLocation(3 * spaceX, lblClicked.getY());
            intPoints = countPoints(3, intPoints);
        } else if (lblClicked.getX() > 4 * spaceX - lblClicked.getWidth() / 2 && lblClicked.getX() < 4 * spaceX + lblClicked.getWidth() / 2) {
            lblClicked.setLocation(4 * spaceX, lblClicked.getY());
            intPoints = countPoints(4, intPoints);

        } else if (lblClicked.getX() > 5 * spaceX - lblClicked.getWidth() / 2 && lblClicked.getX() < 5 * spaceX + lblClicked.getWidth() / 2) {
            lblClicked.setLocation(5 * spaceX, lblClicked.getY());
            intPoints = countPoints(5, intPoints);

        } else if (lblClicked.getX() > 6 * spaceX - lblClicked.getWidth() / 2 && lblClicked.getX() < 6 * spaceX + lblClicked.getWidth() / 2) {
            lblClicked.setLocation(6 * spaceX, lblClicked.getY());
            intPoints = countPoints(6, intPoints);
        } else if (lblClicked.getX() > 7 * spaceX - lblClicked.getWidth() / 2 && lblClicked.getX() < 7 * spaceX + lblClicked.getWidth() / 2) {
            lblClicked.setLocation(7 * spaceX, lblClicked.getY());
            intPoints = countPoints(7, intPoints);
        } else if (lblClicked.getX() > 8 * spaceX - lblClicked.getWidth() / 2 && lblClicked.getX() < 8 * spaceX + lblClicked.getWidth() / 2) {
            lblClicked.setLocation(8 * spaceX, lblClicked.getY());
            intPoints = countPoints(8, intPoints);
        } else if (lblClicked.getX() > 9 * spaceX - lblClicked.getWidth() / 2 && lblClicked.getX() < 9 * spaceX + lblClicked.getWidth() / 2) {
            lblClicked.setLocation(9 * spaceX, lblClicked.getY());
            intPoints = countPoints(9, intPoints);
        }
        //check if there are remaining chips
        if (intChip > 1) {
            //drops another chip
            intChip--;
            btnContinue.setVisible(true);
            btnContinue.setEnabled(true);

        } else {
            
            lblSeeResult.setVisible(true);
            btnSeeResult.setVisible(true);
            btnSeeResult.setEnabled(true);
            btnContinue.setVisible(true);
            btnContinue.setEnabled(false);
            btnContinue.setVisible(false);
            btnContinue.setEnabled(false);

        }
        updateDisplay();

    }

    int generateRndNumber(int TYPE) {
        int intNum;
        // method that generates a random number between 1 and 50
        Random intRnd = new Random();
        switch (TYPE) {
            case 1:
                intNum = intRnd.nextInt(50) + 1;
                break;
            case 2:
                intNum = intRnd.nextInt(3) + 1;
                break;
            default:
                intNum = 0;
        }
        return intNum;
    }

    void generateEquation() {
        //assigns random number value to components of the equation
        number1 = generateRndNumber(VALUE);
        number2 = generateRndNumber(VALUE);
        operator = generateRndNumber(OPERATOR);
        jLabel1.setText("Question #" + QCounter);
       //assemble equation using the randomly generated numbers and operator
        switch (operator) {
            case ADD:
                lblEquation.setText(number1 + " + " + number2 + "= ");
                answer = number1 + number2;
                break;
            case SUBTRACT:
                lblEquation.setText(number1 + " - " + number2 + "= ");
                answer = number1 - number2;
                break;
            case MULTIPLY:
                  lblEquation.setText(number1 + " x " + number2 + "= ");
                answer = number1 * number2;
                break;
            default:
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlQuestion = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblEquation = new javax.swing.JLabel();
        txtAnswer = new javax.swing.JTextField();
        btnGo = new javax.swing.JButton();
        btnStart = new javax.swing.JButton();
        lblMsg = new javax.swing.JLabel();
        lblChipCount = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        bgQuestion = new javax.swing.JLabel();
        btnContinue = new javax.swing.JButton();
        lblMoneyDisplay = new javax.swing.JLabel();
        lblChipDisplay = new javax.swing.JLabel();
        lblSeeResult = new javax.swing.JTextArea();
        btnSeeResult = new javax.swing.JButton();
        pnlResult = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblMsg1 = new javax.swing.JLabel();
        lblMsg2 = new javax.swing.JLabel();
        picPrize = new javax.swing.JLabel();
        lblPrize2 = new javax.swing.JLabel();
        lblPrize1 = new javax.swing.JLabel();
        btnQuit = new javax.swing.JButton();
        btnPlayAgain = new javax.swing.JButton();
        pnlChips = new javax.swing.JPanel();
        lblChip1 = new javax.swing.JLabel();
        lblChip2 = new javax.swing.JLabel();
        lblChip3 = new javax.swing.JLabel();
        lblChip4 = new javax.swing.JLabel();
        lblChip5 = new javax.swing.JLabel();
        lblChip6 = new javax.swing.JLabel();
        lblBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlQuestion.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(102, 255, 204)));
        pnlQuestion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        jLabel2.setText("Step right up for a chance to win a BRAND NEW CAR!");
        pnlQuestion.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Impact", 0, 40)); // NOI18N
        jLabel4.setText("WELCOME TO PLINKO!");
        pnlQuestion.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        lblEquation.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        lblEquation.setText(" ");
        pnlQuestion.add(lblEquation, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 210, 40));

        txtAnswer.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        pnlQuestion.add(txtAnswer, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 100, 30));

        btnGo.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnGo.setText("GO");
        btnGo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoActionPerformed(evt);
            }
        });
        pnlQuestion.add(btnGo, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 210, 80, 30));

        btnStart.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btnStart.setText("Generate Equation");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });
        pnlQuestion.add(btnStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 160, 40));

        lblMsg.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblMsg.setToolTipText("");
        pnlQuestion.add(lblMsg, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, 510, 20));

        lblChipCount.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        lblChipCount.setText("Chip Count: 1");
        pnlQuestion.add(lblChipCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, 130, 20));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel1.setText("Question #");
        pnlQuestion.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        bgQuestion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Plinko/bgQuestion.jpg"))); // NOI18N
        pnlQuestion.add(bgQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(pnlQuestion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 625, 550));

        btnContinue.setText("Drop Another Chip");
        btnContinue.setEnabled(false);
        btnContinue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinueActionPerformed(evt);
            }
        });
        getContentPane().add(btnContinue, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 180, 40));

        lblMoneyDisplay.setFont(new java.awt.Font("Bell Gothic Std Black", 1, 30)); // NOI18N
        lblMoneyDisplay.setForeground(new java.awt.Color(255, 255, 255));
        lblMoneyDisplay.setText("$10000");
        getContentPane().add(lblMoneyDisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        lblChipDisplay.setFont(new java.awt.Font("Bell Gothic Std Black", 1, 28)); // NOI18N
        lblChipDisplay.setForeground(new java.awt.Color(255, 255, 255));
        lblChipDisplay.setText("1");
        getContentPane().add(lblChipDisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, -1, -1));

        lblSeeResult.setEditable(false);
        lblSeeResult.setColumns(20);
        lblSeeResult.setLineWrap(true);
        lblSeeResult.setRows(5);
        lblSeeResult.setText("You have used up all your chips!\nTime to see what you won");
        lblSeeResult.setFocusable(false);
        lblSeeResult.setOpaque(false);
        getContentPane().add(lblSeeResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 260, 50));

        btnSeeResult.setText("See Result");
        btnSeeResult.setEnabled(false);
        btnSeeResult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeeResultActionPerformed(evt);
            }
        });
        getContentPane().add(btnSeeResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 160, 40));

        pnlResult.setBackground(new java.awt.Color(255, 255, 204));
        pnlResult.setBorder(javax.swing.BorderFactory.createMatteBorder(15, 15, 15, 15, new javax.swing.ImageIcon(getClass().getResource("/Plinko/smalldot.gif")))); // NOI18N
        pnlResult.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Trajan Pro", 1, 36)); // NOI18N
        jLabel3.setText("Results!");
        pnlResult.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 190, 60));

        lblMsg1.setFont(new java.awt.Font("Trajan Pro", 0, 11)); // NOI18N
        lblMsg1.setText("Correct Answers:");
        pnlResult.add(lblMsg1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));

        lblMsg2.setFont(new java.awt.Font("Trajan Pro", 0, 11)); // NOI18N
        lblMsg2.setText("Money Earned:");
        pnlResult.add(lblMsg2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        picPrize.setBackground(new java.awt.Color(204, 255, 255));
        picPrize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Plinko/nothing.jpg"))); // NOI18N
        picPrize.setOpaque(true);
        pnlResult.add(picPrize, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 240, 120));

        lblPrize2.setFont(new java.awt.Font("Trajan Pro", 0, 11)); // NOI18N
        lblPrize2.setText("You dont qualify for a bonus prize");
        pnlResult.add(lblPrize2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 250, 20));

        lblPrize1.setFont(new java.awt.Font("Trajan Pro", 0, 11)); // NOI18N
        lblPrize1.setText("Oh No!");
        pnlResult.add(lblPrize1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

        btnQuit.setText("QUIT");
        btnQuit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitActionPerformed(evt);
            }
        });
        pnlResult.add(btnQuit, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 300, 100, 30));

        btnPlayAgain.setText("PLAY AGAIN");
        btnPlayAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayAgainActionPerformed(evt);
            }
        });
        pnlResult.add(btnPlayAgain, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 100, 30));

        getContentPane().add(pnlResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 320, 350));

        pnlChips.setToolTipText("");
        pnlChips.setOpaque(false);
        pnlChips.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnlChipsMouseMoved(evt);
            }
        });
        pnlChips.setLayout(new java.awt.GridLayout(0, 6, 10, 0));

        lblChip1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Plinko/dot.gif"))); // NOI18N
        lblChip1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblChip1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Chip1Enter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Chip1Exit(evt);
            }
        });
        pnlChips.add(lblChip1);

        lblChip2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Plinko/dot.gif"))); // NOI18N
        lblChip2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblChip2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Chip2Enter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Chip2Exit(evt);
            }
        });
        pnlChips.add(lblChip2);

        lblChip3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Plinko/dot.gif"))); // NOI18N
        lblChip3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblChip3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Chip3Enter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Chip3Exit(evt);
            }
        });
        pnlChips.add(lblChip3);

        lblChip4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Plinko/dot.gif"))); // NOI18N
        lblChip4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblChip4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Chip4Enter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Chip4Exit(evt);
            }
        });
        pnlChips.add(lblChip4);

        lblChip5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Plinko/dot.gif"))); // NOI18N
        lblChip5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblChip5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Chip5Enter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Chip5Exit(evt);
            }
        });
        pnlChips.add(lblChip5);

        lblChip6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Plinko/dot.gif"))); // NOI18N
        lblChip6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblChip6MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Chip6Enter(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Chip6Exit(evt);
            }
        });
        pnlChips.add(lblChip6);

        getContentPane().add(pnlChips, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 300, 30));

        lblBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Plinko/PlinkoBoard.jpg"))); // NOI18N
        lblBackground.setText("jLabel2");
        lblBackground.setToolTipText("");
        getContentPane().add(lblBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        //generates the first question 
        if (QCounter == 1) {
            generateEquation();
            btnStart.setVisible(false);
            pnlResult.setVisible(false);
            btnGo.setVisible(true);
            txtAnswer.setVisible(true);
        } else { //shrinks the question panel to display the chip panel 
            lblSeeResult.setVisible(false);
            btnSeeResult.setVisible(false);
            btnSeeResult.setEnabled(false);
            updateDisplay();
            btnContinue.setVisible(false);
            time.start();
        }

       


    }//GEN-LAST:event_btnStartActionPerformed
    private void btnGoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoActionPerformed
        //error trap for non numeric entries
        try {
           
            if (Integer.parseInt(txtAnswer.getText()) == answer) {
                //awards chip for correct answer
                intChip++;
                lblMsg.setText("Correct answer! You win a chip");
                intCorrect++;
            }else {
                //doesn't award chip
                lblMsg.setText("Wrong answer! You don't win a chip");
            }
            lblChipCount.setText("Chip Count: " + intChip);

            QCounter++;
            txtAnswer.setText("");
            //generates next question, until 5 questions are reached 
            if (QCounter < 5) {
                generateEquation();
            } else {
                
                btnStart.setVisible(true);
                btnStart.setText("Play");

                btnGo.setEnabled(false);
                txtAnswer.setEnabled(false);
                lblMsg.setText("You have earned " + intChip + " chips! Click to play");

            }
        } catch (NumberFormatException e) {
           lblMsg.setText("You did not enter a valid integer");
        }
    }//GEN-LAST:event_btnGoActionPerformed
    private void pnlChipsMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlChipsMouseMoved
        // TODO add your handling code here:

    }//GEN-LAST:event_pnlChipsMouseMoved
    private void Chip1Enter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Chip1Enter
        // TODO add your handling code here:
        if (selectChip) {
            showChip(1, 1);
        }

    }//GEN-LAST:event_Chip1Enter
    private void Chip2Enter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Chip2Enter
        if (selectChip) {
            showChip(1, 2);
        }


    }//GEN-LAST:event_Chip2Enter
    private void Chip3Enter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Chip3Enter
        // TODO add your handling code here:
        if (selectChip) {
            showChip(1, 3);
        }
    }//GEN-LAST:event_Chip3Enter
    private void Chip4Enter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Chip4Enter
        if (selectChip) {
            showChip(1, 4);
        }

    }//GEN-LAST:event_Chip4Enter
    private void Chip5Enter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Chip5Enter
        if (selectChip) {
            showChip(1, 5);
        }
    }//GEN-LAST:event_Chip5Enter
    private void Chip6Enter(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Chip6Enter
        if (selectChip) {
            showChip(1, 6);
        }
    }//GEN-LAST:event_Chip6Enter
    private void Chip1Exit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Chip1Exit
        if (selectChip) {
            showChip(2, 1);
        }
    }//GEN-LAST:event_Chip1Exit
    private void Chip2Exit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Chip2Exit
        if (selectChip) {
            showChip(2, 2);
        }
    }//GEN-LAST:event_Chip2Exit
    private void Chip3Exit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Chip3Exit
        if (selectChip) {
            showChip(2, 3);
        }
    }//GEN-LAST:event_Chip3Exit
    private void Chip4Exit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Chip4Exit
        if (selectChip) {
            showChip(2, 4);
        }
    }//GEN-LAST:event_Chip4Exit
    private void Chip5Exit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Chip5Exit
        if (selectChip) {
            showChip(2, 5);
        }
    }//GEN-LAST:event_Chip5Exit
    private void Chip6Exit(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Chip6Exit
        if (selectChip) {
            showChip(2, 6);
        }
    }//GEN-LAST:event_Chip6Exit
    void chipClick() {
        selectChip = true;
        //pnlChips.setLayout(new FlowLayout());

        dropChip.start();
        selectChip = false;
        initialX = lblClicked.getX();
        initialY = lblClicked.getY();
        pnlChips.setSize(pnlChips.getSize().width, 390);
    }
    private void lblChip1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChip1MouseClicked
        //sets the selected label as "lblClicked"
        lblClicked = lblChip1;
        chipClick();

    }//GEN-LAST:event_lblChip1MouseClicked
    private void lblChip2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChip2MouseClicked
        lblClicked = lblChip2;
        chipClick();
    }//GEN-LAST:event_lblChip2MouseClicked
    private void lblChip3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChip3MouseClicked
        lblClicked = lblChip3;
        chipClick();
    }//GEN-LAST:event_lblChip3MouseClicked
    private void lblChip4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChip4MouseClicked
        lblClicked = lblChip4;
        chipClick();
    }//GEN-LAST:event_lblChip4MouseClicked
    private void lblChip5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChip5MouseClicked
        lblClicked = lblChip5;
        chipClick();
    }//GEN-LAST:event_lblChip5MouseClicked
    private void lblChip6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblChip6MouseClicked
        lblClicked = lblChip6;
        chipClick();
    }//GEN-LAST:event_lblChip6MouseClicked

    private void btnSeeResultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeeResultActionPerformed
        //display the result panel and hides chip panel
        btnSeeResult.setVisible(false);
        btnSeeResult.setEnabled(false);
        lblSeeResult.setVisible(false);
        pnlChips.setVisible(false);
        pnlResult.setVisible(true);
        btnPlayAgain.setVisible(true);
        btnPlayAgain.setEnabled(true);
        gameEnd();

    }//GEN-LAST:event_btnSeeResultActionPerformed

    private void btnContinueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinueActionPerformed
       //resets the location of the chip to its original position
        pnlChips.setSize(pnlChips.getWidth(), 30);
        lblClicked.setLocation(initialX, initialY);
        showChip(2, 1);
        selectChip = true;
        btnContinue.setVisible(false);
        btnContinue.setEnabled(false);
    }//GEN-LAST:event_btnContinueActionPerformed

    private void btnPlayAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayAgainActionPerformed
        //disposes of current game, then makes a new one
        this.dispose();
        Game m = new Game();
        m.setVisible(true);
    }//GEN-LAST:event_btnPlayAgainActionPerformed

    private void btnQuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitActionPerformed
        // displays quitting message and exit game
        JOptionPane.showMessageDialog(this, "Thanks for playing!", "Quit", 1);
        System.exit(0);
    }//GEN-LAST:event_btnQuitActionPerformed
    void showChip(int TYPE, int n) {
        //type 1: sets chip visible upon mouseover and hides the rest
        //type 2: sets all chips visible
        if (TYPE == 1) {
            //sets chip visible upon mouseover and hides the rest
            lblChip1.setVisible(false);
            lblChip2.setVisible(false);
            lblChip3.setVisible(false);
            lblChip4.setVisible(false);
            lblChip5.setVisible(false);
            lblChip6.setVisible(false);
            switch (n) {
                case 1:
                    lblChip1.setVisible(true);
                    break;
                case 2:
                    lblChip2.setVisible(true);
                    break;
                case 3:
                    lblChip3.setVisible(true);
                    break;
                case 4:
                    lblChip4.setVisible(true);
                    break;
                case 5:
                    lblChip5.setVisible(true);
                    break;
                case 6:
                    lblChip6.setVisible(true);
                    break;
                default:
            }
        } else {
            //sets all chips visible
            lblChip1.setVisible(true);
            lblChip2.setVisible(true);
            lblChip3.setVisible(true);
            lblChip4.setVisible(true);
            lblChip5.setVisible(true);
            lblChip6.setVisible(true);
        }

    }

    int countPoints(int slot, int current) {
        int point = current;
        //calculates points won and adds to total
        switch (slot) {
            case 0:
                point = point + 100;
                break;
            case 1:
                point = point + 500;
                break;
            case 2:
                point = point + 1000;
                break;
            case 3:
                break;
            case 4:
                point = point + 10000;
                break;
            case 5:
                break;
            case 6:
                point = point + 1000;
                break;
            case 7:
                point = point + 500;
                break;
            case 8:
                point = point + 100;
                break;
            default:
        }

        return point;
    }

    void updateDisplay() {
        //updates the display of current points and chips
        lblMoneyDisplay.setText("$" + Integer.toString(intPoints));
        lblChipDisplay.setText(Integer.toString(intChip));

    }

    void gameEnd() {
        lblMsg1.setText("");
        lblMsg2.setText("");
        msg1 = "Correct Answers: " + intCorrect;
        msg2 = "Money Earned: " + intPoints;
        displayText.start();
        // determines which bonus prize user wins, and displays a picture accordingly
        if (intPoints < 2000) {
            lblPrize1.setText("Oh no!");
            lblPrize2.setText("You don't qualify for a bonus prize!");
            picPrize.setIcon(new ImageIcon(getClass().getResource("nothing.jpg")));
        } else if (intPoints >= 2000 && intPoints < 3000) {
            lblPrize1.setText("BONUS!");
            lblPrize2.setText("You win a brand new camera!");
            picPrize.setIcon(new ImageIcon(getClass().getResource("Camera.jpg")));
        } else if (intPoints >= 3000 && intPoints < 10000) {
            lblPrize1.setText("BONUS!");
            lblPrize2.setText("You win a brand new TV!");
            picPrize.setIcon(new ImageIcon(getClass().getResource("TV.jpg")));
        } else if (intPoints > 10000) {
            lblPrize1.setText("GRAND PRIZE!!");
            lblPrize2.setText("You win a brand new car!");
            picPrize.setIcon(new ImageIcon(getClass().getResource("car.jpg")));
        }
    }

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
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game().setVisible(true);
                Game m = new Game();
            }

        });

    }

    String msg1, msg2;
    int answer, number1, number2, operator, intCorrect, intChip = 1, QCounter = 1, intervalX = 1, intMove = 0, distX = 1, intPoints, initialX, initialY;
    final int ADD = 1, SUBTRACT = 2, MULTIPLY = 3, VALUE = 1, OPERATOR = 2, spaceX = 35;
    boolean selectChip = true;
    ImageIcon imgPrize;
    private JLabel lblClicked;
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bgQuestion;
    private javax.swing.JButton btnContinue;
    private javax.swing.JButton btnGo;
    private javax.swing.JButton btnPlayAgain;
    private javax.swing.JButton btnQuit;
    private javax.swing.JButton btnSeeResult;
    private javax.swing.JButton btnStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblBackground;
    private javax.swing.JLabel lblChip1;
    private javax.swing.JLabel lblChip2;
    private javax.swing.JLabel lblChip3;
    private javax.swing.JLabel lblChip4;
    private javax.swing.JLabel lblChip5;
    private javax.swing.JLabel lblChip6;
    private javax.swing.JLabel lblChipCount;
    private javax.swing.JLabel lblChipDisplay;
    private javax.swing.JLabel lblEquation;
    private javax.swing.JLabel lblMoneyDisplay;
    private javax.swing.JLabel lblMsg;
    private javax.swing.JLabel lblMsg1;
    private javax.swing.JLabel lblMsg2;
    private javax.swing.JLabel lblPrize1;
    private javax.swing.JLabel lblPrize2;
    private javax.swing.JTextArea lblSeeResult;
    private javax.swing.JLabel picPrize;
    private javax.swing.JPanel pnlChips;
    private javax.swing.JPanel pnlQuestion;
    private javax.swing.JPanel pnlResult;
    private javax.swing.JTextField txtAnswer;
    // End of variables declaration//GEN-END:variables
    
}
