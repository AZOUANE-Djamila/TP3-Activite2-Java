package tp3_Activite2;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Scanner;

public class main {
	
	private static final String DECIMAL_FORMAT = "###,###.#";


	public static void main(String[] args) {
		
	    Scanner sc = new Scanner(System.in);  // Create a Scanner object

        DecimalFormat format = new DecimalFormat("###,##0.00");// Définir le format du chiffre

        DecimalFormatSymbols customSymbol = new DecimalFormatSymbols();
        customSymbol.setGroupingSeparator(' ');
        format.setDecimalFormatSymbols(customSymbol); // Personnaliser le séparateur dans le format défini
        
	    System.out.println("Bonjour, veuillez introduire un montant hors-taxes qui va être avec le séparateur décimal ");

	    float mht = 0;
	    try{
	    	//Seuls les nombre décimal qui seront acceptés
	    	while(!sc.hasNextFloat()) 
	    		{
	    		System.out.println("Veuillez introduire un nombre décimal exemple : 12,22");
	    		sc.nextLine();
	    		}
	    	mht=sc.nextFloat();
	    	System.out.println("Le montant hors taxe est : "+mht);
	    	}
		catch(Exception e1){
			System.out.println("Ceci n'est pas un nombre décimal");
		}
	    
		
	   // Calculer le Montant TVA = TVA * 100 / t = HT 
	    // Exemple taux tva = 9%
	    float mtva = mht * 9/100;
	  //Formater le Montant TVA
	    BigDecimal mtv_f = new BigDecimal(mtva);
	    System.out.println("Montant tva = HT * t /100 = " +format.format(mtv_f)+"\n");
	   
	    //Calculer le TTC = HT + HT * t / 100
	    float ttc = mht + mht * 9/100;
	    
	    //Formater le TTC
        BigDecimal ttc_f = new BigDecimal(ttc);
        System.out.print("TTC = "+format.format(ttc_f));
	}

}
