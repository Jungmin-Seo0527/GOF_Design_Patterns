package singleton;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;

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
        System.out.println(settings53 == settings54);
    }
}
