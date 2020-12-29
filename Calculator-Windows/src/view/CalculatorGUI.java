package view;

import controller.Calculator;

/**
 * @author Alex Bonadio Total Code Lines: 2011 Classe: 599 Methods: 78
 */
public class CalculatorGUI extends javax.swing.JFrame {

    Calculator calc = new Calculator();

    public CalculatorGUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputText = new javax.swing.JTextField();
        b7 = new javax.swing.JButton();
        b8 = new javax.swing.JButton();
        bRoot = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        b5 = new javax.swing.JButton();
        b6 = new javax.swing.JButton();
        bMult = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        bDiv = new javax.swing.JButton();
        b1 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        b0 = new javax.swing.JButton();
        bEqual = new javax.swing.JButton();
        bFloat = new javax.swing.JButton();
        bCleanner = new javax.swing.JButton();
        bBackSpace = new javax.swing.JButton();
        bSub = new javax.swing.JButton();
        labelExp = new javax.swing.JLabel();
        bMaisMenos = new javax.swing.JButton();
        bSum = new javax.swing.JButton();
        bCleanNum = new javax.swing.JButton();
        bPow = new javax.swing.JButton();
        bPerc = new javax.swing.JButton();
        b9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Calculator");
        setName("frameCalc"); // NOI18N
        setResizable(false);

        inputText.setEditable(false);
        inputText.setBackground(new java.awt.Color(255, 255, 255));
        inputText.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        inputText.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        inputText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 255)));
        inputText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputTextKeyPressed(evt);
            }
        });

        b7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        b7.setText("7");
        b7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b7ActionPerformed(evt);
            }
        });

        b8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        b8.setText("8");
        b8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b8ActionPerformed(evt);
            }
        });

        bRoot.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bRoot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/icons8-raiz-quadrada-32.png"))); // NOI18N
        bRoot.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bRoot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRootActionPerformed(evt);
            }
        });

        b4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        b4.setText("4");
        b4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b4ActionPerformed(evt);
            }
        });

        b5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        b5.setText("5");
        b5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b5ActionPerformed(evt);
            }
        });

        b6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        b6.setText("6");
        b6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b6ActionPerformed(evt);
            }
        });

        bMult.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bMult.setForeground(new java.awt.Color(255, 255, 0));
        bMult.setMnemonic('*');
        bMult.setText("x");
        bMult.setToolTipText("");
        bMult.setActionCommand("*");
        bMult.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMultActionPerformed(evt);
            }
        });

        b2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        b2.setText("2");
        b2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b2ActionPerformed(evt);
            }
        });

        bDiv.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bDiv.setForeground(new java.awt.Color(0, 153, 153));
        bDiv.setText("/");
        bDiv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDivActionPerformed(evt);
            }
        });

        b1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        b1.setText("1");
        b1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b1ActionPerformed(evt);
            }
        });

        b3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        b3.setText("3");
        b3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b3ActionPerformed(evt);
            }
        });

        b0.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        b0.setText("0");
        b0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b0ActionPerformed(evt);
            }
        });

        bEqual.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bEqual.setForeground(new java.awt.Color(255, 51, 51));
        bEqual.setText("=");
        bEqual.setToolTipText("");
        bEqual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEqualActionPerformed(evt);
            }
        });

        bFloat.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        bFloat.setText(".");
        bFloat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFloatActionPerformed(evt);
            }
        });

        bCleanner.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        bCleanner.setForeground(new java.awt.Color(255, 0, 0));
        bCleanner.setText("C");
        bCleanner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCleannerActionPerformed(evt);
            }
        });

        bBackSpace.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bBackSpace.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/icons8-backspace-32.png"))); // NOI18N
        bBackSpace.setHideActionText(true);
        bBackSpace.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bBackSpace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBackSpaceActionPerformed(evt);
            }
        });

        bSub.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bSub.setForeground(new java.awt.Color(51, 0, 204));
        bSub.setText("-");
        bSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSubActionPerformed(evt);
            }
        });

        labelExp.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        labelExp.setForeground(new java.awt.Color(0, 0, 255));
        labelExp.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        bMaisMenos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bMaisMenos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/icons8-mais-e-menos-32.png"))); // NOI18N
        bMaisMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMaisMenosActionPerformed(evt);
            }
        });

        bSum.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bSum.setForeground(new java.awt.Color(0, 102, 255));
        bSum.setMnemonic('-');
        bSum.setText("+");
        bSum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSumActionPerformed(evt);
            }
        });

        bCleanNum.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        bCleanNum.setForeground(new java.awt.Color(255, 0, 0));
        bCleanNum.setText("CE");
        bCleanNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCleanNumActionPerformed(evt);
            }
        });

        bPow.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bPow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/power_icon24.png"))); // NOI18N
        bPow.setToolTipText("");
        bPow.setMaximumSize(new java.awt.Dimension(51, 25));
        bPow.setMinimumSize(new java.awt.Dimension(51, 25));
        bPow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPowActionPerformed(evt);
            }
        });

        bPerc.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        bPerc.setText("%");
        bPerc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPercActionPerformed(evt);
            }
        });

        b9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        b9.setText("9");
        b9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inputText)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelExp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(bCleanner, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bCleanNum, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(b1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(bMaisMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(b2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(b0, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(bPerc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(bFloat, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bEqual, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bDiv, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bMult, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(b9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bSum, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(bRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bSub, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(bBackSpace)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bPow, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputText, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelExp, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(bBackSpace, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(bPow, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bCleanNum, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bCleanner, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bSub, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bRoot, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(bPerc, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bSum, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bMult, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bDiv, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bEqual, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bMaisMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(b0, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bFloat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {b0, bMaisMenos});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bDiv, bMult, bSub, bSum});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b0ActionPerformed
        // TODO add your handling code here:
        calc.b0Action();
    }//GEN-LAST:event_b0ActionPerformed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        // TODO add your handling code here:
        calc.b3Action();
    }//GEN-LAST:event_b3ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        // TODO add your handling code here:
        calc.b2Action();
    }//GEN-LAST:event_b2ActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        // TODO add your handling code here:
        calc.b1Action();
    }//GEN-LAST:event_b1ActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
        // TODO add your handling code here:
        calc.b4Action();
    }//GEN-LAST:event_b4ActionPerformed

    private void b5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b5ActionPerformed
        // TODO add your handling code here:
        calc.b5Action();
    }//GEN-LAST:event_b5ActionPerformed

    private void b6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b6ActionPerformed
        // TODO add your handling code here:
        calc.b6Action();
    }//GEN-LAST:event_b6ActionPerformed

    private void b7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b7ActionPerformed
        // TODO add your handling code here:
        calc.b7Action();
    }//GEN-LAST:event_b7ActionPerformed

    private void b8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b8ActionPerformed
        // TODO add your handling code here:
        calc.b8Action();
    }//GEN-LAST:event_b8ActionPerformed

    private void bRootActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRootActionPerformed
        // TODO add your handling code here:
        calc.calculationHub((short) 6);
    }//GEN-LAST:event_bRootActionPerformed

    private void bBackSpaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBackSpaceActionPerformed
        // TODO add your handling code here:
        calc.backSpaceAction();
    }//GEN-LAST:event_bBackSpaceActionPerformed

    private void bCleannerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCleannerActionPerformed
        // TODO add your handling code here:
        calc.cleanVariables(2);
        calc.cleanVariables(3);
        calc.cleanVariables(4);
        calc.writeZero();
    }//GEN-LAST:event_bCleannerActionPerformed

    private void bSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSubActionPerformed
        // TODO add your handling code here:
        calc.calculationHub((short) 2);
    }//GEN-LAST:event_bSubActionPerformed

    private void bMultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMultActionPerformed
        // TODO add your handling code here:
        calc.calculationHub((short) 3);
    }//GEN-LAST:event_bMultActionPerformed

    private void bDivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDivActionPerformed
        // TODO add your handling code here:
        calc.calculationHub((short) 4);
    }//GEN-LAST:event_bDivActionPerformed

    private void bEqualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEqualActionPerformed
        // TODO add your handling code here:
        calc.equalsAction();
    }//GEN-LAST:event_bEqualActionPerformed

    private void bFloatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFloatActionPerformed
        // TODO add your handling code here:
        calc.bFloatAction();
    }//GEN-LAST:event_bFloatActionPerformed

    private void bMaisMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMaisMenosActionPerformed
        // TODO add your handling code here:
        calc.validateNumber();
        calc.negativeNumber();
    }//GEN-LAST:event_bMaisMenosActionPerformed

    private void bSumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSumActionPerformed
        // TODO add your handling code here:
        calc.calculationHub((short) 1);
    }//GEN-LAST:event_bSumActionPerformed

    private void inputTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputTextKeyPressed
        // TODO add your handling code here:
        calc.inputTextKeyPressedAction(evt);
    }//GEN-LAST:event_inputTextKeyPressed

    private void bCleanNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCleanNumActionPerformed
        // TODO add your handling code here:
        calc.bCleanNumAction();
    }//GEN-LAST:event_bCleanNumActionPerformed

    private void bPowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPowActionPerformed
        // TODO add your handling code here:
        calc.calculationHub((short) 5);
    }//GEN-LAST:event_bPowActionPerformed

    private void bPercActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPercActionPerformed
        // TODO add your handling code here:
        calc.percentStart();
    }//GEN-LAST:event_bPercActionPerformed

    private void b9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b9ActionPerformed
        // TODO add your handling code here:
        calc.b9Action();
    }//GEN-LAST:event_b9ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CalculatorGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CalculatorGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CalculatorGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CalculatorGUI.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        CalculatorGUI calcGUI = new CalculatorGUI();
        calcGUI.getReferenceVariable(calcGUI);

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //  new Calculator().setVisible(true);
                calcGUI.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton b0;
    public javax.swing.JButton b1;
    public javax.swing.JButton b2;
    public javax.swing.JButton b3;
    public javax.swing.JButton b4;
    public javax.swing.JButton b5;
    public javax.swing.JButton b6;
    public javax.swing.JButton b7;
    public javax.swing.JButton b8;
    public javax.swing.JButton b9;
    public javax.swing.JButton bBackSpace;
    public javax.swing.JButton bCleanNum;
    public javax.swing.JButton bCleanner;
    public javax.swing.JButton bDiv;
    public javax.swing.JButton bEqual;
    public javax.swing.JButton bFloat;
    public javax.swing.JButton bMaisMenos;
    public javax.swing.JButton bMult;
    public javax.swing.JButton bPerc;
    public javax.swing.JButton bPow;
    public javax.swing.JButton bRoot;
    public javax.swing.JButton bSub;
    public javax.swing.JButton bSum;
    public javax.swing.JTextField inputText;
    public javax.swing.JLabel labelExp;
    // End of variables declaration//GEN-END:variables

    public void getReferenceVariable(CalculatorGUI start) {
        calc.sendReferenceVariable(start);
        calc.writeZero();
    }
}