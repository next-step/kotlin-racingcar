package expressioncalculator.inspector

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class InspectorTest {
    @ParameterizedTest
    @NullAndEmptySource
    fun `input이 null이나 empty일 경우 IllegalArgumentException을 던진다`(input: String?) {
        Assertions.assertThatThrownBy {
            mustNot {
                input.isNullOrEmpty()
            }
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1 * 2"])
    fun `input이 null이나 empty가 아닐 경우 IllegalArgumentException을 던지지 않는다`(input: String?) {
        assertDoesNotThrow {
            mustNot {
                input.isNullOrEmpty()
            }
        }
    }
}
