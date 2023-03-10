package com.onyshkiv.service.impl;

import com.onyshkiv.DAO.DAOException;
import com.onyshkiv.DAO.EntityTransaction;
import com.onyshkiv.DAO.impl.PublicationDAO;
import com.onyshkiv.DAO.impl.UserDAO;
import com.onyshkiv.entity.User;
import com.onyshkiv.service.IUserService;
import com.onyshkiv.service.ServiceExcpetion;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Optional;

public class UserService implements IUserService {
    final static Logger logger = LogManager.getLogger(UserService.class);
    private UserDAO userDAO;
    private final EntityTransaction entityTransaction;

    private static UserService instance;

    public static synchronized UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    private UserService() {
        userDAO = UserDAO.getInstance();
        entityTransaction = new EntityTransaction();
    }

    @Override
    public Optional<User> findUserByLogin(String login) throws ServiceExcpetion {
        Optional<User> optional;
        entityTransaction.init(userDAO);

        try {
            optional = userDAO.findEntityById(login);
        } catch (DAOException e) {
            //log
            throw new ServiceExcpetion(e);
        } finally {
            entityTransaction.end(userDAO);
        }
        return optional;
    }

    @Override
    public List<User> findAllUsers() throws ServiceExcpetion {
        List<User> list;
        entityTransaction.init(userDAO);

        try {
            list = userDAO.findAll();
        } catch (DAOException e) {
            //log
            throw new ServiceExcpetion(e);
        } finally {
            entityTransaction.end(userDAO);
        }
        return list;
    }

    @Override
    public void createUser(User user) throws ServiceExcpetion {
        entityTransaction.init(userDAO);
        try {
            userDAO.create(user);
        } catch (DAOException e) {
            //log
            throw new ServiceExcpetion(e);
        } finally {
            entityTransaction.end(userDAO);
        }
    }

    @Override
    public void updateUser(User user) throws ServiceExcpetion {
        entityTransaction.init(userDAO);
        try {
            userDAO.update(user);
        } catch (DAOException e) {
            //log
            throw new ServiceExcpetion(e);
        } finally {
            entityTransaction.end(userDAO);
        }
    }

    @Override
    public void deleteUser(User user) throws ServiceExcpetion {
        entityTransaction.init(userDAO);
        try {
            userDAO.delete(user);
        } catch (DAOException e) {
            //log
            throw new ServiceExcpetion(e);
        } finally {
            entityTransaction.end(userDAO);
        }
    }

    @Override
    public void changeUserPassword(User user) throws ServiceExcpetion {
        entityTransaction.init(userDAO);
        try {
            userDAO.changePassword(user);
        } catch (DAOException e) {
            //log
            throw new ServiceExcpetion(e);
        } finally {
            entityTransaction.end(userDAO);
        }
    }
}
