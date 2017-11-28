/**
 * Author: ������
 * Date: 2015-04-21
 * Time: 13:58
 * Declaration: All Rights Reserved !!!
 */
//����ģʽ    http://wuchong.me/blog/2014/08/28/how-to-correctly-write-singleton-pattern/  д�ķǳ���
public class Test02 {

    /**
     * ����ģʽ������ʽ���̰߳�ȫ
     * ����  --  һ��������ʵ������������û��ʹ�õĻ������е��˷���Դ��
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
     * ����ģʽ������ʽ���̲߳���ȫ
     * ���� -- ʵ���ڿ�ʼʱΪ�գ���һ�μ��غ��ʵ����  �ɽ�ԼһЩ��Դ�����ڲ���ʱ�п��ܳ��ֶ������
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
     * ����ģʽ������ʽ���̰߳�ȫ�����̻߳�����Ч�ʲ���
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
     * ����ģʽ����ʽ�����֣��̰߳�ȫ
     *
     * static Ӧ������ ����Singleton4��ʱ��ͼ����� , �����Ҿ��û��Ƕ���ģʽ��
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
     * ����ģʽ������ʽ��ʹ�þ�̬�ڲ��࣬�̰߳�ȫ���Ƽ���
     * ������������ڲ��� SingletonPatterHolder �ľ�̬���� singletonPattern��
     * ���������������Ҫ���Ǹ����������ⲿ�� SingletonPattern �Ķ��󣬾����Ǹ�������Ҫ��Ψһ�Ķ���

     �����ǵ��� SingletonPattern.getInstance() ʱ���ڲ��� SingletonPatternHolder �Ż��ʼ����
     ��̬���� singletonPattern ������������
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
     * ��̬�ڲ��࣬ʹ��ö�ٷ�ʽ���̰߳�ȫ���Ƽ���
     */
//    public enum Singleton6 {
//        INSTANCE;
//
//    }

    /**
     * ��̬�ڲ��࣬ʹ��˫��У�������̰߳�ȫ���Ƽ���
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
