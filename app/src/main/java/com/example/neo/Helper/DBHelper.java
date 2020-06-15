package com.example.neo.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.neo.Model.LoginResponse;
import com.example.neo.Model.UserDetailsResponse;
import com.example.neo.Model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {

    //static variable
    private static final int DATABASE_VERSION = 1;

    //Database Name
    private static final String DATABASE_NAME = "neo";

    //Table Name
    private static final String TABLE_TOKEN = "loginToken";
    private static final String TABLE_USER = "userDetails";

    //Token Table Column Name
    private static final String KEY_ID = "id";
    private static final String KEY_ACCESS_TOKEN = "access_token";

    //User Details Table Column Name
    private static final String KEY_USER_ID = "user_id";
    private static final String KEY_USER_NAME = "name_user";
    private static final String KEY_USER_DATA_ID = "id";
    private static final String KEY_USER_EMAIL = "email";
    private static final String KEY_USER_COUNTRY = "country";
    private static final String KEY_USER_PHONE = "phone";
    private static final String KEY_USER_ID_NUMBER = "id_number";


    public DBHelper(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE_TOKEN = "CREATE TABLE " + TABLE_TOKEN + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_ACCESS_TOKEN + " TEXT )";

        String CREATE_TABLE_USER = "CREATE TABLE " + TABLE_USER + "("
                + KEY_USER_ID + " INTEGER PRIMARY KEY,"
                + KEY_USER_NAME + " TEXT,"
                + KEY_USER_DATA_ID+ " INTERGER,"
                + KEY_USER_EMAIL + " TEXT,"
                + KEY_USER_COUNTRY + " INTERGER,"
                + KEY_USER_PHONE + " TEXT,"
                + KEY_USER_ID_NUMBER + " TEXT )";

        sqLiteDatabase.execSQL(CREATE_TABLE_TOKEN);
        sqLiteDatabase.execSQL(CREATE_TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_TOKEN);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
        onCreate(sqLiteDatabase);
    }

    /** CRUD Token **/

    // Addding new token
    public void  addToken(LoginResponse loginResponse){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ACCESS_TOKEN, loginResponse.getData());

        //inserting row
        db.insert(TABLE_TOKEN, null, values);
        db.close();
    }


    // Getting simgle token
    public LoginResponse getToken(){
        int id = 1;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_TOKEN, new String[] {
                KEY_ID, KEY_ACCESS_TOKEN}, KEY_ID + "=?", new String[] {
                        String.valueOf(id) }, null, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();

        LoginResponse token = new LoginResponse();
        token.setData(cursor.getString(cursor.getColumnIndex(KEY_ACCESS_TOKEN)));
        return token;
    }
    // Updating single token
    public int updateToken(LoginResponse loginResponse){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_ACCESS_TOKEN, loginResponse.getData());

        //Updating row
        return db.update(TABLE_TOKEN, values, KEY_ID + "=?", new String[]{String.valueOf(1)});
    }

    // Getting token count
    public int getTokenCount(){
        String countQuery = "SELECT * FROM " + TABLE_TOKEN;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);
        int count = cursor.getCount();
        cursor.close();

        return count;
    }


    // Deleting Single Token
    public void deleteToken(){
        int id = 1;
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TOKEN, KEY_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
    }
    /** End **/


    /** CRUD USER **/

    public void addUser(UserDetailsResponse userDetailsResponse){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USER_NAME, userDetailsResponse.getDataUser().getName());
        values.put(KEY_USER_DATA_ID, userDetailsResponse.getDataUser().getId());
        values.put(KEY_USER_EMAIL, userDetailsResponse.getDataUser().getEmail());
        values.put(KEY_USER_COUNTRY, userDetailsResponse.getDataUser().getCountry_id());
        values.put(KEY_USER_PHONE, userDetailsResponse.getDataUser().getPhone());
        values.put(KEY_USER_ID_NUMBER, userDetailsResponse.getDataUser().getId_number());

        //inserting row
        db.insert(TABLE_USER, null, values);
        db.close();
    }

    public UserModel getuser(){
        String query = "SELECT * FROM " + TABLE_USER;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query,null);
        if (cursor != null)
            cursor.moveToFirst();

        UserModel userModel = new UserModel();
        userModel.setName(cursor.getString(cursor.getColumnIndex(KEY_USER_NAME)));
        userModel.setData_id(cursor.getInt(cursor.getColumnIndex(KEY_USER_DATA_ID)));
        userModel.setEmail(cursor.getString(cursor.getColumnIndex(KEY_USER_EMAIL)));
        userModel.setCountry(cursor.getInt(cursor.getColumnIndex(KEY_USER_COUNTRY)));
        userModel.setPhone(cursor.getString(cursor.getColumnIndex(KEY_USER_PHONE)));
        userModel.setId_number(cursor.getString(cursor.getColumnIndex(KEY_USER_ID_NUMBER)));

        return userModel;

    }

    //Updating single user
    public int updateUser(UserDetailsResponse userDetailsResponse){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_USER_NAME, userDetailsResponse.getDataUser().getName());
        values.put(KEY_USER_DATA_ID, userDetailsResponse.getDataUser().getId());
        values.put(KEY_USER_EMAIL, userDetailsResponse.getDataUser().getEmail());
        values.put(KEY_USER_COUNTRY, userDetailsResponse.getDataUser().getCountry_id());
        values.put(KEY_USER_PHONE, userDetailsResponse.getDataUser().getPhone());
        values.put(KEY_USER_ID_NUMBER, userDetailsResponse.getDataUser().getId_number());

        //Updating row
        return db.update(TABLE_USER, values, KEY_USER_ID + "=?", new String[]{String.valueOf(1)});
    }

    // Getting User Count
    public int getUserCount(){
        String countQuery = "SELECT * FROM " + TABLE_USER;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);
        int count = cursor.getCount();
        cursor.close();

        return count;
    }

    // Deleting Single Token
    public void deleteUser(){
        int id = 1;
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_USER, KEY_USER_ID + " = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    /** End **/


}
