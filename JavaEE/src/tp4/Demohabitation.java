package tp4;

public class Demohabitation {
	
	public static void main(String[] args) {
		Habitation[] commune = new Habitation[5];
		
		commune[0] = new HabitationIndividuelle("Stan","245 rue mimo", 20, 4, false);
		commune[1] = new HabitationIndividuelle("Smith","246 rue mimo", 35, 6, true);
		commune[2] = new HabitationIndividuelle("Julie","146 rue chedar", 24, 5, false);
		commune[3] = new HabitationIndividuelle("Stan","245 rue mimo", 20, 4, true);
		commune[4] = new HabitationProfessionnelle("Kevin", "624 avenue gouda", 351, 43);
		
		for(int i = 0; i<commune.length ;i++) {
			commune[i].affiche();
			System.out.println("\nSon impot est de : " + commune[i].impot());
			System.out.println();
		}
		
	}
	
}
