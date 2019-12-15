package com.example.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.sqllite.MainContent;

import java.util.ArrayList;
import java.util.List;

public class db extends SQLiteOpenHelper {

    private static String dbName = "registrydb";
    private static String tableName = "registry";
    private static String idcolumn = "id";
    private static String employeename = "name";
    private static String employeephone = "phone";
    private static String date = "date";
    private static String menu = "menu";
    private static String price = "price";

    public db(Context context) {
        super(context, dbName, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE table" + tableName + "(" + idcolumn + "integer primary key autoincrement," +
                employeename + "text," +
                employeephone + "text," +
                date + "date," +
                menu + "text," +
                price + "int" + ")");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public List<MainContent> search(String keyword)
    {
        List<MainContent> mainContents=null;
        try{
            SQLiteDatabase sqLiteDatabase=getReadableDatabase();
            Cursor cursor=sqLiteDatabase.rawQuery("select * from"+tableName+"where"+employeename+"like ?",new String[]{"%" +keyword+ "%"});
            if(cursor.moveToFirst()){
                mainContents=new ArrayList<>();
                do{
                    MainContent mainContent=new MainContent();
                    mainContent.setId(cursor.getInt(0));
                    mainContent.setName(cursor.getString(1));
                    mainContent.setPhone(cursor.getString(2));
                    mainContent.setDate(cursor.getString(3));
                    mainContent.setMenu(cursor.getString(4));
                    mainContent.setPrice(cursor.getString(5));
                    mainContents.add(mainContent);
                }while(cursor.moveToNext());
            }
        }
        catch(Exception e){
            mainContents=null;
        }
        return mainContents;
    }


    public boolean create(MainContent mainContent) {
        try {
            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(employeename, mainContent.getName());
            contentValues.put(employeephone, mainContent.getPhone());
            contentValues.put(date, mainContent.getDate());
            contentValues.put(menu, mainContent.getMenu());
            contentValues.put(price, mainContent.getPrice());
        }
        catch (Exception e) {
            return false;
        }
        return false;
    }
}
