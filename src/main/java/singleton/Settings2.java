package singleton;

/**
 * 싱글톤 패턴 구현 방법2<br>
 * 동기화를 사용해 멀티쓰레드 환경에 안전하게 만드는 방법
 */
public class Settings2 {

    private static Settings2 instance;

    private Settings2() {

    }

    public static synchronized Settings2 getInstance() {
        if (instance == null) {
            instance = new Settings2();
        }
        return instance;
    }
}
