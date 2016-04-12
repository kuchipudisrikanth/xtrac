package fidelity.xtrac.com.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Application {
	
	private Long appId;
	private String appName;
	private String appDesc;
	private String eMail;
	private String appSecretKey;
	
	public Application() {
	}

	public Application(Long appId, String appName, String appDesc, String eMail, String appSecretKey) {
		this.appId = appId;
		this.appName = appName;
		this.appDesc = appDesc;
		this.eMail = eMail;
		this.appSecretKey = appSecretKey;
	}

	public Long getAppId() {
		return appId;
	}

	public void setAppId(Long appId) {
		this.appId = appId;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getAppDesc() {
		return appDesc;
	}

	public void setAppDesc(String appDesc) {
		this.appDesc = appDesc;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getAppSecretKey() {
		return appSecretKey;
	}

	public void setAppSecretKey(String appSecretKey) {
		this.appSecretKey = appSecretKey;
	}
	
	

}
