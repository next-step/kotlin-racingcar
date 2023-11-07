package game.racing.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CarTest {
    @ParameterizedTest
    @ValueSource(strings = ["", "123456"])
    fun `자동차 이름은 1글자 이상 5글자 이하만 가능하다`(name: String) {
        Assertions.assertThatThrownBy { Car(name) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(Car.NOT_VALID_CAR_NAME_MESSAGE)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `4보다 작으면 자동차는 이동하지 않는다`(speed: Int) {
        val car = Car("TEST")
        car.moveOrStayBySpeed(speed)

        Assertions.assertThat(car.position).isEqualTo(Car.MIN_POSITION)
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `4보다 크거나 같으면 자동차는 이동한다`(speed: Int) {
        val car = Car("TEST")
        car.moveOrStayBySpeed(speed)

        Assertions.assertThat(car.position).isEqualTo(Car.MIN_POSITION + 1)
    }
}
