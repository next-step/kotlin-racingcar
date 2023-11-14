package game.racing.domain

import game.racing.view.InputView
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

internal class CarFactoryTest {
    @ParameterizedTest
    @ValueSource(strings = ["TEST1", "TEST2", "TEST3"])
    fun `인자로 받은 이름을 가진 자동차를 생성한다`(carName: String) {
        val car = CarFactory.generateCarByCarNames(carName.split(InputView.CAR_NAME_DELIMITER))[0]

        Assertions.assertThat(car.name).isEqualTo(carName)
    }

    @ParameterizedTest
    @MethodSource("carNames")
    fun `자동차 이름 리스트를 통해 자동차들를 생성한다`(carNames: List<String>) {
        val cars = CarFactory.generateCarByCarNames(carNames)

        Assertions.assertThat(cars.size).isEqualTo(carNames.size)
    }

    companion object {
        @JvmStatic
        fun carNames() = listOf(
            listOf("TEST1", "TEST2", "TEST3"),
            listOf("TEST1", "TEST2", "TEST3", "TEST4")
        )
    }
}
