package com.gerniks.app.utility;

public class RedirectionLinks {

    public String redirectURL(String path){
        return new GenericFunctions().fileRead("file","url").concat(path);
    }
}
