package mapdemo.fe.rupp.mapdemo.db_connection;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by malypoeur on 3/2/16.
 */

public class DBConnection extends SQLiteAssetHelper {

    private static DBConnection instance;
    private static final String DATABASE_NAME = "DBDemo.sqlite";
    private static final int DATABASE_VERSION = 1;

    public static DBConnection getInstance(Context context) {
        if (instance == null) {
            instance = new DBConnection(context);
        }

        return instance;
    }

    private DBConnection(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public Cursor getLocations() {
        String[] whereArgs = {};
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM LOCATION", whereArgs);
        c.moveToFirst();
        return c;
    }
}