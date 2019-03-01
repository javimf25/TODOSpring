package org.udg.pds.springtodo.controller;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.udg.pds.springtodo.controller.exceptions.ControllerException;
import org.udg.pds.springtodo.entity.Group;
import org.udg.pds.springtodo.entity.IdObject;
import org.udg.pds.springtodo.serializer.JsonDateDeserializer;
import org.udg.pds.springtodo.service.GroupService;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;

@RequestMapping(path="/group")
@Controller
public class UserGroupController extends BaseController{

    @PostMapping(consumes = "application/json")
    @ResponseBody
    public IdObject addGroup(HttpSession session, @Valid @RequestBody UserGroupController.R_Group Group) {

        Long userId = getLoggedUser(session);


        if (Group.name == null) {
            throw new ControllerException("No text supplied");
        }
        if (Group.description == null) {
            throw new ControllerException("No creation date supplied");
        }

        return GroupService.addGroup(Group.name, userId, Group.description);
    }

    static class R_Group {

        @NotNull
        public String name;

        @NotNull
        public String description;
    }

}
