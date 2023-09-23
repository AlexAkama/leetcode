package students;

import java.util.UUID;

public class IdGenerator {

    public static void main(String[] args) {
        System.out.println(getUUID());
    }

    private static UUID getUUID() {
        return UUID.randomUUID();
    }

}
