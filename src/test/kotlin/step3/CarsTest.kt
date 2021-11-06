package step3

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse
import org.assertj.core.api.Assertions.assertThat
import step3.ui.Input
import java.util.InputMismatchException

class CarsTest {

    @Test
    fun `자동차 대수 Input Test`() {
        assertThatThrownBy { Cars().makeCar(Input.getCountOfCar()) }
            .isInstanceOf(InputMismatchException::class.java)
    }

    @Test
    fun `시도할 횟수 Input Test`() {
        assertThatThrownBy { Round(Input.getNumberOfRound()) }
            .isInstanceOf(InputMismatchException::class.java)
    }

    @Test
    fun `전진하는 조건 테스트#1 - 0~9 사이의 distance 값인지`() {
        val distance = Car().distance.calculate()
        val isSuccess = distance in 0..9
        assertTrue(isSuccess)
    }

    @Test
    fun `전진하는 조건 테스트#2 - distance 가 4이상일 경우만 전진하는지`() {
        val car = Car()
        car.move()
        val isForward = car.distance.calculate() > 4
        when {
            isForward -> {
                assertTrue(isForward)
                assertThat(car.forward).isEqualTo(car.forward.plus(1))
            }
            else -> {
                assertFalse(isForward)
                assertThat(car.forward).isEqualTo(car.forward)
            }
        }
    }

    @Test
    fun `전진하는 조건 테스트#3 - 랜덤값이 4이상일 경우만 전진하는지`() {
        val car = Car().move(4)
        assertThat(car.forward).isEqualTo(1)
    }

    @Test
    fun `정지 조건 테스트#1 - 랜덤값이 4미만일 경우 정지 하는지`() {
        val car = Car().move(2)
        assertThat(car.forward).isEqualTo(0)
    }
}
