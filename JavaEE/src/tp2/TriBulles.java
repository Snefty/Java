package tp2;

public class TriBulles {
	
	public void trierABulle(int[] tab) {
		
		int tmp = tab[0];
		int n = tab.length;
		
		for(int idx=0; idx <tab.length; idx++) {
			for(int i=0; i<n-1; i++) {
				if(tab[i] > tab[i+1]) {
					tmp = tab[i];
					tab[i] = tab[i+1];
					tab[i+1] = tmp;
				}
			}
			n--;
		}
	}
	
	public void afficherTableau(int[] tab) {
		for(int i=0; i<tab.length ;i++) {
			System.out.print("["+tab[i] + "]");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		TriBulles tr = new TriBulles();
		int[] tab = new int[] {3, 4, 7, 5, 3, 2, 1, 22, 34,23,2};
		tr.afficherTableau(tab);
		tr.trierABulle(tab);
		tr.afficherTableau(tab);
	}
	
}
