package navigation;

public class Bicycle implements Transport {
	@Override
	public void adjustRoute() {
		System.out.println("Adjusting route for bike...");
	}
}
