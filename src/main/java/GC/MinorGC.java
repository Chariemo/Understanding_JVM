package GC;

/**
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 * Created by Charley on 2017/6/26.
 */
public class MinorGC {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {

        byte[] allo1, allo2, allo3, allo4;
//        allo1 = new byte[2 * _1MB];
//        allo2 = new byte[2 * _1MB];
//        allo3 = new byte[2 * _1MB];
        allo4 = new byte[9 * _1MB];
    }
}
