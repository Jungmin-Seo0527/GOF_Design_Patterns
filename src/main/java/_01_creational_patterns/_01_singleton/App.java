package _01_creational_patterns._01_singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class App {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        // 싱글톤 패턴 구현 깨트리는 방법1 -> 리플레션
        Settings5 settings51 = Settings5.getInstance();

        Constructor<Settings5> declaredConstructor = Settings5.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Settings5 settings52 = declaredConstructor.newInstance();
        System.out.println("리플렉션 사용: " + (settings51 == settings52));

        // 싱글톤 패턴 구현 깨트리는 방법2 -> 직렬화 & 역직렬화
        Settings5 settings53 = Settings5.getInstance();
        Settings5 settings54 = null;
        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("settings53.obj"))) {
            out.writeObject(settings53);
        }
        try (ObjectInput in = new ObjectInputStream(new FileInputStream("settings53.obj"))) {
            settings54 = (Settings5) in.readObject();
        }
        System.out.println("직렬화 역직렬화로 싱글톤 패턴 깨트리기");
        System.out.println(settings53 == settings54);

        Settings6 settings61 = Settings6.INSTANCE;
        Settings6 settings62 = null;
        Constructor<?>[] declaredConstructors = Settings6.class.getDeclaredConstructors();
        for (Constructor<?> constructor : declaredConstructors) {
            constructor.setAccessible(true);
            // settings62 = (Settings6) constructor.newInstance("INSTANCE");
        }
        System.out.println("ENUM으로 리플랙션 구현으로도 싱글톤 패턴 유지");
        System.out.println(settings61.equals(settings62));

        Settings6 settings63 = Settings6.INSTANCE;
        Settings6 settings64 = null;
        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("settings63.obj"))) {
            out.writeObject(settings63);
        }
        try (ObjectInput in = new ObjectInputStream(new FileInputStream("settings63.obj"))) {
            settings64 = (Settings6) in.readObject();
        }

        System.out.println("ENUM으로 직렬화 역직렬화에도 싱글톤 유지");
        System.out.println(settings63 == settings64);

    }
}
