package org.example.app.repositories;

import jakarta.persistence.Query;
import org.example.app.entities.User;
import org.example.app.utils.Constants;
import org.example.app.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class UserCreateRepository {

    @SuppressWarnings("deprecation")
    public String createUser(User user) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Транзакция стартует
            transaction = session.beginTransaction();

            String hql = "INSERT INTO User (userName, login, phone, pass, email, birthDate) " +
                    "VALUES (:userName, :login, :phone, :pass, :email, :birthDate)";

            Query query = session.createQuery(hql);
            query.setParameter("userName", user.getUserName());
            query.setParameter("login", user.getLogin());
            query.setParameter("phone", user.getPhone());
            query.setParameter("birthDate", user.getBirthDate());
            query.setParameter("pass", user.getPassword());
            query.setParameter("email", user.getEmail());
            query.executeUpdate();

            // Транзакция выполняется
            transaction.commit();
            return Constants.DATA_INSERT_MSG;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return e.getMessage();
        }
    }
}
