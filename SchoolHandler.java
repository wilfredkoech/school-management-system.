package nsuniversity.schoolHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class SchoolHandler {
  
    private static SchoolHandler handler=null;

    private static final String DB_URL = "jdbc:derby:database;create=true";
    private static Connection conn = null;
    private static Statement stmt = null;

   private SchoolHandler() {
    
        createConnection();
        setupSemTable();
        setupSchoolsTable();
        setupYearsTable();
        setupIntakeTable();
         setupGradeTable();
         setupGradesTable();
          setupCertTable();
         setupMembersTable();
          setupOccupTable();
          setupRunitsTable();
        setupSchoolsTable();
        setupSwitchTable();
        setupBookIssueTable();
        setupCoursesTable();
        setupDepartmentsTable();
        setupResultsTable();
        setupStudentTable();
        setupStaffTable();
        setupBookTable();
        setupFmodeTable();
        setupAcyrTable();
        setupFeeStructTable();
        setupUnitsTable();
        setupFpayTable();
                           }
public static SchoolHandler getInstance() {
         if(handler==null)
        {
            handler = new SchoolHandler();
        }
        return handler;
    }

    void createConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            conn = DriverManager.getConnection(DB_URL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
            ///////////////////////
    void createClient()  {
ServerSocket server;
        try {
            server = new ServerSocket(3000);
            Socket s=server.accept();
        } catch (IOException ex) {
            Logger.getLogger(SchoolHandler.class.getName()).log(Level.SEVERE, null, ex);
        }

     
    }
  void setupFpayTable() {
        String TABLE_NAME = "FEEPAY";
        try {
            stmt = conn.createStatement();

            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);

            if (tables.next()) {
                System.out.println("Table " + TABLE_NAME + "already exists. Ready for go!");
            } else {
                stmt.execute("CREATE TABLE " + TABLE_NAME + "("
                        + "	rsId INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1,INCREMENT BY 1) primary key,\n" 
                        + "	fmodes varchar(200),"
                        + "     finvoice varchar(200),"
                        + "	admiss varchar(25),"
                        + "	form varchar(20),"
                        + "     term varchar(20),"
                        + "     years varchar(20),"
                        + "     classs varchar(200),"
                        + "     fpaid double,"
                        + "     fowed double,"
                        + "     semfee double,"
                        + "     cdate date,"
                        + "     ctime timestamp default CURRENT_TIMESTAMP,"
                        + "	status varchar(1) default '1'"
                        + " )");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage() + " --- setupDatabase");
        } finally {
        }
  }
/////////////////////
    ///////////////////////
  void setupFeeStructTable() {
        String TABLE_NAME = "FEESTRUCT";
        try {
            stmt = conn.createStatement();

            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);

            if (tables.next()) {
               System.out.println("Table " + TABLE_NAME + "already exists. Ready for go!");
            } else {
                stmt.execute("CREATE TABLE " + TABLE_NAME + "("
                        + "	rsId INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1,INCREMENT BY 1) primary key,\n" 
                        + "     form varchar(11),\n"
                        + "	term varchar(11),\n"
                        + "     amounts double,\n"
                        + "     cdate date,\n"
                        + "     ctime timestamp default CURRENT_TIMESTAMP,\n"
                        + "	status varchar(2) default '1'"
                        + " )");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage() + " --- setupDatabase");
        } finally {
        }
  }
/////////////////////
          ///////////////////////
  void setupFmodeTable() {
        String TABLE_NAME = "FEEMODE";
        try {
            stmt = conn.createStatement();

            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);

            if (tables.next()) {
                System.out.println("Table " + TABLE_NAME + "already exists. Ready for go!");
            } else {
                stmt.execute("CREATE TABLE " + TABLE_NAME + "("
                        + "	fmodes varchar(200) primary key,"
                        + "	status varchar(1) default '1'"
                        + " )");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage() + " --- setupDatabase");
        } finally {
        }
  }
  /////////////////////
        ///////////////////////
  void setupSwitchTable() {
        String TABLE_NAME = "SWITCH_C";
        try {
            stmt = conn.createStatement();

            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);

            if (tables.next()) {
                System.out.println("Table " + TABLE_NAME + "already exists. Ready for go!");
            } else {
                stmt.execute("CREATE TABLE " + TABLE_NAME + "("
                        + "	swtch varchar(200) primary key,"
                        + "	status varchar(1) default '1'"
                        + " )");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage() + " --- setupDatabase");
        } finally {
        }
  }
  /////////////////////

  void setupMembersTable() {
        String TABLE_NAME = "USERS";
        try {
            stmt = conn.createStatement();

            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);

            if (tables.next()) {
                System.out.println("Table " + TABLE_NAME + "already exists. Ready for go!");
            } else {
                stmt.execute("CREATE TABLE " + TABLE_NAME + "("
                        + "	uname varchar(200) primary key,\n"
                        + "	pword varchar(200),\n"
                        + "	status varchar(1) default '1'"
                        + " )");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage() + " --- setupDatabase");
        } finally {
        }
    }
     ///////////////////////
/////////////////////
  void setupSemTable() {
        String TABLE_NAME = "SEMESTER";
        try {
            stmt = conn.createStatement();

            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);

            if (tables.next()) {
                System.out.println("Table " + TABLE_NAME + "already exists. Ready for go!");
            } else {
                stmt.execute("CREATE TABLE " + TABLE_NAME + "("
                        + "	semester integer primary key,\n"
                        + "	status varchar(1) default '1'"
                        + " )");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage() + " --- setupDatabase");
        } finally {
        }
    }
     ///////////////////////
  void setupAcyrTable() {
        String TABLE_NAME = "ACYR";
        try {
            stmt = conn.createStatement();

            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);

            if (tables.next()) {
                System.out.println("Table " + TABLE_NAME + "already exists. Ready for go!");
            } else {
                stmt.execute("CREATE TABLE " + TABLE_NAME + "("
                        + "	acyr_nam integer primary key,\n"
                        + "	status varchar(1) default '1'"
                        + " )");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage() + " --- setupDatabase");
        } finally {
        }
    }
     ///////////////////////


  void setupDepartmentsTable() {
        String TABLE_NAME = "DEPARTMENTS";
        try {
            stmt = conn.createStatement();

            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);

            if (tables.next()) {
                System.out.println("Table " + TABLE_NAME + "already exists. Ready for go!");
            } else {
                stmt.execute("CREATE TABLE " + TABLE_NAME + "("
                        + "	departments varchar(200) primary key,\n"
                        + "	schools varchar(200),\n"
                        + "	status varchar(4) default '1'"
                        + " )");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage() + " --- setupDatabase");
        } finally {
        }
    }
     ///////////////////////
      ///////////////////////
  void setupCoursesTable() {
        String TABLE_NAME = "COURSES";
        try {
            stmt = conn.createStatement();

            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);

            if (tables.next()) {
              System.out.println("Table " + TABLE_NAME + "already exists. Ready for go!");
            } else {                                
                stmt.execute("CREATE TABLE " + TABLE_NAME + "("
                        + "	course_name varchar(200) primary key,\n"
                        + "	school varchar(200),\n"
                        + "	department varchar(200),\n"
                        + "	certification varchar(200),\n"
                        + "	status varchar(2) default '1'\n"
                        + " )");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage() + " --- setupDatabase");
        } finally {
        }
  }
/////////////////////
    ///////////////////////
  void setupUnitsTable() {
        String TABLE_NAME = "CUNITS";
        try {
            stmt = conn.createStatement();

            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);

            if (tables.next()) {
              System.out.println("Table " + TABLE_NAME + "already exists. Ready for go!");
            } else {                                
                stmt.execute("CREATE TABLE " + TABLE_NAME + "("
                        + "	unit_code varchar(200) primary key,\n"
                        + "	unit_name varchar(200),\n"
                        + "	school varchar(200),\n"
                        + "	department varchar(200),\n"
                        + "	course varchar(200),\n"
                        + "	acyr varchar(200),\n"
                        + "	sem varchar(200),\n"
                        + "	status varchar(2) default '1'\n"
                        + " )");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage() + " --- setupDatabase");
        } finally {
        }
  }
    ///////////////////////
  void setupRunitsTable() {
        String TABLE_NAME = "RUNITS";
        try {
            stmt = conn.createStatement();

            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);

            if (tables.next()) {
              System.out.println("Table " + TABLE_NAME + "already exists. Ready for go!");
            } else {                                
                stmt.execute("CREATE TABLE " + TABLE_NAME + "("
                        + "	unit_code varchar(200) primary key,\n"
                        + "	unit_name varchar(200),\n"
                        + "	school varchar(200),\n"
                        + "	department varchar(200),\n"
                        + "	course varchar(200),\n"
                        + "	acyr varchar(200),\n"
                        + "	reg_no varchar(200),\n"
                        + "	sem varchar(200),\n"
                        + "	status varchar(2) default '1'\n"
                        + " )");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage() + " --- setupDatabase");
        } finally {
        }
  }
/////////////////////
  ///////////////////////
  void setupYearsTable() {
        String TABLE_NAME = "YEARSS";
        try {
            stmt = conn.createStatement();

            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);

            if (tables.next()) {
              System.out.println("Table " + TABLE_NAME + "already exists. Ready for go!");     
            } else {
                stmt.execute("CREATE TABLE " + TABLE_NAME + "("
                        + "	yearss varchar(200) primary key,\n"
                         + "	status varchar(2) default'1'\n"
                        + " )");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage() + " --- setupDatabase");
        } finally {
        }
  }
///////////////////// 
    ///////////////////////
  void setupCertTable() {
        String TABLE_NAME = "CERTIFICATION";
        try {
            stmt = conn.createStatement();

            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);

            if (tables.next()) {
                System.out.println("Table " + TABLE_NAME + "already exists. Ready for go!");
            } else {
                stmt.execute("CREATE TABLE " + TABLE_NAME + "("
                        + "	cert_name varchar(200) primary key,\n"
                        + "	status varchar(2) default'1'\n"
                        + " )");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage() + " --- setupDatabase");
        } finally {
        }
  }
  void setupIntakeTable() {
        String TABLE_NAME = "SINTAKE";
        try {
            stmt = conn.createStatement();

            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);

            if (tables.next()) {
                System.out.println("Table " + TABLE_NAME + "already exists. Ready for go!");
            } else {
                stmt.execute("CREATE TABLE " + TABLE_NAME + "("
                        + "	intake_time varchar(200) primary key,\n"
                        + "	status varchar(2) default'1'\n"
                        + " )");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage() + " --- setupDatabase");
        } finally {
        }
  }
///////////////////// 
   ///////////////////////
  void setupSchoolsTable() {
        String TABLE_NAME = "SCHOOLS";
        try {
            stmt = conn.createStatement();

            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);

            if (tables.next()) {
                System.out.println("Table " + TABLE_NAME + "already exists. Ready for go!");
            } else {
                stmt.execute("CREATE TABLE " + TABLE_NAME + "("
                        + "	school_name varchar(200) primary key\n"
                        + " )");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage() + " --- setupDatabase");
        } finally {
        }
  }

   ///////////////////////
  void setupGradesTable() {
        String TABLE_NAME = "MEANGRADE";
        try {
            stmt = conn.createStatement();

            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);

            if (tables.next()) {
                System.out.println("Table " + TABLE_NAME + "already exists. Ready for go!");
            } else {
      stmt.execute("CREATE TABLE " + TABLE_NAME + "("
                        + "	grades varchar(200) primary key,"
                        + "	lowest integer,\n"
                        + "	highest integer\n"
                        + "\n"
                        + " )");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage() + " --- setupDatabase");
        } finally {
        }
  }
/////////////////////
  ///////////////////////
  void setupGradeTable() {
        String TABLE_NAME = "GRADES";
        try {
            stmt = conn.createStatement();

            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);

            if (tables.next()) {
                System.out.println("Table " + TABLE_NAME + "already exists. Ready for go!");
            } else {
                stmt.execute("CREATE TABLE " + TABLE_NAME + "("
                        + "	grades varchar(20) primary key,\n"
                        + "	recommendation varchar(200)\n"
                        + " )");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage() + " --- setupDatabase");
        } finally {
        }
  }
/////////////////////
///////////////////////
  void setupOccupTable() {
        String TABLE_NAME = "OCCUPATION";
        try {
            stmt = conn.createStatement();

            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);

            if (tables.next()) {
                System.out.println("Table " + TABLE_NAME + "already exists. Ready for go!");
            } else {
                stmt.execute("CREATE TABLE " + TABLE_NAME + "("
                        + "	occupation varchar(200) primary key\n"
                        + " )");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage() + " --- setupDatabase");
        } finally {
        }
  }
/////////////////////
  void setupStudentTable() {
        String TABLE_NAME = "STUDENT";
        try {
            stmt = conn.createStatement();

            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);

            if (tables.next()) {
           
            } else {
                stmt.execute("CREATE TABLE " + TABLE_NAME + "("
                        + "	reg_no varchar(200) primary key,\n" 
                        + "	fnames varchar(200),\n"
                        + "	lnames varchar(200),\n"
                        + "	onames varchar(200),\n"
                        + "	nationalId varchar(200),\n"
                        + "	residence varchar(200),\n"
                        + "	gender varchar(200),\n"
                        + "	mstatus varchar(200),\n"
                        + "	parent1 varchar(200),\n"
                        + "	pcontact varchar(200),\n"
                        + "	parent2 varchar(200),\n"
                        + "	pcontact2 varchar(200),\n"
                        + "	phone varchar(200),\n"
                        + "	email varchar(200),\n"
                        + "	school varchar(200),\n"
                        + "	department varchar(200),\n"
                        + "	course varchar(200),\n"
                        + "	occupation varchar(200),\n"
                        + "	certification varchar(200),\n"
                        + "	student_type varchar(200),\n"
                        + "	intake_type varchar(200),\n"
                        + "	academic_yr varchar(200),\n"
                        + "	semester varchar(200),\n"
                        + "	cur_sem varchar(200),\n"
                        + "	bdate date,\n"
                        + "	admdate date,\n"
                        + "	yod integer,\n"
                        + "	yop integer,\n"
                        + "	cdate varchar(200),\n"
                        + "	password varchar(200),\n"
                        + "	profile varchar(200),\n"
                        + "	time timestamp default CURRENT_TIMESTAMP,\n"
                        + "	ltime timestamp default CURRENT_TIMESTAMP,\n"
                        + "	status varchar(2) default '1'"
                        + " )");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage() + " --- setupDatabase");
        } finally {
        }
  }
  //////////////////
  /////////////////////
  void setupBookTable() {
        String TABLE_NAME = "NBOOKS";
        try {
            stmt = conn.createStatement();

            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);

            if (tables.next()) {
           System.out.println("Table " + TABLE_NAME + "already exists. Ready for go!");
            } else {
                stmt.execute("CREATE TABLE " + TABLE_NAME + "("
                        + "	bookId varchar(200) primary key,\n" 
                        + "	bookName varchar(200),\n"
                        + "	bookSubject varchar(200),\n"
                        + "	bookPrice varchar(200),\n"
                        + "	bookDesc varchar(200),\n"
                        + "	bkAuthor varchar(200),\n"
                        + "	form varchar(2),\n"
                        + "	cdate varchar(200),\n"
                        + "	time timestamp default CURRENT_TIMESTAMP,\n"
                        + "	status varchar(1) default '1'"
                        + " )");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage() + " --- setupDatabase");
        } finally {
        }
  }
  //////////////////
   /////////////////////
  void setupBookIssueTable() {
        String TABLE_NAME = "NBISSUE";
        try {
            stmt = conn.createStatement();

            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);

            if (tables.next()) {
               System.out.println("Table " + TABLE_NAME + "already exists. Ready for go!");
            } else {
                stmt.execute("CREATE TABLE " + TABLE_NAME + "("
                        + "	issueId INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1,INCREMENT BY 1) primary key,\n" 
                        + "	bookId varchar(200),\n"
                        + "	stId varchar(200),\n"
                        + "	form varchar(2),\n"
                        + "	issueDate date,\n"
                        + "	returnDate date,\n"
                        + "	time timestamp default CURRENT_TIMESTAMP,\n"
                        + "	status varchar(1) default '1'"
                        + " )");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage() + " --- setupDatabase");
        } finally {
        }
  }
  //////////////////
  //////////
  void setupStaffTable() {
        String TABLE_NAME = "STAFF";
        try {
            stmt = conn.createStatement();

            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);

            if (tables.next()) {
                System.out.println("Table " + TABLE_NAME + "already exists. Ready for go!");
            } else {
                stmt.execute("CREATE TABLE " + TABLE_NAME + "("
                        + "	nationalId varchar(200) primary key,\n" 
                        + "	fnames varchar(200),\n"
                        + "	lnames varchar(200),\n"
                        + "	onames varchar(200),\n"
                        + "	residence varchar(200),\n"
                        + "	gender varchar(200),\n"
                        + "	contact varchar(200),\n"
                        + "	ocontact varchar(200),\n"
                        + "	email varchar(200),\n"
                        + "	occupation varchar(200),\n"
                        + "	department varchar(200),\n"
                        + "	mstatus varchar(200),\n"
                        + "	cdate varchar(200),\n"
                        + "	yod integer,\n"
                        + "	yop integer,\n"
                        + "	time timestamp default CURRENT_TIMESTAMP,\n"
                        + "	ltime timestamp default CURRENT_TIMESTAMP,\n"
                        + "	status varchar(1) default '1'"
                        + " )");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage() + " --- setupDatabase");
        } finally {
        }
  }
//////////////////
//////////////////
  //////////
  void setupResultsTable() {
        String TABLE_NAME = "RESULTS";
        try {
            stmt = conn.createStatement();

            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);

            if (tables.next()) {
          
            } else {
                stmt.execute("CREATE TABLE " + TABLE_NAME + "("
                        + "	rsId INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 1,INCREMENT BY 1) primary key,\n" 
                        + "	reg_no varchar(200),\n"
                        + "	unit_code varchar(200),\n"
                        + "	unit_name varchar(200),\n"
                        + "	etype varchar(200),\n"
                        + "	acyr varchar(200),\n"
                        + "	sem varchar(200),\n"
                        + "	rmarks integer,\n"
                        + "	meanGrade varchar(3),\n"
                        + "	meanValue integer,\n"
                        + "	yeart varchar(200),\n" 
                        + "	cdate varchar(200),\n"
                        + "	time timestamp default CURRENT_TIMESTAMP,\n"
                        + "	ltime timestamp default CURRENT_TIMESTAMP,\n"
                        + "	status varchar(1) default '1'"
                        + " )");
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage() + " --- setupDatabase");
        } finally {
        }
  }
//////////////////
     public ResultSet execQuery(String query) {
        ResultSet result;
        try {
            stmt = conn.createStatement();
            result = stmt.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println("Exception at execQuery:dataHandler" + ex.getLocalizedMessage());
            return null;
        } finally {
        }
        return result;
    }
    public PreparedStatement execSction(String qu) {
        try {
            stmt = conn.createStatement();
            stmt.execute(qu);
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error:" + ex.getMessage(), "Error Occured", JOptionPane.ERROR_MESSAGE);
            System.out.println("Exception at execQuery:dataHandler" + ex.getLocalizedMessage());
            
        } finally {
            return null;
        }
    }
    
    public boolean execAction(String qu) {
        try {
            stmt = conn.createStatement();
            stmt.execute(qu);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error:" + ex.getMessage(), "Error Occured", JOptionPane.ERROR_MESSAGE);
            System.out.println("Exception at execQuery:dataHandler" + ex.getLocalizedMessage());
            return false;
        } finally {
        }
    }
}


