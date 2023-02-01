package bohyun.JDBCTest.connection;

import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static bohyun.JDBCTest.connection.LinkedAccount.*;
// LinkedAccount에 있는 변수 값들을 import 해줬기 때문에 현재 DBConnectionUtility에서
// LinkedAccount에 있는 값을 Connection을 통해 사용 가능하다

@Slf4j
public class DBConnectionUtility
{
    public static Connection getConnection()
    {
        try
        {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            log.info("get Connection = {}, class = {}", connection, connection.getClass());
            return connection;
        }
        catch (SQLException exception)
        {
            throw new IllegalStateException(exception);
        }
    }
}
