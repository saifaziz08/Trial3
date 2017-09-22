package com.example.saifaziz.trial3.Database;

import android.os.AsyncTask;

import com.example.saifaziz.trial3.Vendors.Vendor;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * Created by saif aziz on 9/3/2017.
 */

public class DatabaseAdapter extends AsyncTask<Object, Object, ResultSet>
{
    final static String ip = "storage.crenm7ov9qvh.us-east-1.rds.amazonaws.com:3306";
    final static String db = "Storage";
    final static String username = "StorageAdmin";
    final static String password = "Storage12345";
    String driver = "com.mysql.jdbc.Driver";
    String query = "";
    String url = "jdbc:mysql://"+ip+"/"+db;
    ResultSet rs;

    public DatabaseAdapter() {

    }

    @Override
    protected ResultSet doInBackground(Object... objects)
    {
        try
        {
            Class.forName(driver);
            java.sql.Connection conn = DriverManager.getConnection(url, username, password);
            if (conn != null)
            {
                java.sql.Statement stmt = conn.createStatement();
                if (stmt != null)
                    rs = stmt.executeQuery(query);
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        return rs;
    }

    public void setQuery(String query) {
        this.query = query;
    }

}
