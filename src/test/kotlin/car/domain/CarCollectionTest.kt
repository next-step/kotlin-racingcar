package car.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarCollectionTest() {
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `랜덤값이 4 미만일경우 움직이면은 안된다`(rand: Int) {
        // given

        val carNames = CarNameCollection(arrayOf("오", "길", "환"))
        val cars = CarCollection(carNameCollection = carNames, movableStrategy = crateEnergyMovableStrategy(rand))

        // when
        cars.move(times = 5)

        // then
        val carList = cars.cars

        assertThat(carList)
            .allMatch { it.currentPosition == 0 }
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `랜덤값이 4 이상일경우 움직이면 된다`(rand: Int) {
        // given
        var times = 5
        val carNames = CarNameCollection(arrayOf("오", "길", "환"))
        val cars = CarCollection(carNameCollection = carNames, movableStrategy = crateEnergyMovableStrategy(rand))

        // when
        cars.move(times)

        // then
        val carList = cars.cars

        assertThat(carList)
            .allMatch { it.currentPosition == times }
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun `움직인 만큼 position이 변경이 되어야 한다`(times: Int) {
        // given
        val maxRand = 9
        val carNames = CarNameCollection(arrayOf("오", "길", "환"))

        val cars = CarCollection(carNameCollection = carNames, movableStrategy = crateEnergyMovableStrategy(maxRand))

        // when
        cars.move(times)

        // then
        val carList = cars.cars

        assertThat(carList)
            .allMatch { it.currentPosition == times }
    }

    private fun crateEnergyMovableStrategy(nextInt: Int): MovableStrategy {
        val energyProvider = object : EnergyProvider {
            override val energy: Int
                get() = nextInt
        }
        return EnergyRandomMovableStrategy(energyProvider)
    }
}
