package racingcar.car

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarNamesTest {

    @Test
    fun `자동차 이름은 1개 이상이어야 한다`() {
        assertThatIllegalArgumentException()
            .isThrownBy { CarNames(listOf()) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "   "])
    fun `자동차 이름은 공백이 아니어야 한다`(name: String) {
        assertThatIllegalArgumentException()
            .isThrownBy { CarNames(listOf(name)) }
            .withMessageContaining("공백")
    }

    @Test
    fun `자동차 이름은 중복되지 않아야 한다`() {
        assertThatIllegalArgumentException()
            .isThrownBy { CarNames(listOf("a", "a")) }
            .withMessageContaining("중복")
    }
}
