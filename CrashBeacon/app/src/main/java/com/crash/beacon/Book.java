package com.crash.beacon;

import com.syncano.library.annotation.SyncanoClass;
import com.syncano.library.annotation.SyncanoField;
import com.syncano.library.data.SyncanoObject;

@SyncanoClass(name = "ltds")
public class Book extends SyncanoObject{
    public static final String FIELD_LAT = "latitude";
    public static final String FIELD_LNG = "longitude";
    public static final String FIELD_ALT = "altitude";
    public static final String FIELD_X =   "force_x";
    public static final String FIELD_Y =   "force_y";
    public static final String FIELD_Z =   "force_z";

    @SyncanoField(name = FIELD_LAT)
    public float latitude;

    @SyncanoField(name = FIELD_LNG)
    public float longitutde;

    @SyncanoField(name = FIELD_ALT)
    public float altitude;

    @SyncanoField(name = FIELD_X)
    public float force_x;

    @SyncanoField(name = FIELD_Y)
    public float force_y;

    @SyncanoField(name = FIELD_Z)
    public float force_z;


}
