package org.saki.asset;

import org.saki.Main;

import java.io.InputStream;
import java.net.URL;

public abstract class Resource {
    public URL getResource(String name){
        URL url = Main.class.getResource(name);
        return url;
    }
}
