package com.cathay.acctdaycut.dao;

import com.cathay.acctdaycut.base.AbstractTestBase;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by jamestang on 2018/8/6.
 */
public class DsTest extends AbstractTestBase {


    @Test
    public void datasourceget() throws SQLException {
        // Get ZdalDataSource
        DataSource dataSource = (DataSource) applicationContext.getBean("daycutdataSource");

        Connection connection = null;

        try {
            connection = dataSource.getConnection();
            String selectSql = "select * from acc_msg ";
            PreparedStatement queryPreparedStatement = connection.prepareStatement(selectSql);
            //queryPreparedStatement.setInt(1, 1);
            ResultSet resultSet = queryPreparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.print("  id:" + resultSet.getInt(1) + ", ");
                System.out.println("content:" + resultSet.getString(2));
            }
         /*   queryPreparedStatement = connection.prepareStatement(selectSql);
            queryPreparedStatement.setInt(1, 2);
            resultSet = queryPreparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.print("  id:" + resultSet.getInt(1) + ", ");
                System.out.println("name:" + resultSet.getString(2));
            }*/
        } catch (Exception e) {
            System.out.println(" -- Exception --");
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }

    }
}
