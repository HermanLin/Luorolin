public class Character {

    //========================
    //===Instance Variables===
    //========================
    protected int HP;
    protected String name;
    protected int condition;


    //==================
    //===Constructors===
    //==================
    public Character() {
	HP = 100;
	condition = 0;
    }
    public Character(String x) {
	this();
	name = x;
    }

    //=============
    //===Methods===
    //=============
    public boolean isAlive() {
	if  (HP > 0)
	    return true;
	else
	    return false;
    }
    public boolean isSick() {
	if (condition > 0)
	    return true;
	else
	    return false;
    }
    
    public String getName() {
	return name;
    }
    public void setName( String input ) {
	name = input;
    }
    
    public int getCondition() {
	return condition;
    }
    public void setCondition( int input ) {
	condition = input;
    }
    
    public int getHP() {
	return HP;
    }
    public void setHP( int input ) {
	HP = input;
    }
    public void addHP( int input ) {
	HP += input;
    }
    public void subHP( int input ) {
	HP -= input;
    }
}
