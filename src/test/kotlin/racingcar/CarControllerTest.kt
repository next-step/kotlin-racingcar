package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class CarControllerTest {

    @ParameterizedTest
    @MethodSource("sampleCars")
    fun `우승자 조회 테스트`(cars: List<Car>) {
        // FIXME 테스트는 sampleCar로 진행하는데 Controller 객체 생성을 위하여 자동차 리스트 굳이 생성 필요함 추후 변경 필요
        val controller = CarController(listOf("cat", "dog", "lion"), 10)

        val winner = controller.getWinner(cars)
        assertThat(winner).contains(Car("coke", 10), Car("candy", 10))
    }

    @ParameterizedTest
    @MethodSource("sampleCars")
    fun `라운드 진행 테스트`(cars: List<Car>, numbers: List<Int>) {
        // FIXME 테스트는 sampleCar로 진행하는데 Controller 객체 생성을 위하여 자동차 리스트 굳이 생성 필요함 추후 변경 필요
        val controller = CarController(listOf("cat", "dog", "lion"), 10)

        controller.play(cars, numbers)

        // FIXME 테스트 결과 검증을 더 효율적으로 변경할 필요 있음
        assertThat(cars[0].equalsCurrentPosition(11))
        assertThat(cars[1].equalsCurrentPosition(8))
        assertThat(cars[2].equalsCurrentPosition(11))
        assertThat(cars[3].equalsCurrentPosition(6))
    }

    companion object {
        @JvmStatic
        fun sampleCars() = listOf<Arguments>(
            Arguments.of(
                listOf(
                    Car("candy", 10),
                    Car("pepci", 7),
                    Car("coke", 10),
                    Car("jelly", 5)
                ),
                listOf(5, 5, 5, 5)
            )
        )
    }
}
