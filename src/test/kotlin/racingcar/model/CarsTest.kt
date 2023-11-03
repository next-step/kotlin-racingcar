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

    @Test
    fun `우승자를 찾는다`() {
        val cars = Cars()
        val carName1 = CarName("Bear")
        val carName2 = CarName("Tiger")
        val carName3 = CarName("Lion")

        cars.addCar(Car(TrueEngine, carName1))
        cars.addCar(Car(TrueEngine, carName2))
        cars.addCar(Car(TrueEngine, carName3))

        cars.move()
        cars.move()
        cars.move()

        val winners = cars.findWinners()
        assertThat(winners).hasSize(3)
            .flatExtracting({ it.carName })
            .containsExactly(carName1, carName2, carName3)
    }

    private fun createCar(): Car {
        return Car(TrueEngine, CarName("Bear"))
    }
}
