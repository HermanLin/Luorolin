import cs1.Keyboard;

public class Trade {

    private static int itemIn;
    private static int itemOut;
    private static int emigrantWant;
    private static int emigrantTake;
    private static boolean canTrade;
    private static String tradeText;    

    public static int diffNum( int x ) {
	int rand = (int)( Math.random() * 5 ) + 1;
	while ( rand == x ) {
	    rand = (int)( Math.random() * 5 ) + 1;
	}
	return rand;
    }
    
    public static void trade() {
	itemIn = (int)( Math.random() * 5 ) + 1;
	itemOut = diffNum( itemIn );
	emigrantWant = 0;
	emigrantTake = 0;
	canTrade = true;
	tradeText = "An emmigrant wants ";

	System.out.println( Family.getSupplies() );
	if (itemIn == 5) {
	    emigrantWant = (int)((Math.random() * 3) + 1);
	    tradeText += emigrantWant + " tongues.\n";
	    if (Family.john.getTongues() < emigrantWant){
		canTrade = false;
	    }
	}
	else if (itemIn == 4){
	    emigrantWant = (int)((Math.random() * 3) + 1);
	    tradeText += emigrantWant + " axles.\n";
	    if (Family.john.getAxles() < emigrantWant){
		canTrade = false;
	    }
	}
	else if (itemIn == 3){
	    emigrantWant = (int)((Math.random() * 3) + 1);
	    tradeText += emigrantWant + " wheels.\n";
	    if (Family.john.getWheels() < emigrantWant){
		canTrade = false;
	    }
	}
        else if (itemIn == 2){
	    emigrantWant = (int)((Math.random() * 80) + 1);
	    tradeText += emigrantWant + " bullets.\n";
	    if (Family.john.getAmmo() < emigrantWant){
		canTrade = false;
	    }
	}
        else if (itemIn <= 1){
	    emigrantWant = (int)((Math.random() * 150) + 1);
	    tradeText += emigrantWant + " pounds of food.\n";
	    if (Family.john.getFood() < emigrantWant){
		canTrade = false;
	    }
	}
	
	if (canTrade) {
	    tradeText += "The immigrant is willing to trade you ";
	    if (itemOut == 5) {
		emigrantTake = (int)((Math.random() * 2) + 1);
		tradeText += emigrantTake + " tongues.\n";
	    }
	    else if (itemOut == 4){
		emigrantTake = (int)((Math.random() * 2) + 1);
		tradeText += emigrantTake + " axels.\n";
	    }
	    else if (itemOut == 3){
		emigrantTake = (int)((Math.random() * 2) + 1);
		tradeText += emigrantTake + " wheels.\n";
	    }
	    else if (itemOut == 2){
		emigrantTake = (int)((Math.random() * 75) + 1);
		tradeText += emigrantTake + " bullets.\n";
	    }
	    else if (itemOut <= 1){
		emigrantTake = (int)((Math.random() * 250) + 1);
		tradeText += emigrantTake + " pounds of food.\n";
	    }	    
	}
	System.out.println (tradeText);

	if (canTrade) {
	    System.out.println ("Are you willing to trade? ");
	    String decision = Keyboard.readString();
	    if (decision.equals( "no" ))
		return;
	    else if (decision.equals( "yes" )) {
		if (itemIn == 1) Family.john.subFood(emigrantWant);
		else if (itemIn == 2) Family.john.subAmmo(emigrantWant);
		else if (itemIn == 3) Family.john.subWheels(emigrantWant);
		else if (itemIn == 4) Family.john.subAxles(emigrantWant);
		else if (itemIn == 5) Family.john.subTongues(emigrantWant);

		if (itemOut == 1) Family.john.addFood(emigrantTake);
		else if (itemOut == 2) Family.john.addAmmo(emigrantTake);
		else if (itemOut == 3) Family.john.addWheels(emigrantTake);
		else if (itemOut == 4) Family.john.addAxles(emigrantTake);
		else if (itemOut == 5) Family.john.addTongues(emigrantTake);
	    }
	    else { System.out.println( "Invalid input" ); }
	}
	else { System.out.println( "You do not have enough supplies" ); }
    }
}
