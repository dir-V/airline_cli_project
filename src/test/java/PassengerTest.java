import jdk.jfr.StackTrace;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PassengerTest {

Passenger passenger;

@BeforeEach
    public void setUp(){
    passenger = new Passenger("Johnny", "078812456", 123);
}

@Test
    public void canGetID(){
    assertThat(passenger.getId()).isEqualTo(123);

}

    @Test
    public void canGetName() {
    assertThat(passenger.getName()).isEqualTo("Johnny");
    }

    @Test
    public void canGetContactInfo(){
    assertThat(passenger.getContactInfo()).isEqualTo("078812456");
    }
}
