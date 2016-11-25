import java.util.*;

public class Troll extends Character{

	public Troll(){
		super(new AxeBehavior());
	}

	public Troll(WeaponBehavior weapon){
		super(weapon);
	}

	@Override
	public void fight(){
		super.fight();
	}
}