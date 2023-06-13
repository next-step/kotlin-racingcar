package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {

    @Test
    fun `n 개 car를 생성한다`() {
        // given
        val carNames = listOf("car1", "car2")

        // when
        val cars = Cars.of(carNames, RandomNumberForwardCondition())

        // then
        assertThat(cars.size()).isEqualTo(carNames.size)
    }
}
