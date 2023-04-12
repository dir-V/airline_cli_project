import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FlightTest {

        Flight flight;

        @BeforeEach
        public void setUp(){
            flight = new Flight(3231, "UAE");
        }

        @Test
        public void canGetID(){
            assertThat(flight.getId()).isEqualTo(3231);
        }

        @Test
    public void canGetDestination(){
            assertThat(flight.getDestination()).isEqualTo("UAE");
        }
}
