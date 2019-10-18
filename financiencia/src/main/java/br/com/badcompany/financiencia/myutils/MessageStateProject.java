package br.com.badcompany.financiencia.myutils;

public class MessageStateProject {
	private String stateOfProject;
	private String dateOfEvaluate;

	public MessageStateProject(String stateOfProject, String dateOfEvaluate) {
		super();
		this.stateOfProject = stateOfProject;
		this.dateOfEvaluate = dateOfEvaluate;
	}

	public String getStateOfProject() {
		return stateOfProject;
	}

	public void setStateOfProject(String stateOfProject) {
		this.stateOfProject = stateOfProject;
	}

	public String getDateOfEvaluate() {
		return dateOfEvaluate;
	}

	public void setDateOfEvaluate(String dateOfEvaluate) {
		this.dateOfEvaluate = dateOfEvaluate;
	}
}
