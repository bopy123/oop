package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NavigationSystemTest {

	@Test
	void testNavigationSystemTest() {
		NavigationSystem navigationSystem = new NavigationSystem(new SchematicMap(), new FastestRoute(), new Bike());
		assertDoesNotThrow(navigationSystem::navigate);
	}

}
