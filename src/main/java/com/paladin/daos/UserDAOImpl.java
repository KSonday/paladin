package com.paladin.daos;

import com.paladin.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by meghandow on 3/25/16.
 */

@Repository("userDAO")
@Transactional
public class UserDAOImpl extends AbstractDAO implements UserDAO {

    @Override
    public void save(Student s) {
        persist(s);
    }

}
