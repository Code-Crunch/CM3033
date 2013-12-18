/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm3033.lab2.ex3;

import java.awt.Component;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Florin
 */
public class ClientApp extends javax.swing.JFrame implements Runnable {

    public volatile String text;
    private int highValue, lowValue;
    private int oldHighValue = highValue, oldLowValue = lowValue;
    private String highLowValue;
    final DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    Calendar now = null, start = Calendar.getInstance();
    boolean running = true;
    boolean connect = false;
    Alarm a = new Alarm();

    public ClientApp() throws IOException {
        initComponents();

        //sendButton.setVisible(false);
        text = "";
        maxValue.removeAllItems();
        minValue.removeAllItems();

        maxValue.addItem(40);
        maxValue.addItem(60);
        maxValue.addItem(80);
        maxValue.addItem(100);
        maxValue.addItem(120);
        maxValue.addItem(140);
        maxValue.addItem(160);
        maxValue.addItem(180);
        maxValue.addItem(200);

        minValue.addItem(20);
        minValue.addItem(40);
        minValue.addItem(60);
        minValue.addItem(80);
        minValue.addItem(100);
        minValue.addItem(120);
        minValue.addItem(140);
        minValue.addItem(160);
        minValue.addItem(180);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        maxLabel = new javax.swing.JLabel();
        minLabel = new javax.swing.JLabel();
        currentTime = new javax.swing.JLabel();
        elapsedTime = new javax.swing.JLabel();
        maxValue = new javax.swing.JComboBox();
        minValue = new javax.swing.JComboBox();
        bpmLabel = new javax.swing.JLabel();
        opModeLabel = new javax.swing.JLabel();
        connectionButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textSpace = new javax.swing.JTextArea();
        bpmValue = new javax.swing.JLabel();
        opModeValue = new javax.swing.JLabel();
        currentTimeValue = new javax.swing.JLabel();
        elapsedTimeValue = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuExit = new javax.swing.JMenu();
        resetMenu = new javax.swing.JMenuItem();
        conectionsLeft = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        exit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        maxLabel.setText("Max:");

        minLabel.setText("Min");

        currentTime.setText("Current Time:");

        elapsedTime.setText("Elapsed Time:");

        maxValue.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        maxValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxValueActionPerformed(evt);
            }
        });

        minValue.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        minValue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minValueActionPerformed(evt);
            }
        });

        bpmLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        bpmLabel.setText("BPM:");

        opModeLabel.setText("Operating Mode:");

        connectionButton.setText("Connect");
        connectionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectionButtonActionPerformed(evt);
            }
        });

        textSpace.setColumns(20);
        textSpace.setRows(5);
        jScrollPane1.setViewportView(textSpace);

        bpmValue.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        bpmValue.setText("200");

        opModeValue.setText("Local");

        currentTimeValue.setText("00:00:00");

        elapsedTimeValue.setText("00:00:00");

        menuExit.setText("File");

        resetMenu.setText("Reset");
        resetMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetMenuActionPerformed(evt);
            }
        });
        menuExit.add(resetMenu);

        conectionsLeft.setText("Conections Left");
        conectionsLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conectionsLeftActionPerformed(evt);
            }
        });
        menuExit.add(conectionsLeft);
        menuExit.add(jSeparator1);

        exit.setText("EXIT");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        menuExit.add(exit);

        jMenuBar1.add(menuExit);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(opModeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(opModeValue, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(minLabel)
                                .addGap(13, 13, 13)
                                .addComponent(minValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bpmLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bpmValue)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(maxLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(maxValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(connectionButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(currentTime, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(elapsedTime, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(currentTimeValue)
                                    .addComponent(elapsedTimeValue, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(currentTime)
                            .addComponent(currentTimeValue))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(elapsedTime)
                            .addComponent(elapsedTimeValue)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(opModeLabel)
                            .addComponent(connectionButton)
                            .addComponent(opModeValue))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(maxLabel)
                            .addComponent(maxValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(minLabel)
                            .addComponent(minValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bpmLabel)
                            .addComponent(bpmValue))))
                .addGap(53, 53, 53)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        running = false;
    }//GEN-LAST:event_exitActionPerformed

    private void conectionsLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conectionsLeftActionPerformed

    }//GEN-LAST:event_conectionsLeftActionPerformed

    private void resetMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetMenuActionPerformed
        textSpace.setText(null);
    }//GEN-LAST:event_resetMenuActionPerformed

    private void connectionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectionButtonActionPerformed
        if (!connect) {
            setConnection(!connect);
            alterText("Min set to: " + lowValue + "\tMax set to: " + highValue);
        } else {
            setConnection(!connect);
        }


    }//GEN-LAST:event_connectionButtonActionPerformed

    private void minValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minValueActionPerformed
        testDropDowns("min");
    }//GEN-LAST:event_minValueActionPerformed

    private void maxValueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxValueActionPerformed
        testDropDowns("max");
    }//GEN-LAST:event_maxValueActionPerformed

    public void updateTime() {
        now = Calendar.getInstance();
        Date time = now.getTime();
        currentTimeValue.setText(dateFormat.format(time));
        elapsedTimeValue.setText(dateFormat.format((time.getTime() - start.getTimeInMillis() - 3600000)));
    }

    private void testDropDowns(String v) {
        if (maxValue.getSelectedItem() != null && maxValue.getSelectedItem().toString() != null) {
            if (minValue.getSelectedItem() != null && minValue.getSelectedItem().toString() != null) {
                highValue = Integer.parseInt(maxValue.getSelectedItem().toString());
                lowValue = Integer.parseInt(minValue.getSelectedItem().toString());
                if (highValue <= lowValue) {
                    switch (v) {
                        case "max":
                            maxValue.setSelectedItem(oldHighValue);
                            break;
                        case "min":
                            minValue.setSelectedItem(oldLowValue);
                            break;
                    }
                    Component frame = null;
                    JOptionPane.showMessageDialog(frame, "The \"Max Value\" must be more than the \"Min Value\"!");
                } else {
                    switch (v) {
                        case "max":
                            oldHighValue = highValue;
                            break;
                        case "min":
                            oldLowValue = lowValue;
                            break;
                    }
                    highLowValue = highValue + "," + lowValue;
                }
            }
        }
    }

    public String getMaxMin() {
        return highLowValue;
    }

    public void setConnection(boolean connected) {
        if (connected) {
            connect = true;
            maxValue.setEnabled(false);
            minValue.setEnabled(false);
            opModeValue.setText("Remote");
            connectionButton.setText("Disconnect");
        } else {
            opModeValue.setText("Local");
            connectionButton.setText("Connect");
            connect = false;
            maxValue.setEnabled(true);
            minValue.setEnabled(true);
        }
    }

    public void alterText(String text) {
        now = Calendar.getInstance();
        textSpace.append(dateFormat.format(now.getTime()) + " | " + text + "\n");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bpmLabel;
    private javax.swing.JLabel bpmValue;
    private javax.swing.JMenuItem conectionsLeft;
    private javax.swing.JButton connectionButton;
    private javax.swing.JLabel currentTime;
    private javax.swing.JLabel currentTimeValue;
    private javax.swing.JLabel elapsedTime;
    private javax.swing.JLabel elapsedTimeValue;
    private javax.swing.JMenuItem exit;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel maxLabel;
    private javax.swing.JComboBox maxValue;
    private javax.swing.JMenu menuExit;
    private javax.swing.JLabel minLabel;
    private javax.swing.JComboBox minValue;
    private javax.swing.JLabel opModeLabel;
    private javax.swing.JLabel opModeValue;
    private javax.swing.JMenuItem resetMenu;
    private javax.swing.JTextArea textSpace;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
