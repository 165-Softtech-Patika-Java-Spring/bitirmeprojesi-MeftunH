package com.FinalProject.FinalProject.user.service.entityService;

import com.FinalProject.FinalProject.general.service.BaseEntityService;
import com.FinalProject.FinalProject.user.dao.UserDao;
import com.FinalProject.FinalProject.user.entity.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserEntityService extends BaseEntityService<User, UserDao> {

    public UserEntityService(UserDao dao) {
        super(dao);
    }
    public User getUserByUsername(String username){
        return this.getDao().findByUserName(username);
    }
}
