package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InputValidatorTest {

    @Test
    fun isValidCarCount() {
        assertThat(InputValidator.isValidCarCount(0)).isFalse()
        assertThat(InputValidator.isValidCarCount(10)).isTrue()
    }

    @Test
    fun isValidTryCount() {
        assertThat(InputValidator.isValidTryCount(0)).isFalse()
        assertThat(InputValidator.isValidTryCount(10)).isTrue()
    }
}
