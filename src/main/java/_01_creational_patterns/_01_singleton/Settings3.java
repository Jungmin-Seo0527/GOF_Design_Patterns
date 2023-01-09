package _01_creational_patterns._01_singleton;

/**
 * 싱글톤 패턴 구현 방법3<br>
 * 이른 초기화 (eager initialization)을 사용하는 방법
 */
public class Settings3 {

    private static final Settings3 INSTANCE = new Settings3();

    private Settings3() {

    }

    public static Settings3 getInstance() {
        return INSTANCE;
    }
}
