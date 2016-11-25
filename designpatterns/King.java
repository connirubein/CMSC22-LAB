package designpatterns;
import java.util.*;

public class King extends Character{

	public King(){
		super(new KnifeBehavior());
	}

	public King(WeaponBehavior weapon){
		super(weapon);
	}

	@Override
	public void fight(){
		super.fight();
	}

	@Override
	public String toString(){
		return super.toString();
	}
}
