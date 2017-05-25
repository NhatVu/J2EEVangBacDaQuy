/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vangbacdaquy.action;

import com.opensymphony.xwork2.ActionContext;

public class LogoutAction extends AbstractAction {
    
	private static final long serialVersionUID = 1L;

	public LogoutAction() {
    }
    	
    public String execute() throws Exception {
        ActionContext.getContext().getSession().clear();
        return SUCCESS;
    }   
}
