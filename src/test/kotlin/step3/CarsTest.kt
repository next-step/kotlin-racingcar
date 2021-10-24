package step3

import org.junit.jupiter.api.Test
import step3.ui.Input
import step3.ui.Output
import java.util.InputMismatchException

class CarsTest {

    @Test
    fun `자동차 대수 Input Test`() {
        org.assertj.core.api.Assertions.assertThatThrownBy { Cars(Input.getCountOfCar()) }
            .isInstanceOf(InputMismatchException::class.java)
    }

    @Test
    fun `시도할 횟수 Input Test`() {
        org.assertj.core.api.Assertions.assertThatThrownBy { Round(Input.getNumberOfRound()) }
            .isInstanceOf(InputMismatchException::class.java)
    }

    @Test
    fun `전진하는 조건 테스트#1 - 0~9 사이의 distance 값인지`() {
        val distance = Car().distance.calculate()
        val isSuccess = distance in 0..9
        org.junit.jupiter.api.Assertions.assertTrue(isSuccess)
        org.junit.jupiter.api.Assertions.assertFalse(!isSuccess)
    }

    @Test
    fun `전진하는 조건 테스트#2 - distance 가 4이상일 경우만 전진하는지`() {
        val car = Car()
        car.move()
        val isForward = car.distance.calculate() > 4
        when {
            isForward -> {
                org.junit.jupiter.api.Assertions.assertTrue(isForward)
                org.assertj.core.api.Assertions.assertThat(car.forward).isEqualTo(car.forward.plus(1))
            }
            else -> {
                org.junit.jupiter.api.Assertions.assertFalse(isForward)
                org.assertj.core.api.Assertions.assertThat(car.forward).isEqualTo(car.forward)
            }
        }
    }

    @Test
    fun `전진한만큼 원하는 outPut이 출력되었는지`() {
        val car = Car()
        car.move()

        val isForward = car.distance.calculate() > 4
        when {
            isForward -> {
                org.assertj.core.api.Assertions.assertThat(
                    Output.printForward(car)
                ).isEqualTo("-")
            }
            else -> {
                org.assertj.core.api.Assertions.assertThat(
                    Output.printCar(car)
                ).isEqualTo("")
            }
        }
    }
}
