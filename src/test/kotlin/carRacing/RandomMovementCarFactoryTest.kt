package carRacing

import carRacing.domain.Car
import carRacing.serviceimpl.RandomMovementCarFactory
import carRacing.serviceimpl.RandomMovementController
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RandomMovementCarFactoryTest {

    private val randomMovementCarFactory: RandomMovementCarFactory = RandomMovementCarFactory()

    @ParameterizedTest
    @CsvSource("1,1", "2,2", "3,3")
    fun `createCars 로 넘긴 Int 값 만큼 자동차가 존재하는 List를 반환한다`(carCount: Int, expected: Int) {
        val result: List<Car> = randomMovementCarFactory.createCars(carCount)

        assertThat(result).hasSize(expected)
    }

    @Test
    fun `생성된 자동차는 모두 position 1에 위치한다`() {
        val carCount: Int = 3
        val result: List<Car> = randomMovementCarFactory.createCars(carCount)

        assertThat(result).allMatch { it.position == 1 }
    }

    @Test
    fun `RandomMovementCarFactory 는 RandomMovementController 를 사용한다`() {
        val carCount: Int = 1
        val result: List<Car> = randomMovementCarFactory.createCars(carCount)

        assertThat(result).allMatch { it.movementController is RandomMovementController }
    }
}
