package entity;

public class housejingli {
	String AgentID;
	String AgentName;
	String AgentAddress;
	String Phone;
	String password;
	public housejingli (String agentID, String agentName, String agentAddress, String phone) {
		super();
		AgentID = agentID;
		AgentName = agentName;
		AgentAddress = agentAddress;
		Phone = phone;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public housejingli (String agentID, String password) {
		super();
		AgentID = agentID;
		this.password = password;
	}

	public String getAgentID() {
		return AgentID;
	}
	public void setAgentID(String agentID) {
		AgentID = agentID;
	}
	public String getAgentName() {
		return AgentName;
	}
	public void setAgentName(String agentName) {
		AgentName = agentName;
	}
	public String getAgentAddress() {
		return AgentAddress;
	}
	public void setAgentAddress(String agentAddress) {
		AgentAddress = agentAddress;
	}
	public String getPhone() {
		return Phone;
	}
	public void setPhone(String phone) {
		Phone = phone;
	}
	
}
