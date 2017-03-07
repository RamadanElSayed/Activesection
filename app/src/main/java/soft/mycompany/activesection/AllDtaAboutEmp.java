package soft.mycompany.activesection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AllDtaAboutEmp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_dta_about_emp);


        Intent i=getIntent();
        String NameOfEmp=i.getExtras().getString("name");
        String EmpPhone=i.getExtras().getString("phone");
        String EmpEmail=i.getExtras().getString("email");
        String EmpAddress=i.getExtras().getString("address");
        String EmpDept=i.getExtras().getString("deptname");
        int empId=i.getExtras().getInt("empId");
        TextView Name= (TextView) findViewById(R.id.textView2_empName);
        TextView phone= (TextView) findViewById(R.id.textView4_phone);
        TextView Email= (TextView) findViewById(R.id.textView5_email);
        TextView Address= (TextView) findViewById(R.id.textView3_address);
        TextView EmpDet= (TextView) findViewById(R.id.textView6_deptName);
        TextView EmpID= (TextView) findViewById(R.id.textView7_empNumber);
        Name.setText("Name:"+" "+NameOfEmp);
        phone.setText("Phone:"+" "+EmpPhone);
        Email.setText("Email:"+" "+EmpEmail);
        Address.setText("Address:"+" "+EmpAddress);
        EmpDet.setText("DepartmentName:"+" "+EmpDept);
        EmpID.setText("EmployeeID:"+" "+empId);


    }
}
