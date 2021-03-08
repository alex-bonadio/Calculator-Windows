package view;

import controller.Calculator;

/**
 * @author Alex Bonadio Total Code Lines: 2012 Classe: 671 Methods: 29
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
        bMC = new javax.swing.JButton();
        bMPlus = new javax.swing.JButton();
        bSub = new javax.swing.JButton();
        labelExp = new javax.swing.JLabel();
        bNegative = new javax.swing.JButton();
        bSum = new javax.swing.JButton();
        bMR = new javax.swing.JButton();
        bMMinus = new javax.swing.JButton();
        bPerc = new javax.swing.JButton();
        b9 = new javax.swing.JButton();
        bBackSpace = new javax.swing.JButton();
        bCleanNum = new javax.swing.JButton();
        bPow = new javax.swing.JButton();
        bCleanner = new javax.swing.JButton();
        displayMem = new javax.swing.JLabel();

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
        bRoot.setToolTipText("Raiz Enésima");
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
        bDiv.setForeground(new java.awt.Color(0, 255, 0));
        bDiv.setMnemonic('/');
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

        bMC.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        bMC.setForeground(new java.awt.Color(255, 0, 0));
        bMC.setText("MC");
        bMC.setToolTipText("Apaga o número salvo na memória");
        bMC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMCActionPerformed(evt);
            }
        });

        bMPlus.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        bMPlus.setText("M+");
        bMPlus.setToolTipText("Adição à Memória");
        bMPlus.setHideActionText(true);
        bMPlus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bMPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMPlusActionPerformed(evt);
            }
        });

        bSub.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bSub.setForeground(new java.awt.Color(255, 153, 51));
        bSub.setMnemonic('-');
        bSub.setText("-");
        bSub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSubActionPerformed(evt);
            }
        });

        labelExp.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        labelExp.setForeground(new java.awt.Color(0, 0, 255));
        labelExp.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        bNegative.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bNegative.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/icons8-mais-e-menos-32.png"))); // NOI18N
        bNegative.setToolTipText("Número Negativo");
        bNegative.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNegativeActionPerformed(evt);
            }
        });

        bSum.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bSum.setForeground(new java.awt.Color(0, 204, 204));
        bSum.setMnemonic('+');
        bSum.setText("+");
        bSum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSumActionPerformed(evt);
            }
        });

        bMR.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        bMR.setForeground(new java.awt.Color(0, 51, 255));
        bMR.setText("MR");
        bMR.setToolTipText("Rechamada da Memória");
        bMR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMRActionPerformed(evt);
            }
        });

        bMMinus.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        bMMinus.setText("M-");
        bMMinus.setToolTipText("Subtração da Memória");
        bMMinus.setMaximumSize(new java.awt.Dimension(51, 25));
        bMMinus.setMinimumSize(new java.awt.Dimension(51, 25));
        bMMinus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMMinusActionPerformed(evt);
            }
        });

        bPerc.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        bPerc.setText("%");
        bPerc.setToolTipText("Porcentagem ");
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

        bBackSpace.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        bBackSpace.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/icons8-backspace-32.png"))); // NOI18N
        bBackSpace.setToolTipText("BackSpace");
        bBackSpace.setHideActionText(true);
        bBackSpace.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bBackSpace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBackSpaceActionPerformed(evt);
            }
        });

        bCleanNum.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        bCleanNum.setForeground(new java.awt.Color(255, 0, 0));
        bCleanNum.setText("CE");
        bCleanNum.setToolTipText("Apaga o último número digitado");
        bCleanNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCleanNumActionPerformed(evt);
            }
        });

        bPow.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bPow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/icons/power_icon24.png"))); // NOI18N
        bPow.setToolTipText("Potenciação");
        bPow.setMaximumSize(new java.awt.Dimension(51, 25));
        bPow.setMinimumSize(new java.awt.Dimension(51, 25));
        bPow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPowActionPerformed(evt);
            }
        });

        bCleanner.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        bCleanner.setForeground(new java.awt.Color(255, 0, 0));
        bCleanner.setText("C");
        bCleanner.setToolTipText("Apaga toda a memória");
        bCleanner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCleannerActionPerformed(evt);
            }
        });

        displayMem.setForeground(new java.awt.Color(0, 102, 255));
        displayMem.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        displayMem.setText("Memory");
        displayMem.setToolTipText("Número Salvo na Memória");
        displayMem.setMaximumSize(new java.awt.Dimension(0, 0));
        displayMem.setMinimumSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(displayMem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inputText, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelExp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(bMC, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bMR, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(b1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(bNegative, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(b2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(b0, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(bPerc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(bCleanner, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bCleanNum, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                                        .addComponent(bMPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bMMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
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
                .addGap(2, 2, 2)
                .addComponent(displayMem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(bMPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(bMMinus, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bMR, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bMC, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(b0, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bFloat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bEqual, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bNegative, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {b0, bNegative});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bDiv, bMult, bSub, bSum});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void b0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b0ActionPerformed
        calc.b0Action();
    }//GEN-LAST:event_b0ActionPerformed

    private void b3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b3ActionPerformed
        calc.numPadAction(3);
    }//GEN-LAST:event_b3ActionPerformed

    private void b2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b2ActionPerformed
        calc.numPadAction(2);
    }//GEN-LAST:event_b2ActionPerformed

    private void b1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b1ActionPerformed
        calc.numPadAction(1);
    }//GEN-LAST:event_b1ActionPerformed

    private void b4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b4ActionPerformed
        calc.numPadAction(4);
    }//GEN-LAST:event_b4ActionPerformed

    private void b5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b5ActionPerformed
        calc.numPadAction(5);
    }//GEN-LAST:event_b5ActionPerformed

    private void b6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b6ActionPerformed
        calc.numPadAction(6);
    }//GEN-LAST:event_b6ActionPerformed

    private void b7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b7ActionPerformed
        calc.numPadAction(7);
    }//GEN-LAST:event_b7ActionPerformed

    private void b8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b8ActionPerformed
        calc.numPadAction(8);
    }//GEN-LAST:event_b8ActionPerformed

    private void bRootActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRootActionPerformed
        calc.calculationHub((short) 6);
    }//GEN-LAST:event_bRootActionPerformed

    private void bMPlusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMPlusActionPerformed
        calc.memorise();
    }//GEN-LAST:event_bMPlusActionPerformed

    private void bMCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMCActionPerformed
        calc.cleanVariables(5);
        calc.writeMemory();
    }//GEN-LAST:event_bMCActionPerformed

    private void bSubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSubActionPerformed
        calc.calculationHub((short) 2);
    }//GEN-LAST:event_bSubActionPerformed

    private void bMultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMultActionPerformed
        calc.calculationHub((short) 3);
    }//GEN-LAST:event_bMultActionPerformed

    private void bDivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDivActionPerformed
        calc.calculationHub((short) 4);
    }//GEN-LAST:event_bDivActionPerformed

    private void bEqualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEqualActionPerformed
        calc.equalsAction();
    }//GEN-LAST:event_bEqualActionPerformed

    private void bFloatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFloatActionPerformed
        calc.bFloatAction();
    }//GEN-LAST:event_bFloatActionPerformed

    private void bNegativeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNegativeActionPerformed
        calc.validateNumber();
        calc.negativeNumber();
    }//GEN-LAST:event_bNegativeActionPerformed

    private void bSumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSumActionPerformed
        calc.calculationHub((short) 1);
    }//GEN-LAST:event_bSumActionPerformed

    private void inputTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputTextKeyPressed
        calc.inputTextKeyPressedAction(evt);
    }//GEN-LAST:event_inputTextKeyPressed

    private void bMRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMRActionPerformed
        calc.memoryRecall();
    }//GEN-LAST:event_bMRActionPerformed

    private void bMMinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMMinusActionPerformed
        calc.cleanVariables(5);
        calc.writeMemory();
    }//GEN-LAST:event_bMMinusActionPerformed

    private void bPercActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPercActionPerformed
        calc.percentStart();
    }//GEN-LAST:event_bPercActionPerformed

    private void b9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b9ActionPerformed
        calc.numPadAction(9);
    }//GEN-LAST:event_b9ActionPerformed

    private void bBackSpaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBackSpaceActionPerformed
        calc.backSpaceAction();
    }//GEN-LAST:event_bBackSpaceActionPerformed

    private void bCleanNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCleanNumActionPerformed
        calc.bCleanNumAction();
    }//GEN-LAST:event_bCleanNumActionPerformed

    private void bPowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPowActionPerformed
        calc.calculationHub((short) 5);
    }//GEN-LAST:event_bPowActionPerformed

    private void bCleannerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCleannerActionPerformed
        calc.cleanVariables(2);
        calc.cleanVariables(3);
        calc.cleanVariables(4);
        calc.cleanVariables(5);
        calc.writeZero();
        calc.writeMemory();
    }//GEN-LAST:event_bCleannerActionPerformed

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
    public javax.swing.JButton bMC;
    public javax.swing.JButton bMMinus;
    public javax.swing.JButton bMPlus;
    public javax.swing.JButton bMR;
    public javax.swing.JButton bMult;
    public javax.swing.JButton bNegative;
    public javax.swing.JButton bPerc;
    public javax.swing.JButton bPow;
    public javax.swing.JButton bRoot;
    public javax.swing.JButton bSub;
    public javax.swing.JButton bSum;
    public javax.swing.JLabel displayMem;
    public javax.swing.JTextField inputText;
    public javax.swing.JLabel labelExp;
    // End of variables declaration//GEN-END:variables

    public void getReferenceVariable(CalculatorGUI start) {
        calc.takeReferenceVariable(start);
        calc.writeZero();
    }
}
