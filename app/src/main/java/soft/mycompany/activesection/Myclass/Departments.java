package soft.mycompany.activesection.Myclass;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by Ramadan El-Sayed on 11/5/2016.
 */
@Table(name = "DepartmentOfall")

public class Departments extends Model {
    @Column(name ="LocationDept")
    public String Dept_Location;
    @Column(name ="LocationId")
    public int department_id;
    @Column(name ="LocationName")
    public String name_location;

    public Departments() {

        super();
    }
    public List<Departments> ReturnemployeesNmaes()
    {
        return new Select().from(Departments.class).execute();

    }
    public List<Departments>ReturndeptName(int deptId)
    {
        return new Select().from(Departments.class).where("LocationId = ?",deptId).execute();

    }
}
