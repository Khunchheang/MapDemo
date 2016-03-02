package mapdemo.fe.rupp.mapdemo.controller;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import mapdemo.fe.rupp.mapdemo.db_connection.GetLocationsTask;

/**
 * Created by malypoeur on 3/2/16.
 */

public class LocationsMapper {

    private Context context;

    public LocationsMapper(Context context){
        this.context = context;
    }

    public void loadLocations() {
        GetLocationsTask getLine1StationsTask = new GetLocationsTask(context) {
            @Override
            protected void onPostExecute(Cursor cursor) {
                super.onPostExecute(cursor);
                try {
                    while (!cursor.isAfterLast()) {
                        String name = cursor.getString(1);
                        float latitude = cursor.getFloat(2);
                        float longitude = cursor.getFloat(3);
                        Log.d("Locations: ", name + " | " + latitude + " : " + longitude);
                        cursor.moveToNext();
                    }
                }catch(Exception e){
                    Log.d("LocationsMapper", e.toString());
                }
                finally {
                    cursor.close();
                }
            }
        };
        getLine1StationsTask.execute();
    }

}
