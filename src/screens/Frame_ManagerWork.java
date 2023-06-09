/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package screens;

import entities.Employee;
import entities.ParkingLot;
import entities.Ticket;
import entities.LoggedVehicle;

import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LA
 */
public class Frame_ManagerWork extends javax.swing.JFrame {

    private int employeeRowSelected = -1;
    Map<String, ParkingLot> parkingLots;
    static List<LoggedVehicle> logs = new ArrayList<>();

    /**
     * Creates new form Frame_Management
     */
    public Frame_ManagerWork() {
        initComponents();

        String spinnerDatePattern = "dd/MM/yyyy";

        SpinnerDateModel model_startDate = new SpinnerDateModel();
        jSpinner_startDate.setModel(model_startDate);
        jSpinner_startDate.setEditor(new JSpinner.DateEditor(jSpinner_startDate, spinnerDatePattern));

        SpinnerDateModel model_endDate = new SpinnerDateModel();
        jSpinner_endDate.setModel(model_endDate);
        jSpinner_endDate.setEditor(new JSpinner.DateEditor(jSpinner_endDate, spinnerDatePattern));

        getLogs(
                LocalDate.now(),
                LocalDate.now());
        System.out.println("log");
        for (LoggedVehicle log : logs) {

            System.out.println(log.toString());

        }
        DefaultTableModel modelLogs = (DefaultTableModel) jTable_logs.getModel();
        int i = 0;
        for (LoggedVehicle log : logs) {

//                modelLogs.addRow(new Object[]{"1"});
            modelLogs.addRow(new Object[]{
                ++i,
                log.getTicket(),
                log.getLicensePlate(),
                log.getType(),
                log.getTimeOut().split("\\-")[0],
                log.getTimeIn().split("\\-")[1],
                log.getTimeOut().split("\\-")[1],
                log.getParkingLotID(),
                log.getParkingFee()
            });
        }
        jTable_logs.setModel(modelLogs);

        ListSelectionModel employeeListSelectionModel = jTable_employeeList.getSelectionModel();
        employeeListSelectionModel.addListSelectionListener(e -> employeeRowSelected = jTable_employeeList.getSelectedRow());
        loadEmployeeTable();

        parkingLots = new TreeMap<>();
        try {
            parkingLots = dataAccess.ParkingLotDataAccess.getParkingLots();
        } catch (IOException ex) {
            Logger.getLogger(Frame_ManagerWork.class.getName()).log(Level.SEVERE, null, ex);
        }

        jComboBox_home_parkingLot.addItem(new ParkingLot() {
            @Override
            public String toString() {
                return "All parking lot";
            }
        });

        for(ParkingLot lot : parkingLots.values()){
            jComboBox_parkingLot.addItem(lot);
            jComboBox_edit_parkingLot.addItem(lot);
            jComboBox_home_parkingLot.addItem(lot);
        }

        //Ticket
        Set<Ticket> tickets = new TreeSet<>();
        try {
            tickets = dataAccess.TicketDataAccess.getTickets();
        } catch (IOException ex) {
            Logger.getLogger(Frame_ManagerWork.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultListModel model = new DefaultListModel<>();
        model.addAll(tickets);
        jList_tickets.setModel(model);

    }

    public void renderLogTable(LocalDate start, LocalDate end) {
        DefaultTableModel modelLogs = (DefaultTableModel) jTable_logs.getModel();
        modelLogs.setRowCount(0);
        getLogs(start, end);
        ParkingLot p = (ParkingLot) jComboBox_home_parkingLot.getSelectedItem();
        String parkingLotID = p.getId();
        int i = 0;

        for (LoggedVehicle log : logs) {
            if (parkingLotID == null
                    || parkingLotID.compareTo(log.getParkingLotID()) == 0) {
                modelLogs.addRow(new Object[]{
                    ++i,
                    log.getTicket(),
                    log.getLicensePlate(),
                    log.getType(),
                    log.getTimeOut().split("\\-")[0],
                    log.getTimeIn().split("\\-")[1],
                    log.getTimeOut().split("\\-")[1],
                    log.getParkingLotID(),
                    log.getParkingFee()
                });
            }
        }
        jTable_logs.setModel(modelLogs);
    }

    public static void getLogs(LocalDate start, LocalDate end) {
        logs.clear();
        if (start.isAfter(end)) return;
        
        end = end.plusDays(1);

        Stream<LocalDate> s = start.datesUntil(end);
        s.forEach(action -> {
            String log = action.format(DateTimeFormatter.BASIC_ISO_DATE);
            System.out.println(log);
            try {
                List<LoggedVehicle> v = dataAccess.LogDataAccess.getLogs(log);
                logs.addAll(v);
            } catch (IOException ex) {
                Logger.getLogger(Frame_ManagerWork.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog_editFrom = new javax.swing.JDialog();
        jLabel11 = new javax.swing.JLabel();
        jTextField_edit_staffID = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField_edit_fullName = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField_edit_phoneNumber = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jComboBox_edit_parkingLot = new javax.swing.JComboBox<>();
        jButton_save = new javax.swing.JButton();
        jButton_cancel = new javax.swing.JButton();
        jLabel_edit_nameMessage = new javax.swing.JLabel();
        jLabel_edit_phoneMessage = new javax.swing.JLabel();
        jLabel_edit_pakingLotMessage = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jButton_general = new javax.swing.JButton();
        jButton_staffManagement = new javax.swing.JButton();
        jButton_ticketManagement = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel_general = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox_home_parkingLot = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_logs = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSpinner_startDate = new javax.swing.JSpinner();
        jSpinner_endDate = new javax.swing.JSpinner();
        jButton2 = new javax.swing.JButton();
        jPanel_staffManagement = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField_staffID = new javax.swing.JTextField();
        jTextField_fullName = new javax.swing.JTextField();
        jTextField_phoneNumber = new javax.swing.JTextField();
        jComboBox_parkingLot = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_employeeList = new javax.swing.JTable();
        jButton_add = new javax.swing.JButton();
        jButton_edit = new javax.swing.JButton();
        jButton_delete = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel_idMessage = new javax.swing.JLabel();
        jLabel_nameMessage = new javax.swing.JLabel();
        jLabel_phoneMessage = new javax.swing.JLabel();
        jLabel_parkingLotMessage = new javax.swing.JLabel();
        jPanel_ticketManagement = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList_tickets = new javax.swing.JList<>();
        jLabel19 = new javax.swing.JLabel();
        jTextField_ticketNumber = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jButton_addTicket = new javax.swing.JButton();
        jButton_deleteTicket = new javax.swing.JButton();

        jDialog_editFrom.setModal(true);
        jDialog_editFrom.setSize(new java.awt.Dimension(500, 400));

        jLabel11.setText("Staff ID");

        jTextField_edit_staffID.setEditable(false);
        jTextField_edit_staffID.setEnabled(false);

        jLabel12.setText("Full Name");

        jLabel13.setText("Phone number");

        jLabel14.setText("Parking lot");

        jComboBox_edit_parkingLot.addActionListener(this::jComboBox_edit_parkingLotActionPerformed);

        jButton_save.setText("Save");
        jButton_save.addActionListener(this::jButton_saveActionPerformed);

        jButton_cancel.setText("Cancel");
        jButton_cancel.addActionListener(this::jButton_cancelActionPerformed);

        jLabel_edit_nameMessage.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_edit_nameMessage.setText("jLabel10");

        jLabel_edit_phoneMessage.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_edit_phoneMessage.setText("jLabel10");

        jLabel_edit_pakingLotMessage.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_edit_pakingLotMessage.setText("jLabel10");

        javax.swing.GroupLayout jDialog_editFromLayout = new javax.swing.GroupLayout(jDialog_editFrom.getContentPane());
        jDialog_editFrom.getContentPane().setLayout(jDialog_editFromLayout);
        jDialog_editFromLayout.setHorizontalGroup(
            jDialog_editFromLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog_editFromLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jDialog_editFromLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog_editFromLayout.createSequentialGroup()
                        .addGroup(jDialog_editFromLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDialog_editFromLayout.createSequentialGroup()
                                .addComponent(jButton_save, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 148, Short.MAX_VALUE)
                                .addComponent(jButton_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDialog_editFromLayout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jDialog_editFromLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_edit_pakingLotMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox_edit_parkingLot, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDialog_editFromLayout.createSequentialGroup()
                        .addGroup(jDialog_editFromLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jDialog_editFromLayout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jTextField_edit_staffID))
                            .addGroup(jDialog_editFromLayout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addGroup(jDialog_editFromLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jDialog_editFromLayout.createSequentialGroup()
                                        .addComponent(jLabel_edit_nameMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jTextField_edit_fullName)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jDialog_editFromLayout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jDialog_editFromLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_edit_phoneMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField_edit_phoneNumber))))
                        .addGap(48, 48, 48))))
        );
        jDialog_editFromLayout.setVerticalGroup(
            jDialog_editFromLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog_editFromLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jDialog_editFromLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField_edit_staffID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jDialog_editFromLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField_edit_fullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(jLabel_edit_nameMessage)
                .addGap(18, 18, 18)
                .addGroup(jDialog_editFromLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField_edit_phoneNumber))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_edit_phoneMessage)
                .addGap(18, 18, 18)
                .addGroup(jDialog_editFromLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jComboBox_edit_parkingLot))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_edit_pakingLotMessage)
                .addGap(38, 38, 38)
                .addGroup(jDialog_editFromLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_save)
                    .addComponent(jButton_cancel))
                .addGap(8, 8, 8))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jButton_general.setText("General");
        jButton_general.addActionListener(this::jButton_generalActionPerformed);

        jButton_staffManagement.setText("Staff management");
        jButton_staffManagement.addActionListener(this::jButton_staffManagementActionPerformed);

        jButton_ticketManagement.setText("Ticket management");
        jButton_ticketManagement.addActionListener(this::jButton_ticketManagementActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton_general)
                .addGap(18, 18, 18)
                .addComponent(jButton_staffManagement)
                .addGap(18, 18, 18)
                .addComponent(jButton_ticketManagement)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_general)
                    .addComponent(jButton_staffManagement)
                    .addComponent(jButton_ticketManagement))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2.setLayout(new java.awt.CardLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GENERAL INFORMATION");

        jLabel2.setText("Parking lot");

        jTable_logs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order", "Ticket", "Licenes plate", "Vehicle", "Date", "Time in", "Time out", "Parking lot", "Parking fee"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable_logs);
        if (jTable_logs.getColumnModel().getColumnCount() > 0) {
            jTable_logs.getColumnModel().getColumn(0).setResizable(false);
            jTable_logs.getColumnModel().getColumn(0).setPreferredWidth(20);
            jTable_logs.getColumnModel().getColumn(1).setPreferredWidth(50);
            jTable_logs.getColumnModel().getColumn(6).setPreferredWidth(50);
            jTable_logs.getColumnModel().getColumn(8).setPreferredWidth(50);
        }

        jLabel3.setText("From");

        jLabel4.setText("To");

        jButton1.setText("Check");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jSpinner_startDate.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(1686250972035L), null, null, java.util.Calendar.DAY_OF_MONTH));

        jButton2.setText("Revenue");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        javax.swing.GroupLayout jPanel_generalLayout = new javax.swing.GroupLayout(jPanel_general);
        jPanel_general.setLayout(jPanel_generalLayout);
        jPanel_generalLayout.setHorizontalGroup(
            jPanel_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_generalLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(jPanel_generalLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jComboBox_home_parkingLot, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSpinner_startDate, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                        .addComponent(jSpinner_endDate))
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel_generalLayout.setVerticalGroup(
            jPanel_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_generalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(jPanel_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox_home_parkingLot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jSpinner_startDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jSpinner_endDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel_generalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );

        jPanel2.add(jPanel_general, "card4");

        jLabel6.setText("Staff ID");

        jLabel7.setText("Full Name");

        jLabel8.setText("Phone number");

        jLabel9.setText("Parking lot");

        jTable_employeeList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order", "Staff ID", "Full name", "Phone number", "Parking lot"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_employeeList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jTable_employeeList);
        if (jTable_employeeList.getColumnModel().getColumnCount() > 0) {
            jTable_employeeList.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        jButton_add.setText("Add");
        jButton_add.addActionListener(this::jButton_addActionPerformed);

        jButton_edit.setText("Edit");
        jButton_edit.addActionListener(this::jButton_editActionPerformed);

        jButton_delete.setText("Delete");
        jButton_delete.addActionListener(this::jButton_deleteActionPerformed);

        jLabel16.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("STAFF MANAGEMENT");
        jLabel16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel_idMessage.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_idMessage.setText("jLabel10");

        jLabel_nameMessage.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_nameMessage.setText("jLabel10");

        jLabel_phoneMessage.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_phoneMessage.setText("jLabel10");

        jLabel_parkingLotMessage.setForeground(new java.awt.Color(255, 0, 0));
        jLabel_parkingLotMessage.setText("jLabel10");

        javax.swing.GroupLayout jPanel_staffManagementLayout = new javax.swing.GroupLayout(jPanel_staffManagement);
        jPanel_staffManagement.setLayout(jPanel_staffManagementLayout);
        jPanel_staffManagementLayout.setHorizontalGroup(
            jPanel_staffManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_staffManagementLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel_staffManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel_staffManagementLayout.createSequentialGroup()
                        .addGroup(jPanel_staffManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel_staffManagementLayout.createSequentialGroup()
                                .addGroup(jPanel_staffManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel_staffManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField_staffID)
                                    .addComponent(jTextField_phoneNumber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                                    .addComponent(jTextField_fullName)
                                    .addComponent(jLabel_idMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel_nameMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel_phoneMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel_staffManagementLayout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel_staffManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_parkingLotMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox_parkingLot, 0, 192, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel_staffManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_edit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_delete, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(147, Short.MAX_VALUE))
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel_staffManagementLayout.setVerticalGroup(
            jPanel_staffManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_staffManagementLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel_staffManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField_staffID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_add))
                .addGroup(jPanel_staffManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel_staffManagementLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton_edit)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_delete)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_staffManagementLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_idMessage)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel_staffManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextField_fullName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_nameMessage)
                        .addGap(13, 13, 13)))
                .addGroup(jPanel_staffManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField_phoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_phoneMessage)
                .addGap(7, 7, 7)
                .addGroup(jPanel_staffManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBox_parkingLot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_parkingLotMessage)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel_staffManagement, "card3");

        jList_tickets.addListSelectionListener(this::jList_ticketsValueChanged);
        jScrollPane3.setViewportView(jList_tickets);

        jLabel19.setText("Ticket number");

        jLabel20.setFont(new java.awt.Font("Segoe UI", Font.PLAIN, 18)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("TICKET MANAGEMENT");

        jButton_addTicket.setText("Add");
        jButton_addTicket.addActionListener(this::jButton_addTicketActionPerformed);

        jButton_deleteTicket.setText("Delete");
        jButton_deleteTicket.addActionListener(this::jButton_deleteTicketActionPerformed);

        javax.swing.GroupLayout jPanel_ticketManagementLayout = new javax.swing.GroupLayout(jPanel_ticketManagement);
        jPanel_ticketManagement.setLayout(jPanel_ticketManagementLayout);
        jPanel_ticketManagementLayout.setHorizontalGroup(
            jPanel_ticketManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ticketManagementLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel_ticketManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_ticketManagementLayout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_ticketNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel_ticketManagementLayout.createSequentialGroup()
                        .addComponent(jButton_addTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(jButton_deleteTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel_ticketManagementLayout.setVerticalGroup(
            jPanel_ticketManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_ticketManagementLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel20)
                .addGap(34, 34, 34)
                .addGroup(jPanel_ticketManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_ticketManagementLayout.createSequentialGroup()
                        .addGroup(jPanel_ticketManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(jTextField_ticketNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel_ticketManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_addTicket)
                            .addComponent(jButton_deleteTicket)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(171, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel_ticketManagement, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_generalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_generalActionPerformed
        // TODO add your handling code here:
        jPanel_general.setVisible(true);
        jPanel_staffManagement.setVisible(false);
        jPanel_ticketManagement.setVisible(false);
    }//GEN-LAST:event_jButton_generalActionPerformed

    private void jButton_staffManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_staffManagementActionPerformed
        // TODO add your handling code here:
        jPanel_general.setVisible(false);
        jPanel_staffManagement.setVisible(true);
        jPanel_ticketManagement.setVisible(false);
    }//GEN-LAST:event_jButton_staffManagementActionPerformed

    private void jButton_ticketManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ticketManagementActionPerformed
        // TODO add your handling code here:
        jPanel_general.setVisible(false);
        jPanel_staffManagement.setVisible(false);
        jPanel_ticketManagement.setVisible(true);
    }//GEN-LAST:event_jButton_ticketManagementActionPerformed

    private void jButton_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_editActionPerformed
        // TODO add your handling code here:
        if (employeeRowSelected < 0) {
            //TODO:
            return;
        }

        jLabel_edit_nameMessage.setText("");
        jLabel_edit_phoneMessage.setText("");
        jLabel_edit_pakingLotMessage.setText("");
        jLabel_edit_pakingLotMessage.setText("");

        jTextField_edit_staffID.setText(jTable_employeeList.getValueAt(employeeRowSelected, 1).toString());
        jTextField_edit_fullName.setText(jTable_employeeList.getValueAt(employeeRowSelected, 2).toString());
        jTextField_edit_phoneNumber.setText(jTable_employeeList.getValueAt(employeeRowSelected, 3).toString());
        String parkingLotIdSelected = jTable_employeeList.getValueAt(employeeRowSelected, 4).toString();

        ParkingLot parkingLotSelected = parkingLots.get(parkingLotIdSelected);
        jComboBox_edit_parkingLot.setSelectedItem(parkingLotSelected);

        System.out.println(parkingLots.get(parkingLotIdSelected));

//        jDialog_editFrom.setBounds(0, 0, 400, 500);
        jDialog_editFrom.setVisible(true);
    }//GEN-LAST:event_jButton_editActionPerformed

    private void jButton_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_addActionPerformed
        // TODO add your handling code here:
        String id = jTextField_staffID.getText();
        String name = jTextField_fullName.getText();
        String phoneNumber = jTextField_phoneNumber.getText();
        String parkingLotId = ((ParkingLot) jComboBox_parkingLot.getSelectedItem()).getId();
        System.out.println(parkingLotId);
        jLabel_idMessage.setText("");
        jLabel_nameMessage.setText("");
        jLabel_phoneMessage.setText("");
        jLabel_parkingLotMessage.setText("");
        boolean flag = true;
        //validate
        //id
        final String requiredMessage = "This is a required filed";
        if (id.isEmpty() || id.isBlank()) {
            jLabel_idMessage.setText(requiredMessage);
            flag = false;
        } else if (!Pattern.matches("s\\d{4}", id)) {
            jLabel_idMessage.setText("Invalid id, id must start with s and less than 5 charaters");
            flag = false;
        }

        //name
        if (name.isEmpty() || name.isBlank()) {
            jLabel_nameMessage.setText(requiredMessage);
            flag = false;
        } else if (name.length() < 4 || name.length() > 50) {
            jLabel_nameMessage.setText("Invalid name, nums of character must greater than 4 and less than 50");
            flag = false;
        }

        //phone
        if (phoneNumber.isEmpty() || phoneNumber.isBlank()) {
            jLabel_phoneMessage.setText(requiredMessage);
            flag = false;
        } else if (phoneNumber.length() != 10 || !Pattern.matches("0\\d{9}", phoneNumber)) {
            jLabel_phoneMessage.setText("Phone number is not corect");
            flag = false;

        }

        //
        if (!flag) {
            return;
        }
        try {
            Employee e = dataAccess.EmployeeDataAccess.getEmployee(id);
            if (e != null) {
                int choosenResult = JOptionPane.showConfirmDialog(this, "Dublicate ID, Please try another ID", "title", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
                if (choosenResult == JOptionPane.OK_OPTION) {
                    return;
                }
                jTextField_staffID.setText("");
                jTextField_fullName.setText("");
                jTextField_phoneNumber.setText("");

                return;
            }
            dataAccess.EmployeeDataAccess.addEmployee(new Employee(id, name, phoneNumber, parkingLotId));
            loadEmployeeTable();
        } catch (IOException ex) {
            System.out.println("error");
        }

        jTextField_staffID.setText("");
        jTextField_fullName.setText("");
        jTextField_phoneNumber.setText("");

    }//GEN-LAST:event_jButton_addActionPerformed

    private void jButton_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_deleteActionPerformed
        // TODO add your handling code here:
        System.out.println(this.employeeRowSelected);

        if (this.employeeRowSelected > -1) {
            try {
                String employeeId = jTable_employeeList.getValueAt(employeeRowSelected, 1).toString();
                int choosenResult = JOptionPane.showConfirmDialog(this, "Do you want to delete staff <" + employeeId + ">", "Confirm delete staff", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (choosenResult == JOptionPane.NO_OPTION) {
                    return;
                }
                if (choosenResult == JOptionPane.YES_OPTION) {
                    Employee e = dataAccess.EmployeeDataAccess.getEmployee(employeeId);

                    if (e != null) {
                        dataAccess.EmployeeDataAccess.deleteEmployee(employeeId);
                        loadEmployeeTable();
                    }
                }

            } catch (IOException ex) {
                Logger.getLogger(Frame_ManagerWork.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton_deleteActionPerformed

    private void jButton_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_saveActionPerformed
        // TODO add your handling code here:
        String id = jTextField_edit_staffID.getText();
        String name = jTextField_edit_fullName.getText();
        String phoneNumber = jTextField_edit_phoneNumber.getText();
        String parkingLot = ((ParkingLot) jComboBox_edit_parkingLot.getSelectedItem()).getId();
        //validate
        boolean flag = true;
        //validate
        //id
        final String requiredMessage = "This is a required filed";
//        if (id.isEmpty() || id.isBlank()) {
//            jLabel_idMessage.setText(requiredMessage);
//            flag = false;
//        } else if (!Pattern.matches("s\\d{4}", id)) {
//            jLabel_idMessage.setText("Invalid id, id must start with s and less than 5 charaters");
//            flag = false;
//        }

        //name
        if (name.isEmpty() || name.isBlank()) {
            jLabel_edit_nameMessage.setText(requiredMessage);
            flag = false;
        } else if (name.length() < 4 || name.length() > 50) {
            jLabel_edit_nameMessage.setText("Invalid name, nums of character must greater than 4 and less than 50");
            flag = false;
        }

        //phone
        if (phoneNumber.isEmpty() || phoneNumber.isBlank()) {
            jLabel_edit_phoneMessage.setText(requiredMessage);
            flag = false;
        } else if (phoneNumber.length() != 10 || !Pattern.matches("0\\d{9}", phoneNumber)) {
            jLabel_edit_phoneMessage.setText("Phone number is not corect");
            flag = false;
        }

        //
        if (!flag) {

            return;
        }
        //
        Employee e = new Employee(id, name, phoneNumber, parkingLot);
        try {
            dataAccess.EmployeeDataAccess.editEmployee(id, e);
            loadEmployeeTable();
        } catch (IOException ex) {
            Logger.getLogger(Frame_ManagerWork.class.getName()).log(Level.SEVERE, null, ex);
        }
        jDialog_editFrom.dispose();

    }//GEN-LAST:event_jButton_saveActionPerformed

    private void jButton_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelActionPerformed
        // TODO add your handling code here:
        jDialog_editFrom.dispose();
    }//GEN-LAST:event_jButton_cancelActionPerformed

    private void jComboBox_edit_parkingLotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_edit_parkingLotActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_edit_parkingLotActionPerformed

    private void jButton_deleteTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_deleteTicketActionPerformed
        // TODO add your handling code here:

        String ticketSeleted = jTextField_ticketNumber.getText().trim();

        if (ticketSeleted.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No ticket was selected");
            return;
        }
        Set<Ticket> tickets = new TreeSet<>();

        try {
            tickets = dataAccess.TicketDataAccess.getTickets();
        } catch (IOException ex) {
            Logger.getLogger(Frame_ManagerWork.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (tickets.contains(new Ticket(ticketSeleted))) {
            try {
                dataAccess.TicketDataAccess.deleteTicket(ticketSeleted);
                tickets = dataAccess.TicketDataAccess.getTickets();
            } catch (IOException ex) {
                Logger.getLogger(Frame_ManagerWork.class.getName()).log(Level.SEVERE, null, ex);
            }
            DefaultListModel model = (DefaultListModel) jList_tickets.getModel();
            model.clear();
            model.addAll(tickets);
        } else
            JOptionPane.showMessageDialog(this, "This ticket is not exsits");



//        DefaultListModel model = (DefaultListModel) jList_tickets.getModel();
//        model.clear();

    }//GEN-LAST:event_jButton_deleteTicketActionPerformed

    private void jList_ticketsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList_ticketsValueChanged
        // TODO add your handling code here:
        if (jList_tickets.getSelectedIndex() != -1) {
            System.out.println(jList_tickets.getSelectedValue());
            String ticketSelected = jList_tickets.getSelectedValue().toString();
            jTextField_ticketNumber.setText(ticketSelected);
        }

    }//GEN-LAST:event_jList_ticketsValueChanged

    private void jButton_addTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_addTicketActionPerformed
        // TODO add your handling code here:
        String ticket = jTextField_ticketNumber.getText().trim();

        if (ticket.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Empty value");
        } else {
            Set<Ticket> tickets = new TreeSet<>();

            try {
                tickets = dataAccess.TicketDataAccess.getTickets();
            } catch (IOException ex) {
                Logger.getLogger(Frame_ManagerWork.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (tickets.contains(new Ticket(ticket))) {
                JOptionPane.showMessageDialog(this, "This ticket was existed");
            } else {
                try {
                    dataAccess.TicketDataAccess.addTicket(new Ticket(ticket));
                    tickets = dataAccess.TicketDataAccess.getTickets();
                    DefaultListModel model = (DefaultListModel) jList_tickets.getModel();
                    model.clear();
                    model.addAll(tickets);
                } catch (IOException ex) {
                    Logger.getLogger(Frame_ManagerWork.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButton_addTicketActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Date start = (Date) jSpinner_startDate.getValue();
        Date end = (Date) jSpinner_endDate.getValue();

        LocalDate startDate = LocalDate.of(start.getYear() + 1900, start.getMonth() + 1, start.getDate());
        LocalDate endDate = LocalDate.of(end.getYear() + 1900, end.getMonth() + 1, end.getDate());
        if (endDate.isBefore(startDate)) {
            JOptionPane.showMessageDialog(this,
                    "Oops! Date interval is not valid.");
//            return;
        }
        renderLogTable(startDate, endDate);
        System.out.println(startDate);
        System.out.println(endDate);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int totalRevenue = logs.stream()
                .mapToInt(LoggedVehicle::getParkingFee)
                .sum();
        JOptionPane.showMessageDialog(this,"Total revenue: %d".formatted(totalRevenue));

    }//GEN-LAST:event_jButton2ActionPerformed

    private void loadEmployeeTable() {
        DefaultTableModel model = (DefaultTableModel) jTable_employeeList.getModel();
        jTable_employeeList.setModel(model);
        model.setRowCount(0);

        try {
            Map<String, Employee> employees = dataAccess.EmployeeDataAccess.getEmployees();
            int i = 1;
            for (Map.Entry<String, Employee> entry : employees.entrySet()) {
                Employee val = entry.getValue();
                model.addRow(new Object[]{i++, val.getId(), val.getName(), val.getPhoneNumber(), val.getParkingLotID()});
            }

        } catch (IOException ex) {
            Logger.getLogger(Frame_ManagerWork.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
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
        } catch (ClassNotFoundException | InstantiationException |
                 IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame_ManagerWork.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Frame_ManagerWork().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton_add;
    private javax.swing.JButton jButton_addTicket;
    private javax.swing.JButton jButton_cancel;
    private javax.swing.JButton jButton_delete;
    private javax.swing.JButton jButton_deleteTicket;
    private javax.swing.JButton jButton_edit;
    private javax.swing.JButton jButton_general;
    private javax.swing.JButton jButton_save;
    private javax.swing.JButton jButton_staffManagement;
    private javax.swing.JButton jButton_ticketManagement;
    private javax.swing.JComboBox<ParkingLot> jComboBox_edit_parkingLot;
    private javax.swing.JComboBox<ParkingLot> jComboBox_home_parkingLot;
    private javax.swing.JComboBox<ParkingLot> jComboBox_parkingLot;
    private javax.swing.JDialog jDialog_editFrom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_edit_nameMessage;
    private javax.swing.JLabel jLabel_edit_pakingLotMessage;
    private javax.swing.JLabel jLabel_edit_phoneMessage;
    private javax.swing.JLabel jLabel_idMessage;
    private javax.swing.JLabel jLabel_nameMessage;
    private javax.swing.JLabel jLabel_parkingLotMessage;
    private javax.swing.JLabel jLabel_phoneMessage;
    private javax.swing.JList<Ticket> jList_tickets;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel_general;
    private javax.swing.JPanel jPanel_staffManagement;
    private javax.swing.JPanel jPanel_ticketManagement;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinner_endDate;
    private javax.swing.JSpinner jSpinner_startDate;
    private javax.swing.JTable jTable_employeeList;
    private javax.swing.JTable jTable_logs;
    private javax.swing.JTextField jTextField_edit_fullName;
    private javax.swing.JTextField jTextField_edit_phoneNumber;
    private javax.swing.JTextField jTextField_edit_staffID;
    private javax.swing.JTextField jTextField_fullName;
    private javax.swing.JTextField jTextField_phoneNumber;
    private javax.swing.JTextField jTextField_staffID;
    private javax.swing.JTextField jTextField_ticketNumber;
    // End of variables declaration//GEN-END:variables
}
