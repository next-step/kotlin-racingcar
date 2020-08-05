package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CarTest {

    private lateinit var car: Car

    @BeforeEach
    fun setup() {
        car = Car("12345", 0)
    }

    @Test
    fun `자동차 이름이 5글자를 초과한 경우`() {
        assertThatIllegalArgumentException().isThrownBy {
            Car("abcdef", 0)
        }
    }

    @Test
    fun `차가 전진한 경우`() {
        car.move(4)

        assertThat(car.movingDistance).isEqualTo(1)
    }

    @Test
    fun `차가 전진하지 못한 경우`() {
        car.move(3)

        assertThat(car.movingDistance).isEqualTo(0)
    }
}
