package org.saki.core.tile;

import org.saki.Main;
import org.saki.core.widget.IView;
import org.saki.game.Const;

import java.awt.*;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Arrays;

public class Map {
    public static final byte MAP_NAME_SIZE = 20;
    public static final byte MAP_WIDTH_INDEX = 20;
    public static final byte MAP_HEIGHT_INDEX = 21;
    public static final byte MAP_LAYER_INDEX = 22;
    //20个byte 是地图名字
    private byte[] originData;
    private byte[] name;
    /**
     * map width
     */
    private byte width = 1;
    /**
     * map height
     */
    private byte height = 1;
    /**
     * Map layer
     */
    private byte layer = 1;
    /**
     * Map real data contain
     */
    private byte[] mapData;
    public String getName(){
        return new String(name);
    }

    /**
     * 设置地图名字
     * @param mapName
     */
    public void setName(String mapName){
        if(mapName.length() > 20){
            throw new RuntimeException("Map name too long");
        }
        name = mapName.getBytes();
    }
    public Map(){

    }
    public Map(byte[] data){
        this.originData = data;
        this.decodeData();
    }



    public Map(String name){
        try {
            InputStream stream = Main.class.getResourceAsStream("map/"+name);
            if(stream != null){
                this.originData = stream.readAllBytes();
                stream.close();
                this.decodeData();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private void decodeData() {
        this.name = Arrays.copyOfRange(this.originData,0,MAP_NAME_SIZE);
        this.width = this.originData[MAP_WIDTH_INDEX];
        this.height = this.originData[MAP_HEIGHT_INDEX];
        this.layer = this.originData[MAP_LAYER_INDEX];
        this.mapData = Arrays.copyOfRange(this.originData,MAP_LAYER_INDEX + 1,this.originData.length - 1);
    }

    private byte[] encodeData(){
        byte[] result = new byte[MAP_NAME_SIZE + 3 + mapData.length];
        System.arraycopy(name, 0, result, 0, name.length );
        result[MAP_NAME_SIZE] = this.width;
        result[MAP_NAME_SIZE + 1] = this.height;
        result[MAP_NAME_SIZE + 2] = this.layer;
        System.arraycopy(mapData, 0, result, MAP_NAME_SIZE + 3, mapData.length);
        return result;
    }
    public void saveMap(){
        byte[] bytes = encodeData();
        File file = new File("asda.map");
        try(FileOutputStream stream = new FileOutputStream(file)){
            stream.write(bytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void emptyMap(String name,byte width,byte height,byte layer){
        this.setName(name);
        this.width = width;
        this.height = height;
        this.layer = layer;
        this.mapData = new byte[this.width * this.height * this.layer];
    }

    public byte getWidth() {
        return width;
    }

    public byte getHeight() {
        return height;
    }

    public byte[] getMapData() {
        return mapData;
    }

    public byte getLayer() {
        return layer;
    }
}
