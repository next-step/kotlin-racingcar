package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.RacingCarFactory.makeCars

class RacingCarFactoryTest {

    @Test
    fun `makeCar test`() {
        val carCnt = makeCars(10).size
        assertThat(carCnt).isEqualTo(10)
    }
}
