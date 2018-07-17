import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Zaheer 216001758
 */
public class Frame extends javax.swing.JFrame
{
	private static final long serialVersionUID = 1L;
	private Client client;
	private boolean LoggedIn = false;
	private static ArrayList<String> diseaseName = new ArrayList<String>();
	private static ArrayList<String> diseaseInfo = new ArrayList<String>();
	private static ArrayList<String> hospitals = new ArrayList<String>();
	private String[] arrDName = null;
	public String startHospitalH;
	public String destinationHospitalH;
	public String startHospitalP;
	public String destinationHospitalP;
	
	/**
     * Creates new form JFrame
     */
    public Frame(Client client)
    {
    	try {
			client.connect();
			this.client = client;
			JOptionPane.showMessageDialog(Frame.this, "Connection To ICE Successful");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(Frame.this, "Please Start Sever First");
			System.exit(-1);
		}
    	
        initComponents();
        
        read(hospitals,"data/hospitals.txt");
        read(diseaseName,"data/diseasename.txt");
    	read(diseaseInfo,"data/diseaseinfo.txt");
    	arrDName = diseaseName.toArray(new String[diseaseName.size()]);
    	DefaultComboBoxModel diseases = new DefaultComboBoxModel(arrDName);
    	cmbDiseasesN.setModel(diseases);
    	this.startHospitalH = null;
    	this.startHospitalP = null;
    	this.setTitle("ICE");
    }

    private void initComponents() 
    {
    	 mainTabbedPane = new javax.swing.JTabbedPane();
         pnlLogin = new javax.swing.JPanel();
         lblBackground1 = new javax.swing.JLabel();
         txtPassword = new javax.swing.JPasswordField();
         txtUsername = new javax.swing.JTextField();
         btnLogin = new javax.swing.JButton();
         btnRegister = new javax.swing.JButton();
         btnLogout = new javax.swing.JButton();
         lblLogo1 = new javax.swing.JLabel();
         jLabel13 = new javax.swing.JLabel();
         jLabel11 = new javax.swing.JLabel();
         jLabel25 = new javax.swing.JLabel();
         pnlPatient = new javax.swing.JPanel();
         lblLogo3 = new javax.swing.JLabel();
         jLabel4 = new javax.swing.JLabel();
         jLabel5 = new javax.swing.JLabel();
         cmbProvincePL = new javax.swing.JComboBox<>();
         jLabel6 = new javax.swing.JLabel();
         cmbHospitalPL = new javax.swing.JComboBox<>();
         btnFindClosestP = new javax.swing.JButton();
         lblBackground3 = new javax.swing.JLabel();
         jScrollPane1 = new javax.swing.JScrollPane();
         txtAreaP = new javax.swing.JTextArea();
         jLabel28 = new javax.swing.JLabel();
         cmbProvincePD = new javax.swing.JComboBox<>();
         jLabel29 = new javax.swing.JLabel();
         cmbHospital = new javax.swing.JComboBox<>();
         pnlHospital = new javax.swing.JPanel();
         lblLogo4 = new javax.swing.JLabel();
         lblBackground4 = new javax.swing.JLabel();
         jLabel7 = new javax.swing.JLabel();
         jLabel8 = new javax.swing.JLabel();
         cmbProvinceHL = new javax.swing.JComboBox<>();
         jLabel9 = new javax.swing.JLabel();
         cmbHospitalHD = new javax.swing.JComboBox<>();
         btnFindClosestH = new javax.swing.JButton();
         jScrollPane2 = new javax.swing.JScrollPane();
         txtAreaH = new javax.swing.JTextArea();
         jLabel26 = new javax.swing.JLabel();
         cmbHospitalHL = new javax.swing.JComboBox<>();
         jLabel27 = new javax.swing.JLabel();
         cmbProvinceHD = new javax.swing.JComboBox<>();
         pnlDiseases = new javax.swing.JPanel();
         lblLogo5 = new javax.swing.JLabel();
         jLabel1 = new javax.swing.JLabel();
         jLabel10 = new javax.swing.JLabel();
         cmbDiseasesN = new javax.swing.JComboBox<>();
         btnFindClosestH1 = new javax.swing.JButton();
         jLabel12 = new javax.swing.JLabel();
         jScrollPane3 = new javax.swing.JScrollPane();
         txtAreaH1 = new javax.swing.JTextArea();
         pnlSettings = new javax.swing.JPanel();
         lblLogo6 = new javax.swing.JLabel();
         jLabel2 = new javax.swing.JLabel();
         btnDeleteH = new javax.swing.JButton();
         jLabel14 = new javax.swing.JLabel();
         jLabel3 = new javax.swing.JLabel();
         jLabel15 = new javax.swing.JLabel();
         jLabel16 = new javax.swing.JLabel();
         btnDeleteD = new javax.swing.JButton();
         btnAddD = new javax.swing.JButton();
         btnAddH = new javax.swing.JButton();
         jLabel17 = new javax.swing.JLabel();
         jLabel18 = new javax.swing.JLabel();
         jLabel19 = new javax.swing.JLabel();
         jLabel20 = new javax.swing.JLabel();
         jLabel21 = new javax.swing.JLabel();
         jLabel22 = new javax.swing.JLabel();
         jLabel23 = new javax.swing.JLabel();
         txtHName = new javax.swing.JTextField();
         txtHTo = new javax.swing.JTextField();
         txtHFrom = new javax.swing.JTextField();
         txtHDistance = new javax.swing.JTextField();
         txtDName = new javax.swing.JTextField();
         txtDDescription = new javax.swing.JTextField();
         jLabel24 = new javax.swing.JLabel();

         setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

         mainTabbedPane.setBackground(new java.awt.Color(255, 255, 255));
         mainTabbedPane.setFont(new java.awt.Font("Calibri", 1, 11)); // 
         mainTabbedPane.setName(""); // 

         pnlLogin.setBackground(new java.awt.Color(255, 255, 255));

         lblBackground1.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/background (2).png"))); // 
         lblBackground1.setMinimumSize(new java.awt.Dimension(1184, 1142));
         lblBackground1.setPreferredSize(new java.awt.Dimension(300, 500));

         txtPassword.setFont(new java.awt.Font("Calibri", 0, 11)); // 
         txtPassword.setForeground(new java.awt.Color(211, 0, 0));
         txtPassword.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(218, 0, 0)));

         txtUsername.setFont(new java.awt.Font("Calibri", 0, 11)); // 
         txtUsername.setForeground(new java.awt.Color(216, 0, 0));
         txtUsername.setToolTipText("");
         txtUsername.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(215, 0, 0)));

         btnLogin.setBackground(new java.awt.Color(255, 255, 255));
         btnLogin.setFont(new java.awt.Font("Calibri", 0, 11)); // 
         btnLogin.setText("Login");
         btnLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(213, 0, 0)));
         btnLogin.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 btnLoginActionPerformed(evt);
             }
         });

         btnRegister.setBackground(new java.awt.Color(255, 255, 255));
         btnRegister.setFont(new java.awt.Font("Calibri", 0, 11)); // 
         btnRegister.setText("Register");
         btnRegister.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(211, 0, 0)));
         btnRegister.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 btnRegisterActionPerformed(evt);
             }
         });

         btnLogout.setBackground(new java.awt.Color(255, 255, 255));
         btnLogout.setFont(new java.awt.Font("Calibri", 0, 11)); // 
         btnLogout.setText("Logout");
         btnLogout.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(207, 0, 0)));
         btnLogout.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 btnLogoutActionPerformed(evt);
             }
         });

         lblLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/Logo.png"))); // 

         jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/login.png"))); // 

         jLabel11.setForeground(new java.awt.Color(220, 0, 0));
         jLabel11.setText("Username");

         jLabel25.setForeground(new java.awt.Color(206, 0, 0));
         jLabel25.setText("Password");

         javax.swing.GroupLayout pnlLoginLayout = new javax.swing.GroupLayout(pnlLogin);
         pnlLogin.setLayout(pnlLoginLayout);
         pnlLoginLayout.setHorizontalGroup(
             pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(pnlLoginLayout.createSequentialGroup()
                 .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(pnlLoginLayout.createSequentialGroup()
                         .addGap(0, 50, Short.MAX_VALUE)
                         .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addGroup(pnlLoginLayout.createSequentialGroup()
                                 .addGap(20, 20, 20)
                                 .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                     .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                     .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                     .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                             .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addComponent(jLabel11)
                             .addComponent(jLabel25)))
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlLoginLayout.createSequentialGroup()
                         .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(lblLogo1)
                         .addGap(52, 52, 52)))
                 .addComponent(lblBackground1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE))
         );
         pnlLoginLayout.setVerticalGroup(
             pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(pnlLoginLayout.createSequentialGroup()
                 .addGroup(pnlLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                     .addGroup(pnlLoginLayout.createSequentialGroup()
                         .addGap(20, 20, 20)
                         .addComponent(lblLogo1)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addComponent(jLabel13)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(jLabel11)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addGap(2, 2, 2)
                         .addComponent(jLabel25)
                         .addGap(2, 2, 2)
                         .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addGap(31, 31, 31)
                         .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                         .addComponent(btnRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                         .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addComponent(lblBackground1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addGap(0, 277, Short.MAX_VALUE))
         );

         mainTabbedPane.addTab("Login", pnlLogin);

         pnlPatient.setBackground(new java.awt.Color(255, 255, 255));

         lblLogo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/Logo.png"))); // 

         jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/patient.png"))); // 

         jLabel5.setBackground(new java.awt.Color(255, 255, 255));
         jLabel5.setFont(new java.awt.Font("Calibri", 0, 11)); // 
         jLabel5.setForeground(new java.awt.Color(206, 0, 0));
         jLabel5.setText("Current Province");

         cmbProvincePL.setFont(new java.awt.Font("Calibri", 0, 11)); // 
         cmbProvincePL.setForeground(new java.awt.Color(227, 0, 0));
         cmbProvincePL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Eastern Cape", "Free State", "Gauteng", "KwaZulu-Natal", "Limpopo", "Mpumalanga", "Northern Cape", "North West Province", "Western Cape" }));
         cmbProvincePL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(221, 0, 0)));
         cmbProvincePL.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 cmbProvincePLActionPerformed(evt);
             }
         });

         jLabel6.setBackground(new java.awt.Color(255, 255, 255));
         jLabel6.setFont(new java.awt.Font("Calibri", 0, 11)); // 
         jLabel6.setForeground(new java.awt.Color(206, 0, 0));
         jLabel6.setText("Current Location");

         cmbHospitalPL.setFont(new java.awt.Font("Calibri", 0, 11)); // 
         cmbHospitalPL.setForeground(new java.awt.Color(207, 0, 0));
         cmbHospitalPL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 0, 0)));
         cmbHospitalPL.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
               //  cmbHospitalPLActionPerformed(evt);
             }
         });

         btnFindClosestP.setBackground(new java.awt.Color(255, 255, 255));
         btnFindClosestP.setFont(new java.awt.Font("Calibri", 0, 11)); // 
         btnFindClosestP.setForeground(new java.awt.Color(215, 0, 0));
         btnFindClosestP.setText("Find Closest Route");
         btnFindClosestP.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 btnFindClosestPActionPerformed(evt);
             }
         });

         lblBackground3.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/Webp.net-resizeimage (7).png"))); // 
         lblBackground3.setMinimumSize(new java.awt.Dimension(1184, 1142));
         lblBackground3.setPreferredSize(new java.awt.Dimension(300, 500));

         txtAreaP.setColumns(20);
         txtAreaP.setFont(new java.awt.Font("Calibri", 1, 12)); // 
         txtAreaP.setForeground(new java.awt.Color(215, 0, 0));
         txtAreaP.setRows(5);
         txtAreaP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(213, 0, 0)));
         jScrollPane1.setViewportView(txtAreaP);

         jLabel28.setBackground(new java.awt.Color(255, 255, 255));
         jLabel28.setFont(new java.awt.Font("Calibri", 0, 11)); // 
         jLabel28.setForeground(new java.awt.Color(206, 0, 0));
         jLabel28.setText("Destination Province");

         cmbProvincePD.setFont(new java.awt.Font("Calibri", 0, 11)); // 
         cmbProvincePD.setForeground(new java.awt.Color(227, 0, 0));
         cmbProvincePD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Eastern Cape", "Free State", "Gauteng", "KwaZulu-Natal", "Limpopo", "Mpumalanga", "Northern Cape", "North West Province", "Western Cape" }));
         cmbProvincePD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(221, 0, 0)));
         cmbProvincePD.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 cmbProvincePDActionPerformed(evt);
             }
         });

         jLabel29.setBackground(new java.awt.Color(255, 255, 255));
         jLabel29.setFont(new java.awt.Font("Calibri", 0, 11)); // 
         jLabel29.setForeground(new java.awt.Color(206, 0, 0));
         jLabel29.setText("Destination Hospital");

         cmbHospital.setFont(new java.awt.Font("Calibri", 0, 11)); // 
         cmbHospital.setForeground(new java.awt.Color(207, 0, 0));
         cmbHospital.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 0, 0)));
         cmbHospital.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                // cmbHospitalActionPerformed(evt);
             }
         });

         javax.swing.GroupLayout pnlPatientLayout = new javax.swing.GroupLayout(pnlPatient);
         pnlPatient.setLayout(pnlPatientLayout);
         pnlPatientLayout.setHorizontalGroup(
             pnlPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(pnlPatientLayout.createSequentialGroup()
                 .addGap(18, 18, 18)
                 .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 813, Short.MAX_VALUE)
                 .addContainerGap())
             .addGroup(pnlPatientLayout.createSequentialGroup()
                 .addGroup(pnlPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(pnlPatientLayout.createSequentialGroup()
                         .addGroup(pnlPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addGroup(pnlPatientLayout.createSequentialGroup()
                                 .addGroup(pnlPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                     .addGroup(pnlPatientLayout.createSequentialGroup()
                                         .addGap(32, 32, 32)
                                         .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                     .addGroup(pnlPatientLayout.createSequentialGroup()
                                         .addGap(65, 65, 65)
                                         .addComponent(lblLogo3)))
                                 .addGap(0, 0, Short.MAX_VALUE))
                             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPatientLayout.createSequentialGroup()
                                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                 .addGroup(pnlPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                         .addComponent(cmbHospital, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                         .addComponent(cmbProvincePD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                         .addGroup(pnlPatientLayout.createSequentialGroup()
                                             .addGap(27, 27, 27)
                                             .addComponent(jLabel28)
                                             .addGap(14, 14, 14))
                                         .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPatientLayout.createSequentialGroup()
                                             .addComponent(jLabel29)
                                             .addGap(32, 32, 32)))
                                     .addComponent(cmbHospitalPL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                         .addGroup(pnlPatientLayout.createSequentialGroup()
                                             .addGap(38, 38, 38)
                                             .addComponent(jLabel5))
                                         .addComponent(cmbProvincePL, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPatientLayout.createSequentialGroup()
                                         .addComponent(jLabel6)
                                         .addGap(53, 53, 53)))))
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPatientLayout.createSequentialGroup()
                         .addGap(0, 0, Short.MAX_VALUE)
                         .addComponent(btnFindClosestP)
                         .addGap(30, 30, 30)))
                 .addComponent(lblBackground3, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE))
         );
         pnlPatientLayout.setVerticalGroup(
             pnlPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(pnlPatientLayout.createSequentialGroup()
                 .addGroup(pnlPatientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(pnlPatientLayout.createSequentialGroup()
                         .addContainerGap()
                         .addComponent(lblLogo3)
                         .addGap(3, 3, 3)
                         .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addGap(18, 18, 18)
                         .addComponent(jLabel5)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addComponent(cmbProvincePL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addGap(18, 18, 18)
                         .addComponent(jLabel6)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addComponent(cmbHospitalPL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addGap(40, 40, 40)
                         .addComponent(jLabel28)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addComponent(cmbProvincePD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addGap(18, 18, 18)
                         .addComponent(jLabel29)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addComponent(cmbHospital, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                         .addComponent(btnFindClosestP)
                         .addGap(18, 18, 18))
                     .addGroup(pnlPatientLayout.createSequentialGroup()
                         .addComponent(lblBackground3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                 .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addContainerGap())
         );

         mainTabbedPane.addTab("Patients", pnlPatient);

         pnlHospital.setBackground(new java.awt.Color(255, 255, 255));
         pnlHospital.setFont(new java.awt.Font("Calibri", 0, 11)); // 

         lblLogo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/Logo.png"))); // 

         lblBackground4.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/Webp.net-resizeimage (7).png"))); // 
         lblBackground4.setMinimumSize(new java.awt.Dimension(1184, 1142));
         lblBackground4.setPreferredSize(new java.awt.Dimension(300, 500));

         jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/organ.png"))); // 

         jLabel8.setBackground(new java.awt.Color(255, 255, 255));
         jLabel8.setFont(new java.awt.Font("Calibri", 0, 11)); // 
         jLabel8.setForeground(new java.awt.Color(206, 0, 0));
         jLabel8.setText("Current Province");

         cmbProvinceHL.setFont(new java.awt.Font("Calibri", 0, 11)); // 
         cmbProvinceHL.setForeground(new java.awt.Color(227, 0, 0));
         cmbProvinceHL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Eastern Cape", "Free State", "Gauteng", "KwaZulu-Natal", "Limpopo", "Mpumalanga", "Northern Cape", "North West Province", "Western Cape" }));
         cmbProvinceHL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(221, 0, 0)));
         cmbProvinceHL.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 cmbProvinceHLActionPerformed(evt);
             }
         });
         
       /* cmbHospitalHL.setSelectedIndex(-1);
     	cmbHospitalHD.setSelectedIndex(-1);
     	cmbProvinceHL.setSelectedIndex(-1);
     	cmbProvinceHD.setSelectedIndex(-1);
     	cmbHospitalPL.setSelectedIndex(-1);
     	cmbHospital.setSelectedIndex(-1);
     	cmbProvincePL.setSelectedIndex(-1);
     	cmbProvincePD.setSelectedIndex(-1);*/

         jLabel9.setBackground(new java.awt.Color(255, 255, 255));
         jLabel9.setFont(new java.awt.Font("Calibri", 0, 11)); // 
         jLabel9.setForeground(new java.awt.Color(206, 0, 0));
         jLabel9.setText("Destination Location");

         cmbHospitalHD.setFont(new java.awt.Font("Calibri", 0, 11)); // 
         cmbHospitalHD.setForeground(new java.awt.Color(207, 0, 0));
         cmbHospitalHD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 0, 0)));
         cmbHospitalHD.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
               //  cmbHospitalHDActionPerformed(evt);
             }
         });

         btnFindClosestH.setBackground(new java.awt.Color(255, 255, 255));
         btnFindClosestH.setFont(new java.awt.Font("Calibri", 0, 11)); // 
         btnFindClosestH.setForeground(new java.awt.Color(215, 0, 0));
         btnFindClosestH.setText("Find Closest Route");
         btnFindClosestH.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 btnFindClosestHActionPerformed(evt);
             }
         });

         txtAreaH.setColumns(20);
         txtAreaH.setFont(new java.awt.Font("Calibri", 1, 12)); // 
         txtAreaH.setForeground(new java.awt.Color(215, 0, 0));
         txtAreaH.setRows(5);
         txtAreaH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(213, 0, 0)));
         jScrollPane2.setViewportView(txtAreaH);

         jLabel26.setBackground(new java.awt.Color(255, 255, 255));
         jLabel26.setFont(new java.awt.Font("Calibri", 0, 11)); // 
         jLabel26.setForeground(new java.awt.Color(206, 0, 0));
         jLabel26.setText("Destination Province");

         cmbHospitalHL.setFont(new java.awt.Font("Calibri", 0, 11)); // 
         cmbHospitalHL.setForeground(new java.awt.Color(227, 0, 0));
         cmbHospitalHL.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
         cmbHospitalHL.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(221, 0, 0)));
         cmbHospitalHL.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 //cmbHospitalHLActionPerformed(evt);
             }
         });

         jLabel27.setBackground(new java.awt.Color(255, 255, 255));
         jLabel27.setFont(new java.awt.Font("Calibri", 0, 11)); // 
         jLabel27.setForeground(new java.awt.Color(206, 0, 0));
         jLabel27.setText("Current Location");

         cmbProvinceHD.setFont(new java.awt.Font("Calibri", 0, 11)); // 
         cmbProvinceHD.setForeground(new java.awt.Color(207, 0, 0));
         cmbProvinceHD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Eastern Cape", "Free State", "Gauteng", "KwaZulu-Natal", "Limpopo", "Mpumalanga", "Northern Cape", "North West Province", "Western Cape" }));
         cmbProvinceHD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(220, 0, 0)));
         cmbProvinceHD.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 cmbProvinceHDActionPerformed(evt);
             }
         });

         javax.swing.GroupLayout pnlHospitalLayout = new javax.swing.GroupLayout(pnlHospital);
         pnlHospital.setLayout(pnlHospitalLayout);
         pnlHospitalLayout.setHorizontalGroup(
             pnlHospitalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(pnlHospitalLayout.createSequentialGroup()
                 .addContainerGap()
                 .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addContainerGap(12, Short.MAX_VALUE))
             .addGroup(pnlHospitalLayout.createSequentialGroup()
                 .addGroup(pnlHospitalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(pnlHospitalLayout.createSequentialGroup()
                         .addGroup(pnlHospitalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHospitalLayout.createSequentialGroup()
                                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                 .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                             .addGroup(pnlHospitalLayout.createSequentialGroup()
                                 .addGap(61, 61, 61)
                                 .addComponent(lblLogo4)
                                 .addGap(0, 0, Short.MAX_VALUE)))
                         .addGap(18, 18, 18))
                     .addGroup(pnlHospitalLayout.createSequentialGroup()
                         .addGap(0, 0, Short.MAX_VALUE)
                         .addGroup(pnlHospitalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addGroup(pnlHospitalLayout.createSequentialGroup()
                                 .addGap(21, 21, 21)
                                 .addComponent(btnFindClosestH))
                             .addComponent(cmbProvinceHD, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addComponent(cmbHospitalHD, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addGroup(pnlHospitalLayout.createSequentialGroup()
                                 .addGap(31, 31, 31)
                                 .addComponent(jLabel9))
                             .addGroup(pnlHospitalLayout.createSequentialGroup()
                                 .addGap(41, 41, 41)
                                 .addComponent(jLabel8))
                             .addComponent(cmbProvinceHL, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addComponent(cmbHospitalHL, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHospitalLayout.createSequentialGroup()
                                 .addGap(32, 32, 32)
                                 .addGroup(pnlHospitalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHospitalLayout.createSequentialGroup()
                                         .addComponent(jLabel26)
                                         .addGap(29, 29, 29))
                                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHospitalLayout.createSequentialGroup()
                                         .addComponent(jLabel27)
                                         .addGap(39, 39, 39)))))))
                 .addComponent(lblBackground4, javax.swing.GroupLayout.PREFERRED_SIZE, 661, javax.swing.GroupLayout.PREFERRED_SIZE))
         );
         pnlHospitalLayout.setVerticalGroup(
             pnlHospitalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(pnlHospitalLayout.createSequentialGroup()
                 .addGroup(pnlHospitalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(pnlHospitalLayout.createSequentialGroup()
                         .addContainerGap()
                         .addComponent(lblLogo4)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addGap(18, 18, 18)
                         .addComponent(jLabel8)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addComponent(cmbProvinceHL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addGap(18, 18, 18)
                         .addComponent(jLabel27)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addComponent(cmbHospitalHL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                         .addComponent(jLabel26)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addComponent(cmbProvinceHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addGap(18, 18, 18)
                         .addComponent(jLabel9)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addComponent(cmbHospitalHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addGap(23, 23, 23)
                         .addComponent(btnFindClosestH)
                         .addGap(37, 37, 37))
                     .addGroup(pnlHospitalLayout.createSequentialGroup()
                         .addComponent(lblBackground4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                 .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addContainerGap())
         );

         mainTabbedPane.addTab("Hospitals", pnlHospital);

         pnlDiseases.setBackground(new java.awt.Color(255, 255, 255));
         pnlDiseases.setFont(new java.awt.Font("Calibri", 0, 11)); // 

         lblLogo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/Logo.png"))); // 

         jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/background (2).png"))); // 

         jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/diseases.png"))); // 

         cmbDiseasesN.setFont(new java.awt.Font("Calibri", 0, 11)); // 
         cmbDiseasesN.setForeground(new java.awt.Color(227, 0, 0));
         cmbDiseasesN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Allergic diseases", "Asthma", "Adrenocortical carcinoma", "Amyotrophic Lateral Sclerosis", "Arthritis", "Cerebral Amyloid Angiopathy", "Common cold", "Creutzfeldt Jakob disease", "Coeliac disease", "Desmoplastic", "Diabetes", "Dupuytren's disease", "Ebola virus", "Epilepsy", "Fatal Familial Insomnia", "Fibrodysplasia Ossificans Progressiva", "Fluoroquinolone Toxicity Syndrome (FQAD)", "Genetic disease", "Glioblastoma", "Herpes", "HIV/AIDS", "Hereditary Multiple Exostoses", "Inflammatory bowel disease", "Irritable bowel syndrome", "Joint pain", "Lichen planus", "Norovirus", "Macular degeneration", "Marburg virus", "Multiple sclerosis", "Muscular dystrophy", "Myasthenia gravis", "Progeria", "Polio", "Psoriasis", "Osteoporosis", "Rheumatoid Arthritis", "Rett syndrome (RTT)", "Schizophrenia", "Spinocerebellar Ataxia", "Severe Acute Respiratory Syndrome", "Sickle Cell Anemia", "Trigeminal Neuralgia", "Toxoplasmosis" }));
         cmbDiseasesN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(221, 0, 0)));
         cmbDiseasesN.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                // cmbDiseasesNActionPerformed(evt);
             }
         });

         btnFindClosestH1.setBackground(new java.awt.Color(255, 255, 255));
         btnFindClosestH1.setFont(new java.awt.Font("Calibri", 0, 11)); // 
         btnFindClosestH1.setForeground(new java.awt.Color(215, 0, 0));
         btnFindClosestH1.setText("Show Information");
         btnFindClosestH1.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 btnFindClosestH1ActionPerformed(evt);
             }
         });

         jLabel12.setBackground(new java.awt.Color(255, 255, 255));
         jLabel12.setFont(new java.awt.Font("Calibri", 0, 11)); // 
         jLabel12.setForeground(new java.awt.Color(206, 0, 0));
         jLabel12.setText("Disease");

         txtAreaH1.setColumns(20);
         txtAreaH1.setFont(new java.awt.Font("Calibri", 1, 12)); // 
         txtAreaH1.setForeground(new java.awt.Color(215, 0, 0));
         txtAreaH1.setRows(5);
         txtAreaH1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(213, 0, 0)));
         jScrollPane3.setViewportView(txtAreaH1);

         javax.swing.GroupLayout pnlDiseasesLayout = new javax.swing.GroupLayout(pnlDiseases);
         pnlDiseases.setLayout(pnlDiseasesLayout);
         pnlDiseasesLayout.setHorizontalGroup(
             pnlDiseasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(pnlDiseasesLayout.createSequentialGroup()
                 .addGroup(pnlDiseasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(pnlDiseasesLayout.createSequentialGroup()
                         .addGroup(pnlDiseasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addGroup(pnlDiseasesLayout.createSequentialGroup()
                                 .addGap(62, 62, 62)
                                 .addComponent(lblLogo5))
                             .addGroup(pnlDiseasesLayout.createSequentialGroup()
                                 .addGap(70, 70, 70)
                                 .addComponent(jLabel12))
                             .addGroup(pnlDiseasesLayout.createSequentialGroup()
                                 .addGap(30, 30, 30)
                                 .addComponent(btnFindClosestH1)))
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 42, Short.MAX_VALUE))
                     .addGroup(pnlDiseasesLayout.createSequentialGroup()
                         .addContainerGap()
                         .addGroup(pnlDiseasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                             .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addComponent(cmbDiseasesN, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGap(0, 0, Short.MAX_VALUE)))
                 .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))
             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDiseasesLayout.createSequentialGroup()
                 .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                 .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addContainerGap())
         );
         pnlDiseasesLayout.setVerticalGroup(
             pnlDiseasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(pnlDiseasesLayout.createSequentialGroup()
                 .addGroup(pnlDiseasesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                     .addGroup(pnlDiseasesLayout.createSequentialGroup()
                         .addComponent(lblLogo5)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addGap(38, 38, 38)
                         .addComponent(jLabel12)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                         .addComponent(cmbDiseasesN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addGap(57, 57, 57)
                         .addComponent(btnFindClosestH1)
                         .addGap(64, 64, 64))
                     .addComponent(jLabel1))
                 .addGap(18, 18, 18)
                 .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                 .addGap(6, 6, 6))
         );

         mainTabbedPane.addTab("Diseases", pnlDiseases);

         pnlSettings.setBackground(new java.awt.Color(255, 255, 255));

         lblLogo6.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/Logo.png"))); // 

         jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/background (2).png"))); // 

         btnDeleteH.setBackground(new java.awt.Color(255, 255, 255));
         btnDeleteH.setFont(new java.awt.Font("Calibri", 0, 11)); // 
         btnDeleteH.setForeground(new java.awt.Color(212, 0, 0));
         btnDeleteH.setText("Hospital");
         btnDeleteH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(211, 0, 0)));
         btnDeleteH.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 btnDeleteHActionPerformed(evt);
             }
         });

         jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/settings.png"))); // 

         jLabel3.setFont(new java.awt.Font("Calibri", 1, 16)); // 
         jLabel3.setForeground(new java.awt.Color(208, 4, 4));
         jLabel3.setText("Add Hospital");

         jLabel15.setFont(new java.awt.Font("Calibri", 1, 16)); // 
         jLabel15.setForeground(new java.awt.Color(208, 4, 4));
         jLabel15.setText("Add Disease");

         jLabel16.setFont(new java.awt.Font("Calibri", 1, 16)); // 
         jLabel16.setForeground(new java.awt.Color(208, 4, 4));
         jLabel16.setText("Delete");

         btnDeleteD.setBackground(new java.awt.Color(255, 255, 255));
         btnDeleteD.setFont(new java.awt.Font("Calibri", 0, 11)); // 
         btnDeleteD.setForeground(new java.awt.Color(212, 0, 0));
         btnDeleteD.setText("Disease");
         btnDeleteD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(211, 0, 0)));
         btnDeleteD.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 btnDeleteDActionPerformed(evt);
             }
         });

         btnAddD.setBackground(new java.awt.Color(255, 255, 255));
         btnAddD.setFont(new java.awt.Font("Calibri", 0, 11)); // 
         btnAddD.setForeground(new java.awt.Color(212, 0, 0));
         btnAddD.setText("Add");
         btnAddD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(211, 0, 0)));
         btnAddD.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 btnAddDActionPerformed(evt);
             }
         });

         btnAddH.setBackground(new java.awt.Color(255, 255, 255));
         btnAddH.setFont(new java.awt.Font("Calibri", 0, 11)); // 
         btnAddH.setForeground(new java.awt.Color(212, 0, 0));
         btnAddH.setText("Add");
         btnAddH.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(211, 0, 0)));
         btnAddH.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 btnAddHActionPerformed(evt);
             }
         });

         jLabel17.setFont(new java.awt.Font("Calibri", 1, 11)); // 
         jLabel17.setForeground(new java.awt.Color(208, 4, 4));
         jLabel17.setText("Name:");

         jLabel18.setFont(new java.awt.Font("Calibri", 1, 11)); // 
         jLabel18.setForeground(new java.awt.Color(208, 4, 4));
         jLabel18.setText("Description:");

         jLabel19.setFont(new java.awt.Font("Calibri", 1, 11)); // 
         jLabel19.setForeground(new java.awt.Color(208, 4, 4));
         jLabel19.setText("Name:");

         jLabel20.setFont(new java.awt.Font("Calibri", 1, 11)); // 
         jLabel20.setForeground(new java.awt.Color(208, 4, 4));
         jLabel20.setText("To:");

         jLabel21.setFont(new java.awt.Font("Calibri", 1, 11)); // 
         jLabel21.setForeground(new java.awt.Color(208, 4, 4));
         jLabel21.setText("From:");

         jLabel22.setFont(new java.awt.Font("Calibri", 1, 11)); // 
         jLabel22.setForeground(new java.awt.Color(208, 4, 4));
         jLabel22.setText("Distance:");

         jLabel23.setFont(new java.awt.Font("Calibri", 1, 14)); // 
         jLabel23.setForeground(new java.awt.Color(208, 4, 4));
         jLabel23.setText("___________");

         txtHName.setFont(new java.awt.Font("Calibri", 0, 11)); // 
         txtHName.setForeground(new java.awt.Color(208, 0, 0));
         txtHName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(216, 0, 0)));
         txtHName.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 //txtHNameActionPerformed(evt);
             }
         });

         txtHTo.setFont(new java.awt.Font("Calibri", 0, 11)); // 
         txtHTo.setForeground(new java.awt.Color(208, 0, 0));
         txtHTo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(216, 0, 0)));

         txtHFrom.setFont(new java.awt.Font("Calibri", 0, 11)); // 
         txtHFrom.setForeground(new java.awt.Color(208, 0, 0));
         txtHFrom.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(216, 0, 0)));

         txtHDistance.setFont(new java.awt.Font("Calibri", 0, 11)); // 
         txtHDistance.setForeground(new java.awt.Color(208, 0, 0));
         txtHDistance.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(216, 0, 0)));
         txtHDistance.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                // txtHDistanceActionPerformed(evt);
             }
         });

         txtDName.setFont(new java.awt.Font("Calibri", 0, 11)); // 
         txtDName.setForeground(new java.awt.Color(208, 0, 0));
         txtDName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(216, 0, 0)));
         txtDName.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                // txtDNameActionPerformed(evt);
             }
         });

         txtDDescription.setFont(new java.awt.Font("Calibri", 0, 11)); // 
         txtDDescription.setForeground(new java.awt.Color(208, 0, 0));
         txtDDescription.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(216, 0, 0)));
         txtDDescription.addActionListener(new java.awt.event.ActionListener() {
             public void actionPerformed(java.awt.event.ActionEvent evt) {
                 //txtDDescriptionActionPerformed(evt);
             }
         });

         jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("images/settingslogo (2).png"))); // 

         javax.swing.GroupLayout pnlSettingsLayout = new javax.swing.GroupLayout(pnlSettings);
         pnlSettings.setLayout(pnlSettingsLayout);
         pnlSettingsLayout.setHorizontalGroup(
             pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSettingsLayout.createSequentialGroup()
                 .addGroup(pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(pnlSettingsLayout.createSequentialGroup()
                         .addGap(62, 62, 62)
                         .addComponent(lblLogo6)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSettingsLayout.createSequentialGroup()
                         .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addGap(18, 18, 18))
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSettingsLayout.createSequentialGroup()
                         .addGap(0, 0, Short.MAX_VALUE)
                         .addGroup(pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addGroup(pnlSettingsLayout.createSequentialGroup()
                                 .addComponent(jLabel22)
                                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                 .addComponent(txtHDistance, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                             .addGroup(pnlSettingsLayout.createSequentialGroup()
                                 .addComponent(jLabel19)
                                 .addGap(18, 18, 18)
                                 .addGroup(pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                     .addComponent(txtHFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                     .addComponent(txtHName, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                             .addComponent(jLabel21)
                             .addGroup(pnlSettingsLayout.createSequentialGroup()
                                 .addComponent(jLabel20)
                                 .addGap(34, 34, 34)
                                 .addComponent(txtHTo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                             .addComponent(jLabel24)
                             .addGroup(pnlSettingsLayout.createSequentialGroup()
                                 .addGap(33, 33, 33)
                                 .addComponent(jLabel3)))
                         .addGap(24, 24, 24)))
                 .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))
             .addGroup(pnlSettingsLayout.createSequentialGroup()
                 .addGroup(pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(pnlSettingsLayout.createSequentialGroup()
                         .addGap(64, 64, 64)
                         .addComponent(btnAddH, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addGap(272, 272, 272)
                         .addComponent(btnAddD, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addGroup(pnlSettingsLayout.createSequentialGroup()
                         .addGroup(pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addGroup(pnlSettingsLayout.createSequentialGroup()
                                 .addGap(367, 367, 367)
                                 .addComponent(jLabel17)
                                 .addGap(34, 34, 34))
                             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSettingsLayout.createSequentialGroup()
                                 .addContainerGap()
                                 .addComponent(jLabel18)
                                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                         .addGroup(pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addComponent(txtDDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addComponent(txtDName, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                     .addGroup(pnlSettingsLayout.createSequentialGroup()
                         .addGap(388, 388, 388)
                         .addComponent(jLabel15)))
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                 .addGroup(pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(pnlSettingsLayout.createSequentialGroup()
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(jLabel23)
                         .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSettingsLayout.createSequentialGroup()
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                         .addComponent(btnDeleteH, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addGap(45, 45, 45)
                         .addComponent(btnDeleteD, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                         .addContainerGap())
                     .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSettingsLayout.createSequentialGroup()
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addComponent(jLabel16)
                         .addGap(92, 92, 92))))
         );
         pnlSettingsLayout.setVerticalGroup(
             pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(pnlSettingsLayout.createSequentialGroup()
                 .addGroup(pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(pnlSettingsLayout.createSequentialGroup()
                         .addComponent(jLabel2)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                     .addGroup(pnlSettingsLayout.createSequentialGroup()
                         .addGap(20, 20, 20)
                         .addComponent(lblLogo6)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                         .addComponent(jLabel14)
                         .addGap(32, 32, 32)
                         .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)))
                 .addGroup(pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                     .addGroup(pnlSettingsLayout.createSequentialGroup()
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                         .addGroup(pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                             .addComponent(jLabel19)
                             .addComponent(txtHName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                         .addGap(35, 35, 35))
                     .addGroup(pnlSettingsLayout.createSequentialGroup()
                         .addGap(6, 6, 6)
                         .addGroup(pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                             .addComponent(jLabel15)
                             .addComponent(jLabel3)
                             .addComponent(jLabel16))
                         .addGap(29, 29, 29)
                         .addGroup(pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                             .addComponent(txtDName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                             .addComponent(jLabel17))
                         .addGroup(pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                             .addGroup(pnlSettingsLayout.createSequentialGroup()
                                 .addGap(18, 18, 18)
                                 .addGroup(pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                     .addComponent(jLabel20)
                                     .addComponent(txtHTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSettingsLayout.createSequentialGroup()
                                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                 .addGroup(pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                     .addComponent(txtDDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                     .addComponent(jLabel18))
                                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))))
                 .addGroup(pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jLabel21)
                     .addComponent(txtHFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(btnDeleteH, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(btnDeleteD, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                 .addGroup(pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(jLabel22)
                     .addComponent(txtHDistance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addGap(39, 39, 39)
                 .addGroup(pnlSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                     .addComponent(btnAddH, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                     .addComponent(btnAddD, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                 .addGap(27, 27, 27))
         );

         mainTabbedPane.addTab("Settings", pnlSettings);

         javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
         getContentPane().setLayout(layout);
         layout.setHorizontalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                 .addComponent(mainTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 846, javax.swing.GroupLayout.PREFERRED_SIZE)
                 .addGap(0, 0, Short.MAX_VALUE))
         );
         layout.setVerticalGroup(
             layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addComponent(mainTabbedPane)
         );
         
         txtAreaH.setLineWrap(true);
         txtAreaH.setEditable(false);
         txtAreaH1.setLineWrap(true);
         txtAreaH.setEditable(false);
         txtAreaP.setLineWrap(true);
         txtAreaP.setEditable(false);
         
        cmbHospitalHL.setSelectedIndex(-1);
      	cmbHospitalHD.setSelectedIndex(-1);
      	cmbProvinceHL.setSelectedIndex(-1);
      	cmbProvinceHD.setSelectedIndex(-1);
      	cmbHospitalPL.setSelectedIndex(-1);
      	cmbHospital.setSelectedIndex(-1);
      	cmbProvincePL.setSelectedIndex(-1);
      	cmbProvincePD.setSelectedIndex(-1);
      	
      	mainTabbedPane.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
            	
            	if(!(LoggedIn == true))   //make sure user is logged in before using rest of program
                {
            		mainTabbedPane.setSelectedIndex(0);;                                                    //error message
             	   JOptionPane.showMessageDialog(Frame.this, "Please log in or register first!");
                }
            	
            }
        });
      	
      	this.setResizable(false);
      	
         pack();        
    }

   /**
    * Populate Hospitals same for all comboboexs (Filtering)
    * @param evt
    */
    private void cmbProvinceHLActionPerformed(java.awt.event.ActionEvent evt) {                                              


    	String province = Integer.toString(cmbProvinceHL.getSelectedIndex());
    	ArrayList<String> hospitalsAL = new ArrayList<String>();
 
    	for (int z = 0; z < hospitals.size(); z++) {
			if(hospitals.get(z).charAt(0)==province.charAt(0))
			{
				StringBuilder remover = new StringBuilder(hospitals.get(z));
				remover.deleteCharAt(0);
				hospitalsAL.add(remover.toString());				
			}
		}
    	
    	String[] arrHospitals = hospitalsAL.toArray(new String[hospitalsAL.size()]);
    	
    	DefaultComboBoxModel filteredHospitals = new DefaultComboBoxModel(arrHospitals);
    	cmbHospitalHL.setModel(filteredHospitals);
    	cmbHospitalHL.setSelectedIndex(-1);
    	
    }                                             

    private void cmbProvinceHDActionPerformed(java.awt.event.ActionEvent evt) { 
    	
    	String province = Integer.toString(cmbProvinceHD.getSelectedIndex());
    	ArrayList<String> hospitalsAL = new ArrayList<String>();
 
    	for (int z = 0; z < hospitals.size(); z++) {
			if(hospitals.get(z).charAt(0)==province.charAt(0))
			{
				StringBuilder remover = new StringBuilder(hospitals.get(z));
				remover.deleteCharAt(0);
				hospitalsAL.add(remover.toString());				
			}
		}
    	
    	String[] arrHospitals = hospitalsAL.toArray(new String[hospitalsAL.size()]);
    	
    	DefaultComboBoxModel filteredHospitals = new DefaultComboBoxModel(arrHospitals);
    	cmbHospitalHD.setModel(filteredHospitals);
    	cmbHospitalHD.setSelectedIndex(-1);
    }   
   
    private void cmbProvincePDActionPerformed(java.awt.event.ActionEvent evt) {                                              
    	
    	String province = Integer.toString(cmbProvincePD.getSelectedIndex());
    	ArrayList<String> hospitalsAL = new ArrayList<String>();
 
    	for (int z = 0; z < hospitals.size(); z++) {
			if(hospitals.get(z).charAt(0)==province.charAt(0))
			{
				StringBuilder remover = new StringBuilder(hospitals.get(z));
				remover.deleteCharAt(0);
				hospitalsAL.add(remover.toString());				
			}
		}
    	
    	String[] arrHospitals = hospitalsAL.toArray(new String[hospitalsAL.size()]);
    	
    	DefaultComboBoxModel filteredHospitals = new DefaultComboBoxModel(arrHospitals);
    	cmbHospital.setModel(filteredHospitals);
    	cmbHospital.setSelectedIndex(-1);
    	
    }                                             

    private void cmbProvincePLActionPerformed(java.awt.event.ActionEvent evt) {                                              
        
    	String province = Integer.toString(cmbProvincePL.getSelectedIndex());
    	ArrayList<String> hospitalsAL = new ArrayList<String>();
 
    	for (int z = 0; z < hospitals.size(); z++) {
			if(hospitals.get(z).charAt(0)==province.charAt(0))
			{
				StringBuilder remover = new StringBuilder(hospitals.get(z));
				remover.deleteCharAt(0);
				hospitalsAL.add(remover.toString());				
			}
		}
    	
    	String[] arrHospitals = hospitalsAL.toArray(new String[hospitalsAL.size()]);
    	
    	DefaultComboBoxModel filteredHospitals = new DefaultComboBoxModel(arrHospitals);
    	cmbHospitalPL.setModel(filteredHospitals);
    	cmbHospitalPL.setSelectedIndex(-1);
    }    
  
                                      
    
    
    /**
     * Find closest hospitals 
     * @param evt
     */
    private void btnFindClosestHActionPerformed(java.awt.event.ActionEvent evt) 
    {                                                
        txtAreaH.setText(" ");
    	
    	this.startHospitalH = (String) cmbHospitalHL.getSelectedItem();    	
    	this.destinationHospitalH = (String) cmbHospitalHD.getSelectedItem();
    	
    	
    	if(!(this.startHospitalH.equals(this.destinationHospitalH)))
    	{
    		int vertexPositionHStart = 0;
        	int vertexPositionHDestination = 0;
        	
        	
        	for (int i = 0; i < hospitals.size(); i++) {
        		
        		StringBuilder remover = new StringBuilder(hospitals.get(i));
    			remover.deleteCharAt(0);
    			String origional = remover.toString();
    		
    			if (origional.equals(this.startHospitalH)) {
    				
    				vertexPositionHStart = i;
    				
    			}
    			if (origional.equals(this.destinationHospitalH)) {
    				
    				vertexPositionHDestination = i;
    				
    			}
        		
    		}
        	
        	try {
    			Graph<String,String> graph = Graph.inParser();
    			Graph.sizeDijkstra = 0;
    			
    			Vertex<String,String> z[] = graph.getVertexArray();
    			
    			int counter = 0;
    			int distance = 0;
    			for(Edge<String,String> v : graph.dijkstra(z[vertexPositionHStart], z[vertexPositionHDestination]))
    			{
    				distance += v.getEdgeWeight();
    				StringBuilder from = new StringBuilder(v.getvFrom().toString());
    				from.deleteCharAt(0);
    				from.deleteCharAt(from.length()-1);
    				StringBuilder to = new StringBuilder(v.getvTo().toString());
    				to.deleteCharAt(0);
    				to.deleteCharAt(to.length()-1);
    				if(counter==0)
    				{
    					txtAreaH.append("You are currently at "+from+" travel "+(int)(v.getEdgeWeight())+"km's to "+to+",");
    					txtAreaH.append("\r\n");
    				}else if(counter==Graph.sizeDijkstra-1)
    				{
    					if(counter == 1)
    					{
    						txtAreaH.append("now go "+(int)v.getEdgeWeight()+"km's from "+from+" to your final destiantion at "+to+",");
        					txtAreaH.append("\r\n");
    					}
    					txtAreaH.append("finally go "+(int)v.getEdgeWeight()+"km's from "+from+" to your final destiantion at "+to+",");
    					txtAreaH.append("\r\n");
    				}else
    				{
    					txtAreaH.append("now make your way "+(int)v.getEdgeWeight()+"km's to "+to+".");
    					txtAreaH.append("\r\n");
    				}
    								
    				
    				counter++;
    			}
    			txtAreaH.append("\r\n");
    			txtAreaH.append("\r\n");
    			txtAreaH.append("Total Distance from "+startHospitalH+" to "+destinationHospitalH+" is "+distance+"km.");	
    			
    			Integer hoursCar = (int) distance / 60;
    			Integer minutesCar = (int) distance / 60 / 60;
    			Integer hoursPlane = (int) (distance/ 500);
    			Integer minutesPlane = (int) ( distance / 60/ 8);
    			
    			txtAreaH.append("\r\n");
    			txtAreaH.append("\r\n");
    			txtAreaH.append("Estimated Driving Time: "+hoursCar+" hours "+minutesCar+" minutes.");
    			if(distance > 1000)
    			{	txtAreaH.append("\r\n");
    				txtAreaH.append("Estimated Flight Time: "+hoursPlane+" hours "+minutesPlane+" minutes.");
    			}
    			if(hoursCar < 4.1)
    			{
    				txtAreaH.append("\r\n");
    				txtAreaH.append("The organ will survive car transporation.");
    				
    			}else {
    				txtAreaH.append("\r\n");
    				txtAreaH.append("The organ will not survive car transporation.");
    			    }
    			if((hoursPlane < 4.1)&&(distance > 1000))
    			{
    				txtAreaH.append("\r\n");
    				txtAreaH.append("The organ will air transporation.");
    				
    			}else {
    				if(distance > 1000)
    				{
    					txtAreaH.append("\r\n");
        				txtAreaH.append("The organ will not air transporation.");
    				}
    				
    		     }

    				
    			
    		} catch (FileNotFoundException e) {
    			e.printStackTrace();
    		}
        	
    	}else
    		txtAreaH.setText("You are already at "+this.destinationHospitalH+" please choose another hospital to go to.");	
    	
    	txtAreaH.setCaretPosition(0);
    }                                               

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {                                         

    	String userName = txtUsername.getText();
    	String password = txtPassword.getText();
    	if(validateText(userName,password))
		{
			txtUsername.setText("");
			txtPassword.setText("");
			String response = client.login(userName, password); //Send to server
			LoggedIn = true;
			JOptionPane.showMessageDialog(Frame.this, response);
			
		}else
			JOptionPane.showMessageDialog(Frame.this, "Please enter username and password");	 //Error message
        	
    }                                        
    
    /**
     * Register user
     * @param evt
     */
    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {                                            

    	String userName = txtUsername.getText().trim();
		String password = txtPassword.getText().trim();
		validateText(userName,password);
		if(validateText(userName,password))
		{
			String response = client.register(userName, password);
			JOptionPane.showMessageDialog(Frame.this, response);
		}else
			JOptionPane.showMessageDialog(Frame.this, "Please enter username and password");
    	
    }                                           

    /**
     * Logout user
     * @param evt
     */
    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {                                          

    	String response = client.logout();
		JOptionPane.showMessageDialog(Frame.this, response);
		LoggedIn = false;    	
    }                                         
                              
    /**
     * Find Closest path
     * @param evt
     */
    private void btnFindClosestPActionPerformed(java.awt.event.ActionEvent evt) {                                                
        
    	txtAreaP.setText(" ");
    	
    	this.startHospitalP = (String) cmbHospitalPL.getSelectedItem();    	
    	this.destinationHospitalP = (String) cmbHospital.getSelectedItem();
    	
    	if(!(this.startHospitalP.equals(this.destinationHospitalP)))
    	{
    		int vertexPositionPStart = 0;
        	int vertexPositionPDestination = 0;
        	
        	
        	for (int i = 0; i < hospitals.size(); i++) {
        		
        		StringBuilder remover = new StringBuilder(hospitals.get(i));
    			remover.deleteCharAt(0);
    			String origional = remover.toString();
    		
    			if (origional.equals(this.startHospitalP)) {
    				
    				vertexPositionPStart = i;
    				
    			}
    			if (origional.equals(this.destinationHospitalP)) {
    				
    				vertexPositionPDestination = i;
    				
    			}
        		
    		}
        	
        	try {
    			Graph<String,String> graph = Graph.inParser();
    			Graph.sizeDijkstra = 0;
    			
    			Vertex<String,String> z[] = graph.getVertexArray();
    			
    			int counter = 0;
    			int distance = 0;
    			for(Edge<String,String> v : graph.dijkstra(z[vertexPositionPStart], z[vertexPositionPDestination]))
    			{
    				distance += v.getEdgeWeight();
    				StringBuilder from = new StringBuilder(v.getvFrom().toString());
    				from.deleteCharAt(0);
    				from.deleteCharAt(from.length()-1);
    				StringBuilder to = new StringBuilder(v.getvTo().toString());
    				to.deleteCharAt(0);
    				to.deleteCharAt(to.length()-1);
    				if(counter==0)
    				{
    					txtAreaP.append("You are currently at "+from+" travel "+(int)(v.getEdgeWeight())+"km's to "+to+",");
    					txtAreaP.append("\r\n");
    				}else if(counter==Graph.sizeDijkstra-1)
    				{
    					txtAreaP.append("finally go "+(int)v.getEdgeWeight()+"km's from "+from+" to your final destiantion at "+to+",");
    					txtAreaP.append("\r\n");
    				}else
    				{
    					txtAreaP.append("now make your way "+(int)v.getEdgeWeight()+"km's to "+to+".");
    					txtAreaP.append("\r\n");
    				}
    								
    				
    				counter++;
    			}
    			
    			txtAreaP.append("\r\n");
    			txtAreaP.append("\r\n");
    			txtAreaP.append("Total Distance from "+startHospitalP+" to "+destinationHospitalP+" is "+distance+"km.");	
    			
    			Integer hoursCar = (int) distance / 60;
    			Integer minutesCar = (int) distance / 60 / 60;
    			Integer hoursPlane = (int) (distance/ 500);
    			Integer minutesPlane = (int) ( distance / 60/ 8);
    			
    			txtAreaP.append("\r\n");
    			txtAreaP.append("Estimated Driving Time: "+hoursCar+" hours "+minutesCar+" minutes.");
    			if(distance > 1000)
    			{
    				txtAreaP.append("\r\n");
    				txtAreaP.append("Estimated Flight Time: "+hoursPlane+" hours "+minutesPlane+" minutes.");
    			}
    			
    			
    		} catch (FileNotFoundException e) {
    			e.printStackTrace();
    		}
        	
    	}else
    		txtAreaP.setText("You are already at "+this.destinationHospitalP+" please choose another hospital to go to.");	
    	
    	txtAreaP.setCaretPosition(0);
    	
    }                                               

    /**
     * Disease displayment
     * @param evt
     */
    private void btnFindClosestH1ActionPerformed(java.awt.event.ActionEvent evt) {                                                 

    	txtAreaH1.setText(diseaseName.get(cmbDiseasesN.getSelectedIndex())+" - "+diseaseInfo.get(cmbDiseasesN.getSelectedIndex()));
    	
    }  
    
    private void btnAddHActionPerformed(java.awt.event.ActionEvent evt) {                                        
        
    	String s = txtHName.getText();
    	JOptionPane.showMessageDialog(Frame.this, s+" was added sucessfully.");
			
    }                                       

    /**
     * Add new disease
     * @param evt
     */
    private void btnAddDActionPerformed(java.awt.event.ActionEvent evt) {                                        

    	String diseaseNames = txtDName.getText();
		String diseaseInfos = txtDDescription.getText();
		if(validateText(diseaseNames,diseaseInfos))
		{
			addToFile(diseaseNames,diseaseInfos);
			String[] arrDNames = diseaseName.toArray(new String[diseaseName.size()]);
	    	DefaultComboBoxModel diseases = new DefaultComboBoxModel(arrDNames);
	    	cmbDiseasesN.setModel(diseases);
	    	JOptionPane.showMessageDialog(Frame.this,diseaseNames+" was sucessfully added.");			
		}else
			JOptionPane.showMessageDialog(Frame.this, "Please enter a valid name and description.");
		
		txtDDescription.setText("");
		txtDName.setText("");
    	
    }                                       

    /**
     * Delete hospital
     * @param evt
     */
    private void btnDeleteHActionPerformed(java.awt.event.ActionEvent evt) {                                           

    	boolean bTrue = false;
    		String selected = JOptionPane.showInputDialog("Enter the name of the disease you wish to delete");
        	
    		for (int i = 0; i < hospitals.size(); i++) {
				if (selected.equals(hospitals.get(i))) {
					bTrue = true;
				} 
			}
    		if(bTrue)
    			JOptionPane.showMessageDialog(Frame.this, "Deleted "+selected);
    		else
    			JOptionPane.showMessageDialog(Frame.this,selected+" is not a valid hospital");
    }                                          

    /**
     * Delete disease
     * @param evt
     */
    private void btnDeleteDActionPerformed(java.awt.event.ActionEvent evt) {                                           
       
    	String selected = JOptionPane.showInputDialog("Enter the name of the disease you wish to delete");
    	Integer index = 0;
    	Boolean bFound = false;
    	for (int i = 0; i < diseaseName.size(); i++) 
    	{
			if(diseaseName.get(i).equals(selected))
			{
				bFound = true;
				index = i;
			}
		}

    	if(bFound)
    	{
    		deleteFromFile(selected);
    		String[] arrDNames = diseaseName.toArray(new String[diseaseName.size()]);
	    	DefaultComboBoxModel diseases = new DefaultComboBoxModel(arrDNames);
	    	cmbDiseasesN.setModel(diseases);
	    	JOptionPane.showMessageDialog(Frame.this, selected+" sucessfully deleted");
	    	txtAreaH1.setText("");
    	}else
    		JOptionPane.showMessageDialog(Frame.this, "Please enter a valid disease to delete.");
    
    }                                          

    /** Validate the username and password to make sure they arent empty
	 * @param username
	 * @param password
	 * @return
	 */
	private boolean validateText(String user,String pass)
	{
		if((user.equals(""))||(pass.equals("")))
		{
			return false;
		}
		return true;    	
	}

	public static void addToFile(String name, String info)
	{
		diseaseName.add(name);
		diseaseInfo.add(info);
		try {
			FileWriter writer = new FileWriter("data/diseasename.txt", true);
			FileWriter writer2 = new FileWriter("data/diseaseinfo.txt", true);
			writer.write("\r\n");
			writer.write(name);
			writer2.write("\r\n");
			writer2.write(info);
			writer.close();
			writer2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void read(ArrayList<String> AL, String file)
	{
		File userFile = new File(file);
		try
		{
		    Scanner scan = new Scanner(userFile);
		    while(scan.hasNextLine())
		    {
		    	String line = scan.nextLine();
		    	AL.add(line);			
		    }
		    scan.close();
		}
		catch(IOException ex)
		{
		    ex.printStackTrace();
		}

	}
	
	public static void deleteFromFile(String index)
	{
		diseaseName.remove(index);
		diseaseInfo.remove(index);
		
		try {
			FileWriter writer = new FileWriter("data/diseasename.txt", false);
			FileWriter writer2 = new FileWriter("data/diseaseinfo.txt", false);
			for (int z = 0; z < diseaseName.size(); z++)
			{
				if(!(z==0))
				{
					writer.write("\r\n");
					writer.write(diseaseName.get(z));
					writer2.write("\r\n");
					writer2.write(diseaseInfo.get(z));
				}else
				{
					writer.write(diseaseName.get(z));
					writer2.write(diseaseInfo.get(z));
				}
				
				
			}
			
			writer.close();
			writer2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
	private javax.swing.JButton btnAddD;
    private javax.swing.JButton btnAddH;
    private javax.swing.JButton btnDeleteD;
    private javax.swing.JButton btnDeleteH;
    private javax.swing.JButton btnFindClosestH;
    private javax.swing.JButton btnFindClosestH1;
    private javax.swing.JButton btnFindClosestP;
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnRegister;
    private javax.swing.JComboBox<String> cmbDiseasesN;
    private javax.swing.JComboBox<String> cmbHospital;
    private javax.swing.JComboBox<String> cmbHospitalHD;
    private javax.swing.JComboBox<String> cmbHospitalHL;
    private javax.swing.JComboBox<String> cmbHospitalPL;
    private javax.swing.JComboBox<String> cmbProvinceHD;
    private javax.swing.JComboBox<String> cmbProvinceHL;
    private javax.swing.JComboBox<String> cmbProvincePD;
    private javax.swing.JComboBox<String> cmbProvincePL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblBackground1;
    private javax.swing.JLabel lblBackground3;
    private javax.swing.JLabel lblBackground4;
    private javax.swing.JLabel lblLogo1;
    private javax.swing.JLabel lblLogo3;
    private javax.swing.JLabel lblLogo4;
    private javax.swing.JLabel lblLogo5;
    private javax.swing.JLabel lblLogo6;
    private javax.swing.JTabbedPane mainTabbedPane;
    private javax.swing.JPanel pnlDiseases;
    private javax.swing.JPanel pnlHospital;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JPanel pnlPatient;
    private javax.swing.JPanel pnlSettings;
    private javax.swing.JTextArea txtAreaH;
    private javax.swing.JTextArea txtAreaH1;
    private javax.swing.JTextArea txtAreaP;
    private javax.swing.JTextField txtDDescription;
    private javax.swing.JTextField txtDName;
    private javax.swing.JTextField txtHDistance;
    private javax.swing.JTextField txtHFrom;
    private javax.swing.JTextField txtHName;
    private javax.swing.JTextField txtHTo;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
}
