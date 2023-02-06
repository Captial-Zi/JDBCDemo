import com.msb.jdbc.base1.Dept;
import com.msb.jdbc.base1.DeptDao;
import org.junit.Test;

public class TestDeptDao {
        @Test
        public void testAddDept() {
            Dept d = new Dept(21, "xxxxxx", "火星");

            DeptDao dd = new DeptDao();
            dd.addDept(d);
        }

}
