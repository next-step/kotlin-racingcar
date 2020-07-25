package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CarTest {
    private lateinit var car: Car

    @BeforeEach
    fun setUp() {
        car = Car("javajigi")
    }

    @Test
    fun move() {
        assertThat(car.move(CAR_MOVE_CRITERIA)).isEqualTo(Car("javajigi", 1))
    }

    @Test
    fun stop() {
        assertThat(car.move(3)).isEqualTo(Car("javajigi", 0))
    }

    @Test
    fun toString_in_Car() {
        val car = Car("javajigi", 5)
        assertThat(car.toString()).isEqualTo("javajigi : -----")
    }
}
