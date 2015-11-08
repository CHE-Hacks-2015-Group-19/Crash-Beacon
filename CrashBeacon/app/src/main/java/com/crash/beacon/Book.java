package com.crash.beacon;

import com.syncano.library.annotation.SyncanoClass;
import com.syncano.library.annotation.SyncanoField;
import com.syncano.library.data.SyncanoObject;
/**
 * Created by tom on 11/7/15.
 */
@SyncanoClass(name = "book")
public class Book extends SyncanoObject{
    public static final String FIELD_LAT = "latitude";
    public static final String FIELD_LNG = "longitide";
    public static final String FIELD_ALT = "altitude";
    public static final String FIELD_X =   "force_x";
    public static final String FIELD_Y =   "force_y";
    public static final String FIELD_Z =   "force_Z";

    @SyncanoField(name = FIELD_LAT)
    public float lat;

    @SyncanoField(name = FIELD_LNG)
    public float lng;

    @SyncanoField(name = FIELD_ALT)
    public float alt;

    @SyncanoField(name = FIELD_X)
    public float fX;

    @SyncanoField(name = FIELD_Y)
    public float fY;

    @SyncanoField(name = FIELD_Z)
    public float fZ;


}
