package racingcar.domain

import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class NameTest {
    @ValueSource(strings = ["krrong", "wisemuji"])
    @ParameterizedTest
    fun `Throw exception when the name is longer than 5`(value: String) {
        assertThrows<IllegalArgumentException> {
            Name(value)
        }
    }

    @ValueSource(strings = ["k", "kr", "krr", "krro", "krron"])
    @ParameterizedTest
    fun `Doesn't throw exception when the name is less than 5 or equal to 5`(value: String) {
        assertDoesNotThrow { Name(value) }
    }
}
