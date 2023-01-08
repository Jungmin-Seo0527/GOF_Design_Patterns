package singleton;

/**
 * 싱글톤 패턴 구현 방법4<br>
 * double checked locking으로 효율적인 동기화 블럭 만들기
 */
public class Settings4 {

    private static volatile Settings4 instance;

    public static Settings4 getInstance() {
        if (instance == null) {
            synchronized (Settings4.class) {
                if (instance == null) {
                    instance = new Settings4();
                }
            }
        }
        return instance;
    }
}
