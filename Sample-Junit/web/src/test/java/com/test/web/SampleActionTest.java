package com.test.web;

import org.apache.struts2.StrutsTestCase;
import org.junit.Test;

import com.user.action.UserAction;
import com.opensymphony.xwork2.ActionProxy;

public class SampleActionTest extends StrutsTestCase {

	@Test
	public void testActionSuccess() throws Exception {

		request.setParameter("name", "Raj");
		request.setParameter("address", "raj123");

		ActionProxy actionProxy = getActionProxy("/useraction");
		UserAction userAction = (UserAction) actionProxy.getAction();
		String result = actionProxy.execute();
		String userActionMethod = userAction.show();

		assertEquals("success", userActionMethod);
	}

	@Test
	public void testActionFail() throws Exception {

		request.setParameter("name", "");
		request.setParameter("address", "Kumar");

		ActionProxy actionProxy = getActionProxy("/useraction");
		UserAction userAction = (UserAction) actionProxy.getAction();
		String result = actionProxy.execute();
		String userActionMethod = userAction.show();

		assertEquals("error", userActionMethod);
	}

	@Test(expected = NullPointerException.class)
	public void testActionException() throws Exception {

		request.setAttribute("name", null);
		request.setAttribute("address", "kumar123");

		ActionProxy actionProxy = getActionProxy("/useraction");
		UserAction userAction = (UserAction) actionProxy.getAction();

		assertEquals(null, userAction.getName());
	}
}
