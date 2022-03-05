import java.math.BigInteger;

public class Program extends javax.swing.JFrame {

    //Váriaveis 
    BigInteger p, q, n, phi, e, d;

    public Program() {
        initComponents();
    }

    private void IniciarEtapas() {
        Metodos aux = new Metodos();

        // Etapa 1: Selecionar dois números primos. 
        // Resultado nas variáveis: (p, q)
        p = aux.GerarNumeroPrimo();
        q = aux.GerarNumeroPrimo();

        // Etapa 2: Calcular o produto dos números obtidos na etapa 1.  
        // Resultado na variável: (n)  Esse número será usado na cifragem e na decifragem.
        n = aux.ProdutoNumerosPrimos(p, q);

        // Etapa 3: Calcular a função totiente de Euler que fornece o tamanho do grupo multiplicativo de inteiros
        // Resultado na variável: (phi) 
        phi = aux.CalcularFuncaoTotiente(p, q);

        // Etapa 4: Selecionar um número que seja um dos coprimos de n, um conjunto que o único divisor comum de todos os números desse conjunto seja 1.
        // Resultado na variável: (e)        
        e = aux.SelecionarCoprimo(phi);

        // Etapa 5: Calcular o inverso multiplicatico do coprimo para usar na chave privada
        // Resultado na variável: (d)  
        d = aux.CalcularInversoCoprimo(e, phi);
    }

    private void Output() {
        // Obtém a mensagem informada pelo usuário
        String mensagem = txtInput.getText();

        // Transdorma a mensagem para bytes
        BigInteger mensagemBytes = new BigInteger(mensagem.getBytes());

        //Obtém a mensagem cifrada com os numeros das etapas
        String mensagemCrifrada = mensagemBytes.modPow(e, n).toString();

        //Obtém a mensagem decifrada com os numeros das etapas
        String mensagemDescifrada = new String(new BigInteger(mensagemCrifrada).modPow(d, n).toByteArray());

        //Mostra para o usuário os resultados obtidos
        txtCifrado.setText(mensagemCrifrada);
        txtDecifrado.setText(mensagemDescifrada);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbInput = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbInput4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtInput = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        lbInput2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCifrado = new javax.swing.JTextArea();
        lbInput3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDecifrado = new javax.swing.JTextArea();
        lbInput1 = new javax.swing.JLabel();
        txtIniciar = new javax.swing.JButton();
        txtLimpar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbInput.setText("INPUT");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("RSA – Criptografia Assimétrica");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Cifrar e Decifrar uma Mensagem");

        lbInput4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lbInput4.setText("Feito por Gabriella Gomes, Italo Martins, Milena Ferreira e Patricia Castro");

        txtInput.setColumns(20);
        txtInput.setRows(5);
        jScrollPane1.setViewportView(txtInput);

        jPanel1.setBackground(java.awt.SystemColor.scrollbar);

        lbInput2.setText("CIFRADO");

        txtCifrado.setColumns(20);
        txtCifrado.setRows(5);
        txtCifrado.setEnabled(false);
        jScrollPane2.setViewportView(txtCifrado);

        lbInput3.setText("DECIFRADO");

        txtDecifrado.setColumns(20);
        txtDecifrado.setRows(5);
        txtDecifrado.setEnabled(false);
        jScrollPane3.setViewportView(txtDecifrado);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbInput2)
                    .addComponent(lbInput3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbInput2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbInput3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbInput1.setText("OUTPUT");

        txtIniciar.setText("Iniciar");
        txtIniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIniciarMouseClicked(evt);
            }
        });

        txtLimpar.setText("Limpar");
        txtLimpar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtLimparMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbInput)
                                    .addComponent(lbInput1))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(199, 199, 199)
                        .addComponent(lbInput4)))
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(293, 293, 293)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(8, 8, 8)
                .addComponent(lbInput)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtIniciar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtLimpar)))
                .addGap(41, 41, 41)
                .addComponent(lbInput1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(lbInput4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIniciarMouseClicked

        //Iniciar o processo para o cálculo 
        IniciarEtapas();

        //Processar e mostrar o resultado
        Output();

    }//GEN-LAST:event_txtIniciarMouseClicked

    private void txtLimparMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtLimparMouseClicked
        txtInput.setText(null);
        txtCifrado.setText(null);
        txtDecifrado.setText(null);
    }//GEN-LAST:event_txtLimparMouseClicked

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Program().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbInput;
    private javax.swing.JLabel lbInput1;
    private javax.swing.JLabel lbInput2;
    private javax.swing.JLabel lbInput3;
    private javax.swing.JLabel lbInput4;
    private javax.swing.JTextArea txtCifrado;
    private javax.swing.JTextArea txtDecifrado;
    private javax.swing.JButton txtIniciar;
    private javax.swing.JTextArea txtInput;
    private javax.swing.JButton txtLimpar;
    // End of variables declaration//GEN-END:variables
}
