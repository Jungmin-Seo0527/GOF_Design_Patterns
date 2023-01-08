package singleton;

/**
 * 싱글톤 패턴 구현 방법5<br>
 * static inner 클래스를 사용하는 방법
 */
public class Settings5 {

    private static class SettingsHolder {
        private static final Settings5 SETTINGS_5 = new Settings5();
    }

    public static Settings5 getInstance() {
        return SettingsHolder.SETTINGS_5;
    }
}
