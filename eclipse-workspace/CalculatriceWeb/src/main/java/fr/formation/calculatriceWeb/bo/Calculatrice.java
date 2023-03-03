package fr.formation.calculatriceWeb.bo;

public class Calculatrice {

	private Integer a;
	private Integer b;
	private String op;
	public Integer getA() {
		return a;
	}
	public void setA(Integer a) {
		this.a = a;
	}
	public Integer getB() {
		return b;
	}
	public void setB(Integer b) {
		this.b = b;
	}
	public String getOp() {
		return op;
	}
	public void setOp(String op) {
		this.op = op;
	}
	public Calculatrice(Integer a, Integer b, String op) {
		super();
		this.a = a;
		this.b = b;
		this.op = op;
	}


}
