package org.example.app.services;

import org.example.app.entities.User;
import org.example.app.repositories.UserReadRepository;
import org.example.app.utils.Constants;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class UserReadService {

    UserReadRepository repository;

    public UserReadService(UserReadRepository repository) {
        this.repository = repository;
    }

    public String readUser() {

        // Получаем данные в коллекцию.
        List<User> list = repository.readUsers();

        // Если коллекция не null, формируем вывод.
        // Иначе уведомление об отсутствии данных.
        if (list != null) {
            // Если коллекция не пуста, формируем вывод.
            // Иначе уведомление об отсутствии данных.
            if (!list.isEmpty()) {
                AtomicInteger count = new AtomicInteger(0);
                StringBuilder stringBuilder = new StringBuilder();
                list.forEach((user) ->
                        stringBuilder.append(count.incrementAndGet())
                                .append(") id: ")
                                .append(user.getId())
                                .append(", ")
                                .append(user.getUserName())
                                .append(" ")
                                .append(user.getLogin())
                                .append(", ")
                                .append(user.getPassword())
                                .append(", ")
                                .append(user.getEmail())
                                .append(", ")
                                .append(user.getPhone())
                                .append(", ")
                                .append(user.getBirthDate())
                                .append("\n")
                );
                return "\n______ USERS ___________\n" + stringBuilder.toString();
            } else return Constants.DATA_ABSENT_MSG;
        } else return Constants.DATA_ABSENT_MSG;
    }
}
