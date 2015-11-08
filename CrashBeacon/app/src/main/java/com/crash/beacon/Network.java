package com.crash.beacon;

import android.os.AsyncTask;
import android.util.Log;

import com.syncano.library.Syncano;
import com.syncano.library.api.Response;

import java.util.List;

/**
 * Created by Tienvo on 11/8/2015.
 */
public class Network extends AsyncTask<String, Void, String> {
    Book b;
    Syncano syn;
    public Network(Book book, Syncano syncano){
        this.b = book;
        this.syn = syncano;
    }
    @Override
    protected String doInBackground(String... params) {
       //Response<Book> responseCreateObject = syn.createObject(b).send();
        Log.d("code", String.valueOf(Response.CODE_SUCCESS));
        Response<List<Book>> responseGetBooks = syn.createObject(b).send();
        return "Executed";
    }
}
