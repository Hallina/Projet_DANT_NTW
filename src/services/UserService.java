package services;
import Models.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.*;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class UserService {
    @PersistenceContext
    private EntityManager em;

    public List<User> getAll(){
        TypedQuery<User> query = (TypedQuery<User>) em.createQuery("select u from User u");
        return query.getResultList();

    }

}
