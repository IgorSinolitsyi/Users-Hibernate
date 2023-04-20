package org.example.app.entities;

import jakarta.persistence.*;

import java.sql.Date;

// Класс-модель объекта, который является записью в БД.
// Набор переменных (свойств объекта) соответствует
// столбцам в таблице БД.
//
// @Entity
// Указывает, что класс является сущностью.
//
// @Table(name = "users")
// Указывает таблицу в БД, с которой сопоставлен этот объект.
@Entity
@Table(name = "users")
public class User {

    // @Id
    // Определяет первичный ключ объекта.
    //
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Для автоматического генерирования значения первичного ключа.
    // Определяет стратегии генерации значений первичных ключей.
    // GenerationType.IDENTITY указывает, что первичные ключи для сущности
    // должны назначаться, используя столбец идентификации в БД.
    // Они автоматически увеличиваются.
    //
    // @Column(name = "id")
    // Указывает на сопоставление столбцов в БД.
    // Атрибут name используется для указания имени столбца таблицы.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    // Здесь, наименование столбца в БД
    // не совпадает с наименованием переменной.
    // Атрибут name решает эту проблему.
    @Column(name = "user_name")
    private String userName;

    @Column(name = "login")
    private String login;

    @Column(name = "phone")
    private String phone;
    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "pass")
    private String pass;

    @Column(name = "email")
    private String email;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassword() {
        return pass;
    }

    public void setPassword(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(int id, String userName, String login, String phone, Date birthDate, String pass, String email) {
        this.id = id;
        this.userName = userName;
        this.login = login;
        this.phone = phone;
        this.birthDate = birthDate;
        this.pass = pass;
        this.email = email;
    }
}
