package soft.mycompany.activesection.Myclass;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;

/**
 * Created by Ramadan El-Sayed on 11/5/2016.
 */
public class yourApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Configuration dbConfiguration=new Configuration.Builder(this).setDatabaseName("compa.db").
                addModelClasses(Employees.class,Departments.class).create();
        ActiveAndroid.initialize(dbConfiguration);
    }
}
