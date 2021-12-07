package com.company.controller.command.common;

import com.company.exception.ServiceException;
import com.company.controller.command.Command;
import com.company.controller.command.CommandResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StartPageCommand implements Command {

    private static final String LOGIN_PAGE = "/index.jsp";

    @Override
    public CommandResult execute(HttpServletRequest request, HttpServletResponse response) throws ServiceException {
        return CommandResult.forward(LOGIN_PAGE);
    }
}
