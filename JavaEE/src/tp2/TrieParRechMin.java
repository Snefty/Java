package tp2;

import java.util.Random;

public class TrieParRechMin {

	public int[] genTab(int max, int taille) {
		int[] tab = new int[taille];
		Random rand = new Random();
		for(int i =0; i<taille ;i++) {
			tab[i] = rand.nextInt(max);
		}
		return tab; 
	}

	public void trieParMin(int[] tab) {
		//int[] tabTrie = new int[tab.length];

		int minTab = 0;
		int indx = 0;
		
		for (int i = 0; i < tab.length - 1; i++)  
		{
			indx = i;  
			for (int j = i + 1; j < tab.length; j++)
			{
				System.out.println(i + " " + j);
				if (tab[j] < tab[indx]){ 
					indx = j;
				}
			}

			minTab = tab[indx];
			tab[indx] = tab[i]; 
			tab[i] = minTab;
		}
	}

	public void afficherTableau(int[] tab) {
		for(int i=0; i<tab.length ;i++) {
			System.out.print("["+tab[i] + "]");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		TrieParRechMin tr = new TrieParRechMin();
		int[] tab = tr.genTab(120,8);
		tr.afficherTableau(tab);
		tr.trieParMin(tab);
		tr.afficherTableau(tab);
	}

}
