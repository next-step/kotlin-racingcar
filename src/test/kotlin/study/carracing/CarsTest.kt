package study.carracing

import carracing.domain.CarsFactory
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {

    @Test
    fun makeCarsTest() {
        assertThat(CarsFactory.of(3).size).isEqualTo(3)
    }
}
