package com.vuclip.model;

import java.io.Serializable;

/**
 * @author Ashish Mishra
 * 10-Sep-2016
 */

public class UserVO  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String userHeaderIP;
	String userRemoteIP;
	public String getUserHeaderIP() {
		return userHeaderIP;
	}
	public void setUserHeaderIP(String userHeaderIP) {
		this.userHeaderIP = userHeaderIP;
	}
	public String getUserRemoteIP() {
		return userRemoteIP;
	}
	public void setUserRemoteIP(String userRepoteIP) {
		this.userRemoteIP = userRepoteIP;
	}

	

}
