package com.vangbacdaquy.interceptor;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.util.TextParseUtil;

public class AuthInterceptor implements Interceptor {

	private static final long serialVersionUID = -5011962009065225959L;

	public static final String roleSessionField = "role";
	private Map<String, Set> roleActions = Collections.EMPTY_MAP;
	private static final String AuthorizationRequiredResult = "404";
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		final String actionName = invocation.getProxy().getActionName();
		final String namespace = invocation.getProxy().getNamespace();
		System.out.println("namespace: " + namespace);
		
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		
		Object userRole = session.get(AuthInterceptor.roleSessionField);
        System.err.println("userRole: " + userRole);
		if(userRole == null){
			return "directToLogin";
		}
		if(hasSufficientRole(userRole, actionName, namespace)) {
			return invocation.invoke();
        }
		
		return AuthorizationRequiredResult;
		
	}

	public void setRoleActions(String roleActionsParam) {
		StringTokenizer roleActionsParamTokenizer = new StringTokenizer(roleActionsParam,";");
		this.roleActions=new HashMap<String, Set>(roleActionsParamTokenizer.countTokens());
		
		while(roleActionsParamTokenizer.hasMoreTokens()) {
			String roleActionArray[] = roleActionsParamTokenizer.nextToken().trim().split(":");
			
			if(roleActionArray.length == 2) {
				String role = roleActionArray[0].toLowerCase();
				Set actions = TextParseUtil.commaDelimitedStringToSet(roleActionArray[1]);
				this.roleActions.put(role,actions);
			}
		}
	}
	
	public boolean hasSufficientRole(Object userRole, String actionName, String namespace) {	
		System.out.println("roleAction: "+ roleActions);
		System.out.println("userRole: " + userRole);		
		
		if(roleActions.containsKey("*") && roleActions.get("*").contains(actionName))
			return true;
		
		if(userRole !=null && userRole instanceof String) {
			String userRoleString = ((String)userRole).toLowerCase();
			
			if(roleActions.containsKey(userRoleString) && 
					roleActions.get(userRoleString).contains(namespace))
				return true;
		}
		
		return false;
	}
	
	public String getRoleSessionField() {
		return roleSessionField;
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
}
