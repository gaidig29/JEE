package fr.formation.calculatrice.bo;

public class Calcul {
	private Integer a;
	private Integer b;
	private String op;
	private Integer res;

	public Calcul() {
	}

	public Calcul(Integer a, Integer b, String op, Integer res) {
		super();
		this.a = a;
		this.b = b;
		this.op = op;
		this.res = res;
	}

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

	public Integer getRes() {
		return res;
	}

	public void setRes(Integer res) {
		this.res = res;
	}

	@Override
	public String toString() {
		return "Calcul [a=" + a + ", b=" + b + ", op=" + op + ", res=" + res + "]";
	}

}
