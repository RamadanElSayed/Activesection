package soft.mycompany.activesection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import soft.mycompany.activesection.Myclass.Departments;
import soft.mycompany.activesection.Myclass.Employees;

public class DeptActivity extends AppCompatActivity {

    List<Departments> list;
    ArrayList<Integer> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dept);
        final EditText DeptName=(EditText)findViewById(R.id.editText);
        final EditText Deptlocation=(EditText)findViewById(R.id.editText2);
        final EditText Deptid=(EditText)findViewById(R.id.editText3);
        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((DeptName.getText().toString().equals(""))||(Deptlocation.getText().toString().equals(""))||(Deptid.getText().toString().equals("")))


                {

                    Toast.makeText(DeptActivity.this, "Please enter all fileds", Toast.LENGTH_SHORT).show();
                } else {


                    Departments departments = new Departments();
                    String deptNam = DeptName.getText().toString();
                    String DeptLoca = Deptlocation.getText().toString();
                    int deptId = Integer.parseInt(Deptid.getText().toString());


                    list = departments.ReturnemployeesNmaes();

                    arrayList = new ArrayList<>();
                    for (Departments k : list) {
                        arrayList.add(k.department_id);

                    }
                    boolean flag = true;
                    for (int i = 0; i < arrayList.size(); i++) {
                        if (arrayList.get(i) == deptId) {
                            flag = false;
                        }
                    }
                    if (flag == true) {
                        departments.name_location = deptNam;
                        departments.Dept_Location = DeptLoca;
                        departments.department_id = deptId;
                        departments.save();
                        Toast.makeText(DeptActivity.this, "Department Added", Toast.LENGTH_SHORT).show();
                        DeptName.setText("");
                        Deptlocation.setText("");
                        Deptid.setText("");
                    } else {
                        Toast.makeText(DeptActivity.this, "Please enter Id Instead that", Toast.LENGTH_SHORT).show();

                    }


                }
            }
        });
    }
}
