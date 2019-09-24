import ru.kuzin.Informer;

public class Main{
	public static void main(String args[]){
		Informer informer = new Informer();
		System.out.println(informer.getCurrentDate());
		System.out.println(informer.getCurrentDirectory());
		System.out.println(informer.getUsageNumber());
	}
}