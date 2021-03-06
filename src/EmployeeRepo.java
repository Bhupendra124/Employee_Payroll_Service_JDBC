import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    }

    public List<Information> findAll(String Name) throws SQLException {
        List<Information> infos = new ArrayList<>();

        Connection connection = null;
        PreparedStatement prepstatement = null;
        try {
            //Step1: Load & Register Driver Class
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            //Step2: Establish a MySql Connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user= root & password = 121993");

            //Step3: Create Statement
            String query = " select * from payroll_service.employee_payroll where Name=?";
            prepstatement = connection.prepareStatement(query);
            prepstatement.setString(1, Name);

            //Step4: Execute Query
            ResultSet resultset = prepstatement.executeQuery();

            while (resultset.next()) {
                Information information = new Information();

                int id = resultset.getInt(1);
                information.setId(id);

                String name = resultset.getString(2);
                information.setName(name);

                String dept = resultset.getString(3);
                information.setDepartment(dept);

                String gender = resultset.getString(4);
                information.setGender(gender);

                int pay = resultset.getInt(5);
                information.setBasicPay(pay);

                infos.add(information);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (connection != null) {
                connection.close();
            }
            if (prepstatement != null) {
                prepstatement.close();
            }
        }
        return infos;
    }
}



