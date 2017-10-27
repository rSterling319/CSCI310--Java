/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rs
 */
public class DBclass {

    private Connection connection = null;

    public Connection getConnection() {
        if (connection == null) {
            synchronized (this) {
                if (connection == null) {
                    try {
                        connection = DriverManager.getConnection("jdbc:sqlite:hw4.db");
                    } catch (SQLException ex) {
                        Logger.getLogger(Hw4.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return connection;
    }

    private HashMap< String, PreparedStatement> preparedStatementCache = null;
    public static final int SQL_STATEMENT_TIMEOUT_SECONDS = 10;

    public PreparedStatement getPreparedStatement(String sql) {
        if (preparedStatementCache == null) {
            synchronized (this) {
                if (preparedStatementCache == null) {
                    preparedStatementCache = new HashMap< String, PreparedStatement>();
                }
            }
        }

        PreparedStatement preparedStatement = preparedStatementCache.get(sql);
        if (preparedStatement == null) {
            synchronized (this) {
                preparedStatement = preparedStatementCache.get(sql);
                if (preparedStatement == null) {
                    try {
                        Connection connection = getConnection();
                        int keyMode = sql.startsWith("insert") ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS;

                        preparedStatement = connection.prepareStatement(sql, keyMode);
                        preparedStatement.setQueryTimeout(SQL_STATEMENT_TIMEOUT_SECONDS);
                        preparedStatementCache.put(sql, preparedStatement);
                    } catch (SQLException ex) {
                        Logger.getLogger(Hw4.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return preparedStatement;
    }

    ResultSet sql(String sql, Object... objects) {
        try {
            PreparedStatement preparedStatement = getPreparedStatement(sql);
            int index = 1;
            for (Object object : objects) {
                if (object instanceof Boolean) {
                    preparedStatement.setBoolean(index, (Boolean) object);
                } else if (object instanceof Integer) {
                    preparedStatement.setInt(index, (Integer) object);
                } else if (object instanceof Long) {
                    preparedStatement.setLong(index, (Long) object);
                } else if (object instanceof String) {
                    preparedStatement.setString(index, (String) object);
                } else if (object instanceof Double){
                    preparedStatement.setDouble(index, (Double) object);
                }
                else {
                    throw new IllegalStateException("Can't set Type" + object.getClass().getName());
                }
                ++index;
            }
            if (sql.startsWith("insert")) {
                preparedStatement.execute();
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                return resultSet;
            } else {
                ResultSet resultSet = preparedStatement.executeQuery();
                return resultSet;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Hw4.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private Statement statement = null;

    public Statement getStatement() {
        if (statement == null) {
            synchronized (this) {
                if (statement == null) {
                    try {
                        Connection connection = getConnection();
                        statement = connection.createStatement();
                        statement.setQueryTimeout(SQL_STATEMENT_TIMEOUT_SECONDS);
                    } catch (SQLException ex) {
                        Logger.getLogger(Hw4.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return statement;
    }

    void sql(String command) {
        try {
            Statement statement = getStatement();
            statement.executeUpdate(command);
        } catch (SQLException ex) {
            Logger.getLogger(Hw4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    Long longResult(ResultSet resultSet) {
        try {
            if (resultSet != null && resultSet.next()) {
                return resultSet.getLong(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Hw4.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    String[] stringsResult(ResultSet resultSet) {
        try {
            if (resultSet != null & resultSet.next()) {
                String str = "";
                int i = 1;
                int totRes = resultSet.getMetaData().getColumnCount();
                String[] ans = new String[totRes];
                while(i<= totRes){
                    ans[i-1]=resultSet.getString(i);
                    ++i;
                }
//                return resultSet.getString(1);
                return ans;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Hw4.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    void reset() {
        sql("drop table if exists student");
        sql("create table student (id integer primary key, fName string, lName string)");
        sql("drop table if exists class");
        sql("create table class (id integer primary key, title string)");
        sql("drop table if exists grades");
        sql("create table grades ("
                + "sid integer, "
                + "cid integer, "
                + "q1 real, "
                + "q2 real, "
                + "q3 real, "
                + "q4 real, "
                + "qAvg real,"
                + "t1 real,"
                + "t2 real,"
                + "tAvg real,"
                + "fin real,"
                + "grade string,"
                + "foreign key(sid) references student(id),"
                + "foreign key(cid) references class(id))");
    }
    
    Long insertStudent(Student student){
        return longResult(sql("insert into student(fName,lName) values(?,?)", student.getFname(), student.getLname()));
    }
    String getStudent(long id){
        return String.join(" ", stringsResult(sql("select fName, lName from student where id=?", id)));
    }
    
    String getStudentInfoByLast(String lName){
        return String.join(" ", stringsResult(sql("select id, fName, lName from student where lName like ?", lName)));
    }
    
    Long insertClass(Class cl){
        return longResult(sql("insert into class(title) values(?)", cl.getTitle()));
    }
    
    String getClass(long id){
        return stringsResult(sql("select title from class where id=?", id))[0];
    }
    
//    Long insertGrades(Student student, Grades grades, Class cl){
//        return longResult(sql("insert into grades(sid,cid, q1, q2, q3, q4, t1, t2, tAvg, fin, grade) values (?,?,?,?,?,?,?, ?,?,?,?)",
//                student.getId(), cl.getId(), grades.quizes.get(0), grades.quizes.get(1),grades.quizes.get(2), grades.quizes.get(3), grades.tests.get(0), grades.tests.get(1),
//                grades.getTestAvg(), grades.getFinalGrade(), grades.getLetGrade()));
//    }
    void insertGrades(Student student, Grades grades, Class cl){
        sql("insert into grades(sid,cid, q1, q2, q3, q4, t1, t2, tAvg, fin, grade) values (?,?,?,?,?,?,?, ?,?,?,?)",
                student.getId(), cl.getId(), grades.quizes.get(0), grades.quizes.get(1),grades.quizes.get(2), grades.quizes.get(3), grades.tests.get(0), grades.tests.get(1),
                grades.getTestAvg(), grades.getFinalGrade(), grades.getLetGrade());
    }
    
    String getGrade(Student student, Class cl){
        return stringsResult(sql("select grade from grades where sid =? and cid =?", student.getId(), cl.getId()))[0];
    }
    
    

}