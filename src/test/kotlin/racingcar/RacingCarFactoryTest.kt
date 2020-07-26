package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.RacingCarFactory.cars
import racingcar.RacingCarFactory.makeCar

class RacingCarFactoryTest {

    @Test
    fun `makeCar test`() {
        for (i in 0..9)
            makeCar()
        val carCnt = cars.size
        assertThat(carCnt).isEqualTo(10)
    }
}
