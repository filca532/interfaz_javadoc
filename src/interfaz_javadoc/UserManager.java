package interfaz_javadoc;

import java.util.ArrayList;

public class UserManager {
    private ArrayList<User> users;

    public UserManager() {
        users =  new ArrayList<>();
    }

    public void addUsers(String username, String password) {
        users.add(new User(username, password));
    }

    public boolean validateUsers(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }
}
