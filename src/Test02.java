/**
 * Author: 王俊超
 * Date: 2015-04-21
 * Time: 13:58
 * Declaration: All Rights Reserved !!!
 */
//单例模式    http://wuchong.me/blog/2014/08/28/how-to-correctly-write-singleton-pattern/  写的非常好
public class Test02 {

    /**
     * 单例模式，饿汉式，线程安全
     * 饿汉  --  一上来就先实例化，但若类没有使用的话，就有点浪费资源类
     */
    public static class Singleton {
        private final static Singleton instance = new Singleton();

        private Singleton() {

        }

        public static Singleton getInstance() {
            return instance;
        }
    }

    /**
     * 单例模式，饱汉式，线程不安全
     * 饱汉 -- 实例在开始时为空，第一次加载后才实例化  可节约一些资源，但在并发时有可能出现多个单例
     */
    public static class Singleton2 {
        private static Singleton2 instance = null;

        private Singleton2() {

        }

        public static Singleton2 getInstance() {
            if (instance == null) {
                instance = new Singleton2();
            }

            return instance;
        }
    }


    /**
     * 单例模式，饱汉式，线程安全，多线程环境下效率不高
     */
    public static class Singleton3 {
        private static Singleton3 instance = null;

        private Singleton3() {

        }

        public static synchronized Singleton3 getInstance() {
            if (instance == null) {
                instance = new Singleton3();
            }

            return instance;
        }
    }

    /**
     * 单例模式，汉式，变种，线程安全
     *
     * static 应该是在 加载Singleton4的时候就加载了 , 所以我觉得还是饿汉模式，
     */
    public static class Singleton4 {
        private static Singleton4 instance = null;

        static {
            instance = new Singleton4();
        }

        private Singleton4() {

        }

        public static Singleton4 getInstance() {
            return instance;
        }
    }

    /**
     * 单例模式，懒汉式，使用静态内部类，线程安全【推荐】
     * 在这个例子中内部类 SingletonPatterHolder 的静态变量 singletonPattern，
     * 这个变量是我们需要的那个单例，即外部类 SingletonPattern 的对象，就是那个我们需要的唯一的对象。

     当我们调用 SingletonPattern.getInstance() 时，内部类 SingletonPatternHolder 才会初始化，
     静态变量 singletonPattern 被创建出来。
     */
    public static class Singleton5 {
        private final static class SingletonHolder {
            private static final Singleton5 INSTANCE = new Singleton5();
        }

        private Singleton5() {

        }

        public static Singleton5 getInstance() {
            return SingletonHolder.INSTANCE;
        }
    }

    /**
     * 静态内部类，使用枚举方式，线程安全【推荐】
     */
//    public enum Singleton6 {
//        INSTANCE;
//
//    }

    /**
     * 静态内部类，使用双重校验锁，线程安全【推荐】
     */
    public static class Singleton7 {
        private volatile static Singleton7 instance = null;

        private Singleton7() {

        }

        public static Singleton7 getInstance() {
            if (instance == null) {
                synchronized (Singleton7.class) {
                    if (instance == null) {
                        instance = new Singleton7();
                    }
                }
            }

            return instance;
        }
    }

    public static void main(String[] args) {
        System.out.println(Test02.Singleton.getInstance() == Test02.Singleton.getInstance());
        System.out.println(Test02.Singleton2.getInstance() == Test02.Singleton2.getInstance());
        System.out.println(Test02.Singleton3.getInstance() == Test02.Singleton3.getInstance());
        System.out.println(Test02.Singleton4.getInstance() == Test02.Singleton4.getInstance());
        System.out.println(Test02.Singleton5.getInstance() == Test02.Singleton5.getInstance());
//        System.out.println(Singleton6.INSTANCE == Singleton6.INSTANCE);
        System.out.println(Singleton7.getInstance() == Singleton7.getInstance());
    }

}
