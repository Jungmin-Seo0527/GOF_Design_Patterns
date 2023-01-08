package singleton;

/**
 * 싱글톤 패턴 구현 방법1<br>
 * private 생성자에 static 메소드
 */
public class Settings1 {

    private static Settings1 instance;

    private Settings1() {
    }

    public static Settings1 getInstance() {
        if (instance == null) {
            instance = new Settings1();
        }
        return instance;
    }
}
