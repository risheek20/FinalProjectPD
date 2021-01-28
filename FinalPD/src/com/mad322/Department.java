package com.mad322;

public class Department {
	private int DEPT_ID;
	private String NAME;
	public int getDEPT_ID() {
		return DEPT_ID;
	}
	public void setDEPT_ID(int DEPT_ID) {
		this.DEPT_ID = DEPT_ID;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String NAME) {
		this.NAME = NAME;
	}
	
	@Override
	public String toString() {
		return "Employees [DEPT_ID=" + DEPT_ID + ", NAME=" + NAME +"]";
	}

}
