package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarsTest {

    @Test
    fun `자동차들 생성에 성공한다`() {
        val cars = Cars()
        cars.addCar(createCar())
        cars.addCar(createCar())
        cars.addCar(createCar())

        assertThat(cars.cars).hasSize(3)
            .flatExtracting({ it.position })
            .containsExactly(0L, 0L, 0L)
    }

    @Test
    fun `자동차들 전진에 성공한다`() {
        val cars = Cars()
        cars.addCar(createCar())
        cars.addCar(createCar())
        cars.addCar(createCar())

        cars.move()

        assertThat(cars.cars).hasSize(3)
            .flatExtracting({ it.position })
            .containsExactly(1L, 1L, 1L)
    }

    private fun createCar(): Car {
        return Car(TrueEngine, CarName("Bear"))
    }
}
