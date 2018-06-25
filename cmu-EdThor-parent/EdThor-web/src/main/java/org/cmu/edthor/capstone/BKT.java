package org.cmu.edthor.capstone;

import java.util.ArrayList;


public class BKT {

	private ArrayList<Double> L = new ArrayList<Double>();
	private final double L0 = 0.3;
	private final double G = 0.1;
	private final double S = 0.1;
	private final double T = 0.1;
	
	public BKT() {
		L.add(L0);
	}
	
	public void setL(ArrayList L){
		this.L = L;
	}
	
	public ArrayList getL() {
		return L;
	}
	
	public ArrayList computePKnown(int[] o) {
		
		for(int i = 0; i < o.length;i++) {
			double p;
			double tempL = L.get(i);
			if(o[i] == 1){
				p = (tempL * (1-S))/(tempL * (1-S) + (1 - tempL) * G);			
			}
			else{
				p = (tempL * S)/(tempL * S + (1 - tempL) * (1 - G));
			}

			double newL = p + (1-p) * T;
			L.add(newL);
		}
		return L;
	}
	
}
