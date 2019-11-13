package br.com.badcompany.financiencia.myutils;

public class MessageStateProject {
	private String stateOfProject;
	private String dateOfSubmited;

	public MessageStateProject(String stateOfProject, String dateOfSubmited) {
		super();
		this.stateOfProject = stateOfProject;
		this.dateOfSubmited = dateOfSubmited;
	}

	public String getStateOfProject() {
		return stateOfProject;
	}

	public void setStateOfProject(String stateOfProject) {
		this.stateOfProject = stateOfProject;
	}

	public String getdateOfSubmited() {
		return dateOfSubmited;
	}

	public void setdateOfSubmited(String dateOfSubmited) {
		this.dateOfSubmited = dateOfSubmited;
	}
}
