package study.carracing

import carracing.domain.Cars
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {

    @Test
    fun makeCarsTest() {
        assertThat(Cars.of(3).size).isEqualTo(3)
    }
}
