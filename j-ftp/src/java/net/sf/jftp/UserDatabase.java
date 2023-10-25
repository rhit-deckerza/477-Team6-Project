import java.util.HashMap;
import java.util.Map;

public class UserDatabase {
    private static Map<String, User> users = new HashMap<>();

    static {
        users.put("admin", new User("admin", "admin_password", AccessLevel.ADMIN));
        users.put("user", new User("user", "admin_password", AccessLevel.USER));
        users.put("guest", new User("guest", "admin_password", AccessLevel.USER));
    }

    public static User getUser(String username) {
        return users.get(username);
    }
}

