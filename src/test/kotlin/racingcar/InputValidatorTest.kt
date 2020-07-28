package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InputValidatorTest {

    @Test
    fun isValidTryCount() {
        assertThat(InputValidator.isValidTryCount("0")).isFalse()
        assertThat(InputValidator.isValidTryCount("10")).isTrue()
    }
}
