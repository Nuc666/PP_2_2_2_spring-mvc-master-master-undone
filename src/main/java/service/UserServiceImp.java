package service;

import dao.UserDao;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImp implements service.UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Override
   public void editUser(User modifiedUser, Long id) {
      userDao.editUser(modifiedUser, id);
   }

   @Override
   public void deleteUser(User user) {
      userDao.deleteUser(user);
   }

   @Override
   public User getUser(Long id) {
     return userDao.getUser(id);
   }


}
