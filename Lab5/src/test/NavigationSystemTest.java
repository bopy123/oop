package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import navigation.NavigationSystem;
import navigation.Map;
import navigation.SchematicMap;
import navigation.RouteStrategy;
import navigation.FastestRouteStrategy;
import navigation.CheapestRouteStrategy;
import navigation.ShortestRouteStrategy;
import navigation.Transport;
import navigation.Car;
import navigation.Bicycle;

class NavigationSystemTest {

	@Test
	void testNavigationSystemTest() {
		NavigationSystem navigationSystem = new NavigationSystem(new SchematicMap(), new FastestRoute(), new Bike());
		assertDoesNotThrow(navigationSystem::navigate);
	}

}
