package OOM;

import java.util.ArrayList;
import java.util.List;

/**
 * -XX:MetaspaceSize=5M -XX:MaxMetaspaceSize=5M
 * Created by Charley on 2017/6/24.
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();

        int i = 0;
        while (true) {

            list.add(String.valueOf(i++).intern());
        }

    }
}
