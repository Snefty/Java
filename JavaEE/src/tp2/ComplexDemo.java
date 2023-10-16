package tp2;

public class ComplexDemo {
	
	public static void main(String[] args) {
		Complexe cpl1 = new Complexe(2.0, 3.0);
		Complexe cpl2 = new Complexe(4.0, 2.0);
		System.out.println(cpl1.toString());
		System.out.println(cpl2.toString());
		
		LibComplex libc = new LibComplex();
		
		System.out.println("Module nombre complexe 1 : " + libc.moduleNombreComplex(cpl1));
		System.out.println("Module nombre complexe 2 : " + libc.moduleNombreComplex(cpl2));
		
		System.out.println("Argument du nombre complexe 1 : " + libc.argumentNombreComplex(cpl1));
		System.out.println("Argument du nombre complexe 2 : " + libc.argumentNombreComplex(cpl2));
		
		Complexe cpl3 = libc.sommeNombresComplex(cpl1, cpl2);
		System.out.println("Somme deux nombres complexe : " + cpl3.toString());
		
		Complexe cpl4 = libc.multiplicationNombresComplex(cpl1, cpl2);
		System.out.println("Multiplication deux nombres complexe : " + cpl4.toString());
	}
	
}
