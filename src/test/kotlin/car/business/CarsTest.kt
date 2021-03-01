package car.business

import car.energy.EnergyProvider
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarsTest() {
    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `랜덤값이 4 미만일경우 움직이면은 안된다`(rand: Int) {
        // given
        val cars = Cars(amount = 5, energyProvider = createEnergyProvider(rand))
        // when
        val count = cars.move()
        // then
        assertThat(count).isEqualTo(0)
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `랜덤값이 4 이상일경우 움직이면 된다`(rand: Int) {
        // given
        val amount = 5
        val cars = Cars(amount, energyProvider = createEnergyProvider(rand))
        // when
        val count = cars.move()
        // then
        assertThat(count).isEqualTo(amount)
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun `움직인 만큼 position이 변경이 되어야 한다`(tryCount: Int) {
        // given
        val maxRand = 9

        val cars = Cars(amount = 5, energyProvider = createEnergyProvider(maxRand))

        // when
        for (i in 0 until tryCount) {
            cars.move()
        }

        // then
        assertThat(cars.getPositions())
            .allMatch { it == tryCount }
    }

    private fun createEnergyProvider(nextInt: Int): EnergyProvider {
        return object : EnergyProvider {
            override fun getEnergy(): Int {
                return nextInt
            }
        }
    }
}
