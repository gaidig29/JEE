package fr.formation.etudiant.ihm.login;

public class LoginModel {
	private String login = "";
	private String pass = "";
	private String message = "";

	public LoginModel() {
	}

	public LoginModel(String login, String pass, String message) {
		super();
		this.login = login;
		this.pass = pass;
		this.message = message;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "LoginModel [login=" + login + ", pass=" + pass + ", message=" + message + "]";
	}

}
