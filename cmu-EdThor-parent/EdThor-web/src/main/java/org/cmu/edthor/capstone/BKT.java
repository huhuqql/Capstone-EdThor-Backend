package org.cmu.edthor.capstone;

import java.util.ArrayList;


public class BKT {

	private ArrayList<Double> L = new ArrayList<Double>();
	private double L0;
	private double G = 0.2;
	private double S = 0.2;
	private double T = 0.1;
	
	public BKT(int kc) {
		if(kc == 1){
			L0 = 0.3;

		}
		else if(kc == 2){
			L0 = 0.3;

		}
		else if(kc == 3){
			L0 = 0.15;

		}
		else if(kc == 4){
			L0 = 0.15;

		}
		else if(kc == 5){
			L0 = 0.3;

		}
		else if(kc == 6){
			L0 = 0.3;

		}
		else if(kc == 7){
			L0 = 0.3;

		}

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
