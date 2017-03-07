package soft.mycompany.activesection.Myclass;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.activeandroid.query.Update;

import java.util.List;

/**
 * Created by Ramadan El-Sayed on 11/5/2016.
 */
@Table(name = "EmployeeOfall")

public class Employees extends Model
{
        @Column(name ="empid")
        public int employee_id;
        @Column(name ="NameEmp")
        public String employee_name;
        @Column(name ="Phone")

        public String employee_phone;
        @Column(name ="Email")

        public String employee_email;
        @Column(name ="Address")

        public String employee_address;
        @Column(name ="DeptId")

        public int    IdOfDEpartment;

        public Employees() {

                super();
        }
        public  List<Employees> ReturnemployeesNmaes()
        {
                return new Select().from(Employees.class).execute();

        }

        public List<Employees>returndataaccordingname(String empNmaeInList)
        {
                return new Select().from(Employees.class).where("NameEmp = ?",empNmaeInList).execute();
        }


        public  void deleteItem(String Itemdata)
        {
                try {
                        new Delete()
                                .from(Employees.class)
                                .where("NameEmp = ?",
                                        Itemdata).execute();
                } catch (Exception e) {
                        e.printStackTrace();
                }

        }
        public void updateItem(int emp_id,String NameOfEmp,String Address,int deptID)
        {
                new Update(Employees.class).set("NameEmp  = ?," +
                        "Address = ?," +
                        "DeptId = ? ",NameOfEmp,Address,deptID).where("empid = ?",emp_id).execute();
        }
}
