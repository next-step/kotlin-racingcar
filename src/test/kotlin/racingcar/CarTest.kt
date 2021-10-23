package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @ParameterizedTest
    @ValueSource(strings = ["Car1", "Car2", "car", "Car"])
    fun `길이 제한 이하 길이의 이름 정상 주입 확인`(carName: String) {
        val testCar = Car(4, carName)
        assertThat(testCar.carName).isEqualTo(carName)
    }

    @Test
    fun `길이 제한 초과 길이의 이름 입력시 오류 발생 확인`() {
        assertThatIllegalArgumentException().isThrownBy { Car(4, "lengthOver") }
            .withMessage(ExceptionType.CAR_NAME_LIMIT_LENGTH_OVER)
    }

    @Test
    fun `Car 이동시 거리값 변경 확인`() {
        val testCar = Car(4)
        val movedDistance = testCar.run {
            move(4)
            getMovedDistance()
        }
        assertThat(movedDistance).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `불가능한 이동 값 입력`(wrongValue: Int) {
        val car = Car(4)
        assertThat(car.isMoveAble(wrongValue)).isFalse
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `이동 가능한 값 입력`(moveAbleValue: Int) {
        val car = Car(4)
        assertThat(car.isMoveAble(moveAbleValue)).isTrue
    }
}
