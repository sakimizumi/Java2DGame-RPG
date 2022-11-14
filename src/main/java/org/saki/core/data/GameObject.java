package org.saki.core.data;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GameObject {
    public String tag = "";
    public GameObject(){
        objects.add(this);
    }



    private static HashSet<GameObject> objects = new HashSet<>();

    /**
     * get the Set of GameObject value 'tag'
     * @param tag
     * @return
     */
    public static Set<GameObject> FindGameObjectsWithTag(String tag){
        return  objects.stream().filter(object -> object.tag == tag).collect(Collectors.toSet());
    }

    /**
     * get the first element value 'tag'
     *
     * @param tag
     * @return
     */
    public static GameObject FindGameObjectWithTag(String tag){
        return  objects.stream().filter(object -> object.tag == tag).findFirst().orElse(null);
    }
}
