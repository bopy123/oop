package navigation;

public class NavigationSystem {
	private Map map;
	private RouteStrategy route;
	private Transport transport;
	
	public NavigationSystem(Map map, RouteStrategy route, Transport transport) {
		this.map = map;
		this.route = route;
		this.transport = transport;
	}
	
	public void navigate() {
		map.showMap();
	}
}
