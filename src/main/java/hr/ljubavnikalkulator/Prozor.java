/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.ljubavnikalkulator;

import java.util.Arrays;

/**
 *
 * @author virt7
 */
public class Prozor extends javax.swing.JFrame {

    /**
     * Creates new form Prozor
     */
    public Prozor() {
        initComponents();
        txtOna.setText("Jadranka");
        txtOn.setText("Aleksandar");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtOna = new javax.swing.JTextField();
        txtOn = new javax.swing.JTextField();
        btnIzracunaj = new javax.swing.JButton();
        lblPostotak = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtOna.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txtOn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnIzracunaj.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btnIzracunaj.setText("Izračunaj");
        btnIzracunaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzracunajActionPerformed(evt);
            }
        });

        lblPostotak.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblPostotak.setText("%");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(btnIzracunaj))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(txtOna, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtOn, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(lblPostotak)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtOna, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                    .addComponent(txtOn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addComponent(btnIzracunaj)
                .addGap(18, 18, 18)
                .addComponent(lblPostotak, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnIzracunajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzracunajActionPerformed
        // TODO add your handling code here:
        
//makni sve razmake i prebaci u mala slova
        String strImenaTemp = txtOna.getText().toLowerCase().strip().concat(txtOn.getText().toLowerCase().strip());
        //prebaci u char da mozes sortirati
        char[] charArray = strImenaTemp.toCharArray();
        //java.util.Arrays.sort(charArray);                //import nije radio 
        Arrays.sort(charArray);

        //sortirana rijec poslozena po slovima
        String strImena = String.valueOf(charArray);
        System.out.println(strImenaTemp + " " + strImena);
        
        char temp;
        char temp2;
        char temp3;
        int duzina = strImena.length();
        int broj = 1;
        int[] arrayJedan= new int[duzina];
        int brojac=0;
        
        //ova petlja pravi prvi niz sa brojevima umjesto slova
        for (int i = 0; i < duzina; i++) {

            //ako je zadnji broj da ne izadje iz niza kad pogleda znak iza zadnjeg
            if (i == (duzina - 1)) {
                arrayJedan[brojac] = broj;
                continue;
            }

            temp = charArray[i];
            temp2 = charArray[i + 1];

            if (temp == temp2) {
                broj++;

            } else if (broj > 1) {
                arrayJedan[brojac] = broj;
                broj = 1;
                brojac++;
            } else {
                arrayJedan[brojac] = 1;
                brojac++;
            }
        }
        //arrayJedan sadrzi original brojeve it slova
        ispisiNiz(arrayJedan);
        
        //pozivanje metode za izracunavanje postotka
        String konacno = vratiPostotak(arrayJedan);
        System.out.println(konacno+"%");
        lblPostotak.setText(konacno + "%");
        
  
    }//GEN-LAST:event_btnIzracunajActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIzracunaj;
    private javax.swing.JLabel lblPostotak;
    private javax.swing.JTextField txtOn;
    private javax.swing.JTextField txtOna;
    // End of variables declaration//GEN-END:variables

    private void ispisiNiz(int[] niz){
        //System.out.println("");
        for(int i = 0; i<niz.length;i++){
            System.out.print(niz[i]);
        }
        System.out.println("");
    }
    
    private String vratiPostotak(int[] arrayJedan) {
        int[] arrayTemp1 = new int[arrayJedan.length];
        boolean kraj = false;
        int arrayTemp1Brojac;
        int broj1=0;
        int broj2=0;
        
        while (!kraj) {
            arrayTemp1Brojac = 0;
            broj1=0;
            broj2=0;
            Arrays.fill(arrayTemp1, 0);  //upotreba dva niza dok se ne dobiju samo dvije brojke
            
            for (int x =0; x<arrayJedan.length;x++) {
                
                if (arrayJedan[x]>0) {
                    arrayTemp1Brojac++;
                    if(arrayTemp1Brojac<2){
                        arrayTemp1[broj1]=arrayJedan[x];
                        if(arrayTemp1[broj1]>9){arrayTemp1[broj1]=1;}
                    }else{
                        arrayTemp1[broj1]= arrayTemp1[broj1] + arrayJedan[x];
                        arrayTemp1Brojac=0;
                        if(arrayTemp1[broj1]>9){arrayTemp1[broj1]=1;}     //ako je broj veci od 10 stavi 1
                        broj1++;
                    }
                    broj2++;
                }
                
                    }
            if(arrayTemp1[2]==0){
                return (Integer.toString(arrayTemp1[0]).concat(Integer.toString(arrayTemp1[1]))); //vraca string
            }
            ispisiNiz(arrayTemp1);
            
            
            ////////////////drugi dio brise prvi niz i stavlja sve u drugi i u kgrug
            arrayTemp1Brojac = 0;
            broj1=0;
            broj2=0;
            Arrays.fill(arrayJedan, 0);
                        for (int x =0; x<arrayTemp1.length;x++) {
                
                if (arrayTemp1[x]>0) {
                    arrayTemp1Brojac++;
                    if(arrayTemp1Brojac<2){
                        arrayJedan[broj1]=arrayTemp1[x];
                        if(arrayJedan[broj1]>9){arrayJedan[broj1]=1;}
                        
                    }else{
                        arrayJedan[broj1]= arrayJedan[broj1] + arrayTemp1[x];
                        arrayTemp1Brojac=0;
                        if(arrayJedan[broj1]>9){arrayJedan[broj1]=1;}     //ako je broj veci od 10 stavi 1
                        broj1++;
                    }
                    
                    broj2++;
                 
                }
                    }
                        if(arrayJedan[2]==0){
                return (Integer.toString(arrayJedan[0]).concat(Integer.toString(arrayJedan[1])));
            }  
                        ispisiNiz(arrayJedan);
                }
        
               return "Greška :D";   
            }
        }
