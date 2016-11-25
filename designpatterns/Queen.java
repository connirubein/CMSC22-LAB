package designpatterns;
import java.util.*;

public class Queen extends Character{

	public Queen(){
		super(new BowAndArrowBehavior());
	}

	public Queen(WeaponBehavior weapon){
		super(weapon);
	}

	@Override
	public void fight(){
		super.fight();
	}
}
