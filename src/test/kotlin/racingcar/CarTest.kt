package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racingcar.car.Car
import racingcar.engine.CarEngine

class CarTest {

    private lateinit var car: Car

    @ParameterizedTest(name = "Test {index}: value == {0} result == {1}")
    @CsvSource(value = ["1, 1", "2, 2", "3, 3"])
    fun `Car move() 후에 position 테스트`(move: Int, expected: Int) {
        car = Car(carEngine = object : CarEngine { override fun execute(): Boolean = true })
        repeat(move) {
            car.movePosition()
        }
        assertThat(car.position).isEqualTo(expected)
    }

    @Test
    fun `Car 움직임 테스트`() {
        car = Car(carEngine = object : CarEngine { override fun execute(): Boolean = true })
        car.movePosition()
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `Car 움직이지 않음 테스트`() {
        car = Car(carEngine = object : CarEngine { override fun execute(): Boolean = false })
        car.movePosition()
        assertThat(car.position).isEqualTo(0)
    }
}
