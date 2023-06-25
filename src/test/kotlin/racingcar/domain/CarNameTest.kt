package racingcar.domain

import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarNameTest {
    @ParameterizedTest
    @ValueSource(strings = ["", "test12"])
    fun `Car의 이름이 공백이거나 5자를 초과하면 예외가 발생한다`(invalidName: String) {
        shouldThrow<IllegalArgumentException> { Car(CarName(invalidName)) }
    }
}