import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeRepo {

    public void insertRecord(Information info) throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Statement statement = null;
        try {
            // Step1: Load & Register Driver Class
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            // Step2: Establish a MySql Connection
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306?user= root & password = 121993");

            // Step3: Create Statement
            statement = connection.createStatement();

            // Step4: Execute Query
            String query = "insert into payroll_service.employee_payroll(Name,department,gender, basicpay) value('" + info.getName()
                    + "','" + info.getDepartment() + "','" + info.getGender() + "','" + info.getBasicPay() + "')";
            int result = statement.executeUpdate(query);
            System.out.print(result);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                statement.close();
            }
            if (statement != null) {
                connection.close();
            }
        }

    }}
