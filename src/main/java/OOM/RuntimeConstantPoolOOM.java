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

     /*  String str1 = new StringBuilder("计算机").append("软件").toString();
       System.out.println(str1.intern() == str1);

       String str2 = new StringBuilder("java").toString();
        System.out.println(str2.intern() == str2);*/

    }
}
