package designpatterns;
import java.util.*;

public class KnifeBehavior implements WeaponBehavior{
	@Override
	public void useWeapon(){
		System.out.println("Whook");
	}
}
