/*
 * MitarbeiterIFrame.java
 *
 * Created on 20. Mai 2005, 20:48
 */

package GUI;
import java.util.*;
import FK.*;

public class MietobjektIFrame extends javax.swing.JInternalFrame {
    
    /** Creates new form MitarbeiterIFrame */
    public MietobjektIFrame() {
        initComponents();
        this.setSize(800,460);
        this.setVisible(false);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mietobjektTBL = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        begriffText = new javax.swing.JTextField();
        gruppeComboBox = new javax.swing.JComboBox();
        suchenBTN = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        ausblendenBTN = new javax.swing.JButton();

        setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2));
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Mietobjekt");
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel3.setMinimumSize(new java.awt.Dimension(800, 560));
        mietobjektTBL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mietobjekt Nr", "Einzelzimmer", "Doppelzimmer", "Zweibettzimmer", "Strasse", "PLZ", "Ort", "Tagespreis"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(mietobjektTBL);

        jPanel3.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        begriffText.setMinimumSize(new java.awt.Dimension(11, 23));
        begriffText.setPreferredSize(new java.awt.Dimension(150, 23));
        jPanel1.add(begriffText);

        gruppeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mietobjekt Nr", "Anzahl Schlafpl�tze", "Ort" }));
        gruppeComboBox.setPreferredSize(new java.awt.Dimension(140, 23));
        jPanel1.add(gruppeComboBox);

        suchenBTN.setText("Suchen");
        suchenBTN.setPreferredSize(new java.awt.Dimension(80, 23));
        suchenBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suchenBTNActionPerformed(evt);
            }
        });

        jPanel1.add(suchenBTN);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 25, 5));

        ausblendenBTN.setFont(new java.awt.Font("Tahoma", 0, 12));
        ausblendenBTN.setIcon(new javax.swing.ImageIcon("Ausblenden"));
        ausblendenBTN.setText("Ausblenden");
        ausblendenBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ausblendenBTNActionPerformed(evt);
            }
        });

        jPanel2.add(ausblendenBTN);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        pack();
    }
    // </editor-fold>//GEN-END:initComponents

    private void suchenBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suchenBTNActionPerformed
        suchen();
    }//GEN-LAST:event_suchenBTNActionPerformed

    public void suchen()
    {
        MietobjektVerwaltung eineVerwaltung = new MietobjektVerwaltung();
        LinkedList eineListe = null;
       
        if(gruppeComboBox.getSelectedIndex()==0)
        {
            eineListe = eineVerwaltung.SuchenImmobilie(Integer.parseInt(begriffText.getText()));
        }
        if(gruppeComboBox.getSelectedIndex()==1)
        {
            eineListe = eineVerwaltung.suchenAnzahlSchlaf(Integer.parseInt(begriffText.getText()));
        }
        if(gruppeComboBox.getSelectedIndex()==2)
        {
            eineListe = eineVerwaltung.suchenOrt(begriffText.getText());
        }


        ListIterator einIterator = eineListe.listIterator();
        int i=0;
        
        // <editor-fold defaultstate="collapsed" desc=" Tabellen Modell ">
        String[] titel = {"Mietobjekt Nr", "Einzelzimmer", "Doppelzimmer", "Zweibettzimmer", "Strasse", "PLZ", "Ort", "Tagespreis"};
        boolean[] canEdit = {false, false, false, false, false, false, false, false};
        Class[] types = {Integer.class, Integer.class, Integer.class, Integer.class, String.class, String.class, String.class, String.class};
        
        TabellenModell einModell = new TabellenModell(eineListe.size(), titel, canEdit, types);
        mietobjektTBL.setModel(einModell);
        // </editor-fold>    
        
        while(einIterator.hasNext())
        {
            Mietobjekt einMietobjekt = (Mietobjekt)einIterator.next();
            mietobjektTBL.setValueAt(einMietobjekt.getIdentNR(),i,0);
            mietobjektTBL.setValueAt(einMietobjekt.getEinzelzimmer(), i, 1);
            mietobjektTBL.setValueAt(einMietobjekt.getDoppelzimmer(), i, 2);
            mietobjektTBL.setValueAt(einMietobjekt.getZweibettzimmer(), i, 3);
            mietobjektTBL.setValueAt(einMietobjekt.getStrasse(), i, 4);
            mietobjektTBL.setValueAt(einMietobjekt.getPLZ(), i, 5);
            mietobjektTBL.setValueAt(einMietobjekt.getOrt(), i, 6);
            mietobjektTBL.setValueAt(einMietobjekt.getTagespreis(), i, 7);
            i++;
        }
    }
    
    public void setBegriff(String value)
    {
        begriffText.setText(value);
    }
    
    public void setGruppe(int gruppe)
    {
        gruppeComboBox.setSelectedIndex(gruppe);
    }
    
    private void ausblendenBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ausblendenBTNActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_ausblendenBTNActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ausblendenBTN;
    private javax.swing.JTextField begriffText;
    private javax.swing.JComboBox gruppeComboBox;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable mietobjektTBL;
    private javax.swing.JButton suchenBTN;
    // End of variables declaration//GEN-END:variables
    
}