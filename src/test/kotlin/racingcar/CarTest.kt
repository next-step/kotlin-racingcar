package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {
    @ParameterizedTest
    @ValueSource(strings = ["Car1", "Car2", "car", "Car"])
    fun `길이 제한 5글자 이하의 이름이 정상적으로 입력되는지 확인한다`(carName: String) {
        val testCar = Car(4, carName)
        assertThat(testCar.carName).isEqualTo(carName)
    }

    @Test
    fun `길이 제한 5글자 초과의 이름 입력시 오류 발생 하는지 확인한다`() {
        val carName = "lengthOver"
        assertThatIllegalArgumentException().isThrownBy { Car(4, carName) }
            .withMessage("${ExceptionType.CAR_NAME_LIMIT_LENGTH_OVER} ($carName)")
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `Car 무작위로 입력된 값이 4이상일 경우 전진한다`(randomSelectedValue: Int) {
        val testCar = Car(4)
        val movedDistance = testCar.run {
            move(randomSelectedValue)
            movedDistance
        }
        assertThat(movedDistance).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `이동 불가능한 4미만의 값이 입력 되었을 경우 False가 반환된다`(wrongValue: Int) {
        val car = Car(4)
        assertThat(car.isMoveAble(wrongValue)).isFalse
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `이동 가능한 4이상의 값이 입력 되었을 경우 True가 반환된다`(moveAbleValue: Int) {
        val car = Car(4)
        assertThat(car.isMoveAble(moveAbleValue)).isTrue
    }
}
