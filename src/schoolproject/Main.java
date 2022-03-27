package schoolproject;


import schoolproject.dao.DaoFactory;

import schoolproject.dao.impl.DaoFactoryImpl;

import schoolproject.dao.rolerepositories.UserRepository;

import schoolproject.model.roles.User;


public class Main {
    public static void main(String[] args) {
        DaoFactory daoFactory=new DaoFactoryImpl();
        UserRepository<User> ur=daoFactory.createUserRepository();


    }
}

