package mapdemo.fe.rupp.mapdemo.db_connection;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;

/**
 * Created by malypoeur on 3/2/16.
 */

public class GetLocationsTask  extends AsyncTask<String, Void, Cursor> {
    private DBConnection db;

    public GetLocationsTask(Context context) {
        db = DBConnection.getInstance(context);
    }

    @Override
    protected Cursor doInBackground(String... params) {
            return db.getLocations();
    }
}
