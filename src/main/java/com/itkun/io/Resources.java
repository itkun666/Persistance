package com.itkun.io;

import java.io.InputStream;

public class Resources {

    public static InputStream getResouceAsStream(String filePath){
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
