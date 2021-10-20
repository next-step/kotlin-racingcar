package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racingcar.car.Car

class CarTest {

    private lateinit var car: Car

    @BeforeEach
    fun setUpCar() {
        car = Car()
    }

    @ParameterizedTest(name = "Test {index}: value == {0} result == {1}")
    @CsvSource(value = ["1, 1", "2, 2", "3, 3"])
    fun `Car move() 후에 position 테스트`(move: Int, expected: Int) {
        car.move(move)
        assertThat(car.getPosition()).isEqualTo(expected)
    }

    @ParameterizedTest(name = "Test {index}: value == {0} result == {1}")
    @CsvSource(value = ["1, -", "2, --", "3, ---"])
    fun `Car move() 후에 toString() 테스트`(move: Int, expected: String) {
        car.move(move)
        assertThat(car.toString()).isEqualTo(expected)
    }
}
