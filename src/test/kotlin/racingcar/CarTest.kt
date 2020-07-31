package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import racingcar.model.Car

class CarTest {

    @Test
    fun `자동차에 5글자 이상 이름 입력`() {
        assertThatIllegalArgumentException().isThrownBy {
            Car("abcdef")
        }
    }

    @Test
    fun `차가 전진한 경우`() {
        val car = Car("12345")
        car.move(4)
        assertThat(car.movingDistance).isEqualTo(1)
    }

    @Test
    fun `차가 전진하지 못한 경우`() {
        val car = Car("12345")
        car.move(3)
        assertThat(car.movingDistance).isEqualTo(0)
    }
}
