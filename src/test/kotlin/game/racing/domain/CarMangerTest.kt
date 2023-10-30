package game.racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CarMangerTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun `인자 숫자만큼 자동차를 생성한다`(numberOfCar: Int) {
        val carManager = CarManger()

        carManager.generateCarByNumberOfCar(numberOfCar)

        assertThat(carManager.cars.size).isEqualTo(numberOfCar)
    }
}
