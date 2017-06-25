package OOM;

import java.util.ArrayList;
import java.util.List;

/**
 * -verbose:gc -Xms20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * Created by Charley on 2017/6/24.
 */
public class HeapOOM {

    static class OOMObject{

    }

    public static void main(String []args) {

        List<OOMObject> list = new ArrayList<OOMObject>();

        while (true) {

            list.add(new OOMObject());
        }
    }
}
