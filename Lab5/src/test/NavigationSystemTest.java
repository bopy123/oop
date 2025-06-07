package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import navigation.NavigationSystem;
import navigation.Map;
import navigation.SchematicMap;
import navigation.RouteStrategy;
import navigation.SatelliteMap;
import navigation.FastestRouteStrategy;
import navigation.CheapestRouteStrategy;
import navigation.ShortestRouteStrategy;
import navigation.Transport;
import navigation.Car;
import navigation.Bicycle;

class NavigationSystemTest {

	@Test
	void testNavigationSystemFastest() {
		NavigationSystem navigationSystem1 = new NavigationSystem(new SchematicMap(), new FastestRouteStrategy(), new Bicycle());
		assertDoesNotThrow(navigationSystem1::navigate);
	}
	
	@Test
	void testNavigationSystemCheapest() {
		NavigationSystem navigationSystem2 = new NavigationSystem(new SatelliteMap(), new CheapestRouteStrategy(), new Car());
		assertDoesNotThrow(navigationSystem2::navigate);
	}

}
