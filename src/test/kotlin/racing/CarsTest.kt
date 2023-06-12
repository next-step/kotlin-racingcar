package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.domain.Cars
import racing.domain.RandomNumberForwardCondition

class CarsTest {

    @Test
    fun `n 개 car를 생성한다`() {
        // given
        val carCount = 5

        // when
        val cars = Cars.of(carCount, RandomNumberForwardCondition())

        // then
        assertThat(cars.race().size).isEqualTo(carCount)
    }
}
