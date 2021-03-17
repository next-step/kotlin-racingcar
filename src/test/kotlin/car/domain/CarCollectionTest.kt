package car.domain

import car.domain.move.AlwaysMovableStrategy
import car.domain.move.AlwaysNotMovableStrategy
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarCollectionTest() {
    @Test
    fun `movable이 false면은 자동차들은 움직이면 안된다`() {
        // given

        val carNames = CarNameCollection(arrayOf("오", "길", "환"))
        val cars = CarCollection(carNameCollection = carNames, movableStrategy = AlwaysNotMovableStrategy())

        // when
        cars.move(times = 5)

        // then
        val carList = cars.cars

        assertThat(carList)
            .allMatch { it.currentPosition == 0 }
    }

    @Test
    fun `movable이 true면은 자동차들은 움직여도 된다`() {
        // given
        var times = 5
        val carNames = CarNameCollection(arrayOf("오", "길", "환"))
        val cars = CarCollection(carNameCollection = carNames, movableStrategy = AlwaysMovableStrategy())

        // when
        cars.move(times)

        // then
        val carList = cars.cars

        assertThat(carList)
            .allMatch { it.currentPosition == times }
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun `움직인 만큼 자동차들의 position이 변경이 되어야 한다`(times: Int) {
        // given
        val carNames = CarNameCollection(arrayOf("오", "길", "환"))

        val cars = CarCollection(carNameCollection = carNames, movableStrategy = AlwaysMovableStrategy())

        // when
        cars.move(times)

        // then
        val carList = cars.cars

        assertThat(carList)
            .allMatch { it.currentPosition == times }
    }
}
