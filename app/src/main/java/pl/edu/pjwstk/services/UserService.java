package pl.edu.pjwstk.services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import pl.edu.pjwstk.entities.User;
import pl.edu.pjwstk.exceptions.EntityAlreadyExist;
import pl.edu.pjwstk.repositories.UserRepository;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final EntityManager entityManager;

    public UserService(UserRepository userRepository, EntityManager entityManager) {
        this.userRepository = userRepository;
        this.entityManager = entityManager;
    }
    public void createUser(String username, String password){
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            if (checkIfUserNameExist(username)) {
                throw new EntityAlreadyExist("This username is taken");
            }
            User user = new User(username, password);
            entityManager.persist(user);
            transaction.commit();
        } catch (Exception e){
            if(transaction != null && transaction.isActive()){
                transaction.rollback();
            }
            throw e;
        }
    }
    private boolean checkIfUserNameExist(String username){
        if(userRepository.findByUsername(username).isPresent()){
            return true;
        }else{
            return false;
        }
    }
}
