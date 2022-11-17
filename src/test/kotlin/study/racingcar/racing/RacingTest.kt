package study.racingcar.racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import study.racingcar.car.CarFactory

internal class RacingTest {
    @Test
    fun `자동차가 전진만 한다면 전진한 값을 이름과 함께 반환한다`() {
        val generatorStub = AlwaysMoveGenerator()
        val cars = CarFactory.createCars(listOf("카니발", "아반떼"))
        val racing = Racing(cars, generatorStub)
        val expected = cars.map { car ->
            Record(car.name, car.currentLocation + 1)
        }

        assertThat(racing.round()).isEqualTo(expected)
    }

    @Test
    fun `자동차가 전진을 하지않는다면 값을 이름과 함께 반환한다`() {
        val generatorStub = AlwaysStopGenerator()
        val cars = CarFactory.createCars(listOf("카니발", "아반떼"))
        val racing = Racing(cars, generatorStub)
        val expected = cars.map { car ->
            Record(car.name, car.currentLocation)
        }

        assertThat(racing.round()).isEqualTo(expected)
    }
}
