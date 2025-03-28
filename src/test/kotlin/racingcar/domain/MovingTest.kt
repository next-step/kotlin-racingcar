package racingcar.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class MovingTest {
    @ValueSource(ints = [1, 9, 10, 100])
    @ParameterizedTest
    fun `number should be more than 0 or equal to 0`(number: Int) {
        assertDoesNotThrow { Moving(number) }
    }

    @ValueSource(ints = [-1, -10, -100])
    @ParameterizedTest
    fun `return exception when the number is less than 0`(number: Int) {
        assertThrows<IllegalArgumentException> {
            Moving(number)
        }
    }
}