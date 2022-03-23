package com.user.service.entityService;

import com.general.service.BaseEntityService;
import com.user.dao.UserDao;
import com.user.entity.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserEntityService extends BaseEntityService<User, UserDao> {

    public UserEntityService(UserDao dao) {
        super(dao);
    }
}
