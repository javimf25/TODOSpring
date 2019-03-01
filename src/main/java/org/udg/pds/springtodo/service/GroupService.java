package org.udg.pds.springtodo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.udg.pds.springtodo.controller.exceptions.ServiceException;
import org.udg.pds.springtodo.entity.Group;
import org.udg.pds.springtodo.entity.IdObject;
import org.udg.pds.springtodo.entity.Task;
import org.udg.pds.springtodo.entity.User;
import org.udg.pds.springtodo.repository.GroupRepository;
import org.udg.pds.springtodo.service.UserService;
import java.util.Date;
import java.util.Optional;

@Service
public class GroupService {

    @Transactional
    public IdObject addGroup(String name, Long GroupId,
                            String description) {
        try {
            Group group = GroupService.getGroup(GroupId);

            Task task = new Task(created, limit, false, text);

            task.setUser(user);

            user.addTask(task);

            GroupRepository.save(task);
            return new IdObject(task.getId());
        } catch (Exception ex) {
            // Very important: if you want that an exception reaches the EJB caller, you have to throw an ServiceException
            // We catch the normal exception and then transform it in a ServiceException
            throw new ServiceException(ex.getMessage());
        }
    }

    public static Group getGroup(Long id) {
        Optional<User> uo = GroupRepository.findById(id);
        if (uo.isPresent())
            return uo.get();
        else
            throw new ServiceException(String.format("Group with id = % dos not exists", id));
    }
}
