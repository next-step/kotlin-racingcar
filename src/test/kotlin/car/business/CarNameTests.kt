package car.business

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarNameTests {
    @Test
    fun `자동차의 이름은 5글자를 넘길 수 없다`() {
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { CarName("5글자에요!") }
    }

    @ParameterizedTest
    @ValueSource(strings = ["오", "오길", "오긿환", "오길환이", "오길환이다"])
    fun `자동차의 이름은 5글자 이하여야 한다`(name: String) {
        assertDoesNotThrow {
            CarName(name)
        }
    }
}
