package com.androidapp.astanasightseeing.astanasightseeing;

        import android.content.Context;
        import android.content.res.Resources;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;

public class DbAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DbAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DbAccess(Context context) {
        this.openHelper = new DbHelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DbAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DbAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }

    /**
     * Read all quotes from the database.
     *
     * @return a List of quotes
     */
    public List<Place> getData() {
        String tableName = "places_table_en";

        if(LanguagePage.chosenLanguage == "Kazakh"){
            tableName = "places_table_kaz";
        }else if(LanguagePage.chosenLanguage == "Russian"){
            tableName = "places_table_rus";
        }

        List<Place> mPlaceList = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM "+tableName+" INNER JOIN places_table_values ON "+tableName+".ID = places_table_values.PLACE_ID;", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            String name = cursor.getString(cursor.getColumnIndex("NAME"));
            String picture_name = cursor.getString(cursor.getColumnIndex("PICTURE_NAME"));
            //int pic_id = Resources.getSystem().getIdentifier(picture_name, "drawable", "android");
            String history = cursor.getString(cursor.getColumnIndex("HISTORY"));
            String lat = cursor.getString(cursor.getColumnIndex("LAT"));
            String lon = cursor.getString(cursor.getColumnIndex("LON"));
            String address = cursor.getString(cursor.getColumnIndex("ADDRESS"));
            String phone = cursor.getString(cursor.getColumnIndex("PHONE"));
            String webaddress = cursor.getString(cursor.getColumnIndex("WEBADDRESS"));
            String working_hrs = cursor.getString(cursor.getColumnIndex("WORKING_HRS"));
            String category = cursor.getString(cursor.getColumnIndex("CATEGORY"));

            mPlaceList.add(new Place(id, name, picture_name, history,lat,lon,address,phone,webaddress,working_hrs,category));
            cursor.moveToNext();
        }
        cursor.close();
        return mPlaceList;
    }
}
