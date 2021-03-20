package car.domain

import car.domain.move.AlwaysMovableStrategy
import car.domain.move.AlwaysNotMovableStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarsTest {
    @Test
    fun `movable이 false면은 자동차들은 움직이면 안된다`() {
        // given
        val carNames = CarNames(arrayOf("오", "길", "환"))
        val cars = Cars(carNames, AlwaysNotMovableStrategy())

        // when
        cars.move(5)

        // then
        assertThat(cars)
            .allMatch { it.position == 0 }
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun `movable이 true면, 차가 움직인 만큼 자동차들의 position이 변경이 되어야 한다`(times: Int) {
        // given
        val carNames = CarNames(arrayOf("오", "길", "환"))
        val cars = Cars(carNames, AlwaysMovableStrategy())

        // when
        cars.move(times)

        // then
        assertThat(cars)
            .allMatch { it.position == times }
    }
}
