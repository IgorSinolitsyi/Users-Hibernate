package org.example.app.repositories;

import jakarta.persistence.Query;
import org.example.app.entities.User;
import org.example.app.utils.Constants;
import org.example.app.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserUpdateRepository {

    @SuppressWarnings("deprecation")
    public String updateUser(User app_user) {

        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Транзакция стартует
            transaction = session.beginTransaction();

            String hql = "UPDATE User SET phone = :phone WHERE id = :id";
            Query query = session.createQuery(hql);
            query.setParameter("phone", app_user.getPhone());
            query.setParameter("id", app_user.getId());
            query.executeUpdate();
            // Транзакция выполняется
            transaction.commit();
            return Constants.DATA_UPDATE_MSG;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            return e.getMessage();
        }
    }
}
