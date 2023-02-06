import com.msb.jdbc.base3.JDBCTransaction;
import org.junit.Test;

import java.sql.SQLException;

public class TestJDBCTransaction { 
    /**
     *
     * @throws SQLException
     */
    @Test
    public void tsetTransfer() throws SQLException {
        JDBCTransaction jdbcTransaction = new JDBCTransaction();
        jdbcTransaction.transfer2(7369,7499,2.0);
    }
}
