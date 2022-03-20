package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User rsl = null;
        for (User user : users) {
            if (login.equals(user.getUsername())) {
                rsl = user;
            } else {
                throw new UserNotFoundException("User is not found");
            }
        }
        return rsl;
    }

    public static boolean validate(User user) throws UserInvalidException {
        boolean valid;
        String str = user.getUsername();
        if (user.isValid() && str.length() >= 3) {
            valid = true;
        } else {
            throw new UserInvalidException("User is not valid");
        }
        return valid;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            for (User user : users) {
                if (findUser(users, "Petr Arsentev") != null) {
                    validate(user);
                    System.out.println(user.getUsername());
                }
            }
        } catch (UserInvalidException ex) {
            ex.printStackTrace();
        } catch (UserNotFoundException exc) {
            exc.printStackTrace();
        }
    }
}