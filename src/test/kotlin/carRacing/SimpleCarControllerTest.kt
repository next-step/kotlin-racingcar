package carRacing

import carRacing.domain.Car
import carRacing.serviceimpl.SimpleCarController
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class SimpleCarControllerTest {

    private val simpleCarController: SimpleCarController = SimpleCarController()

    @ParameterizedTest
    @CsvSource("1", "2", "3")
    fun `createCars 로 넘긴 Int 값 만큼 자동차가 존재하는 List를 반환한다`(carCount: Int) {
        val result: List<Car> = simpleCarController.createCars(carCount)

        assertThat(result).hasSize(carCount)
    }

    @Test
    fun `생성된 자동차는 모두 position 1에 위치한다`() {
        val carCount: Int = 3
        val result: List<Car> = simpleCarController.createCars(carCount)

        assertThat(result).allMatch { it.position == 1 }
    }
}
