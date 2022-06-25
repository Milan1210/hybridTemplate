package com.gerniks.app.utility;

public class LinkManage {

    public String redirectURL(String path){
        return new GenericFunctions().fileRead("file","url").concat(path);
    }
}
