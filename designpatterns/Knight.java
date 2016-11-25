import java.util.*;

public class Knight extends Character{

	public Knight(){
		super(new SwordBehavior());
	}

	public Knight(WeaponBehavior weapon){
		super(weapon);
	}

	@Override
	public void fight(){
		super.fight();
	}
}