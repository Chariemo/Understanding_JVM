package GC;

import java.util.concurrent.TimeUnit;

/**
 * Self-salvation when GC
 * Created by Charley on 2017/6/25.
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {

        System.out.println("I am still alive");
    }

    @Override
    /*应尽量避免使用这个方法*/
    protected void finalize() throws Throwable {

        super.finalize();
        System.out.println("finalize method executed!");

        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {

        SAVE_HOOK = new FinalizeEscapeGC();

        /*对象第一次拯救自己*/
        SAVE_HOOK = null;
        System.gc();
        TimeUnit.MILLISECONDS.sleep(500);
        if (SAVE_HOOK != null) {

            SAVE_HOOK.isAlive();
        }
        else {
            System.out.println("I am dead!");
        }

        /*第二次自我拯救失败 任何对象的finalize()只会被系统自动调用一次*/
        SAVE_HOOK = null;
        System.gc();
        TimeUnit.MILLISECONDS.sleep(500);
        if (SAVE_HOOK != null) {

            SAVE_HOOK.isAlive();
        }
        else {
            System.out.println("I am dead!");
        }
    }
}
