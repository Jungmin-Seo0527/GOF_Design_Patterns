package singleton;

import java.util.Set;

public class App {

    public static void main(String[] args) {

        // 싱글톤 패턴 구현 방법1
        Settings1 settings11 = Settings1.getInstance();
        Settings1 settings12 = Settings1.getInstance();
        System.out.println(settings11 == settings12);

        //싱글톤 패턴 구현 방법2
        Settings2 settings21 = Settings2.getInstance();
        Settings2 settings22 = Settings2.getInstance();
        System.out.println(settings21 == settings22);
        
    }
}
