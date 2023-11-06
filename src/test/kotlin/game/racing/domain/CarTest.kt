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
}
