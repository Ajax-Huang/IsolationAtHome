import com.ajax.Demo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Ajax Huang
 * @create 2021-10-18-16:13
 */
@SpringBootTest(classes = Demo.class)
public class DemoApplicationTests {

    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads(){
        System.out.println(dataSource.getClass());
        try {
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
