package org.example.app.views;

import org.example.app.entities.User;

import java.sql.Date;
import java.util.Scanner;

public class UserCreateView {

    public User getData() {

        Scanner scanner = new Scanner(System.in);
        User user = new User();

        // Ввод и санитизация данных.
        // Санитизация через trim().

        String title = "Enter user name: ";
        System.out.print(title);
        user.setUserName(scanner.nextLine().trim());

        title = "Enter login: ";
        System.out.print(title);
        user.setLogin(scanner.nextLine().trim());

        title = "Enter users phone in format xxx xxx-xxxx: ";
        System.out.print(title);
        user.setPhone(scanner.nextLine().trim());

        title = "Enter email in format example@mail.com: ";
        System.out.print(title);
        user.setEmail(scanner.nextLine().trim());

        title = "Enter password in format min 8 chars numbers and letters: ";
        System.out.print(title);
        user.setPassword(scanner.nextLine().trim());

        do {
            try {
                title = "Enter birthdate in format yyyy-mm-dd in range 1940 - 2005: ";
                System.out.print(title);
                user.setBirthDate(Date.valueOf(scanner.nextLine().trim()));
                return user;
            }
            catch (IllegalArgumentException e){
                System.out.println("Wrong date format, try again :)");
            }
        } while (true);

    }

    // Вывод уведомления
    public void getOutput(String output) {
        System.out.println(output);
    }
}
