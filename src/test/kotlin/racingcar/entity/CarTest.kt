package racingcar.entity

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.common.ExceptionCode

class CarTest {
    @DisplayName(value = "들어온 숫자만큼 car를 움직인다")
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5])
    fun moveCar(num: Int) {
        val car = Car("test")
        car.move(num)
        assertThat(car.distance).isEqualTo("-".repeat(num + 1))
    }

    @ParameterizedTest
    @DisplayName("car의 이름이 5글자 이상이면 에러를 낸다")
    @ValueSource(strings = ["test123", "long_name"])
    fun namedCarIsNotExceedLengthCarName(input: String) {
        Assertions.assertThatThrownBy {
            Car(input)
        }.isInstanceOf(ExceptionCode.NotExceedLengthCarName::class.java)
    }
}
