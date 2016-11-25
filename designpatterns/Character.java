package designpatterns;
import java.util.*;

public abstract class Character{
	private WeaponBehavior weapon;

	public Character(WeaponBehavior weapon){
		setWeapon(weapon);
	}

	public void setWeapon(WeaponBehavior weapon){
		this.weapon = weapon;
	}

	public void fight(){
		weapon.useWeapon();
	}
}
