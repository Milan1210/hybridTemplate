package com.gerniks.app.utility;

import java.net.HttpURLConnection;
import java.net.URL;

public class ManageLinks {

    public String redirectURL(String path){
        return new GenericFunctions().fileRead("file","url").concat(path);
    }

    public void verifyLinkConnection(String link){
        try {
            URL url = new URL(link);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
            httpURLConnection.setConnectTimeout(3000);
            httpURLConnection.connect();
            if (httpURLConnection.getResponseCode()>399){
                throw new AssertionError("The link "+link+" has broken");
            }
        }catch (Exception e){

        }
    }
}
