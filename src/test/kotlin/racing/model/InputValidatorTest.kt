package racing.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource

class InputValidatorTest {
    @Test
    fun `숫자 입력, 공백 검증 테스트`() {
        val input = ""
        assertThrows<IllegalArgumentException> {
            InputValidator.requireValidAttemptCountInput(input)
        }.apply {
            message shouldBe "입력값을 확인해주세요."
        }
    }

    @ParameterizedTest
    @NullSource
    fun `숫자 입력, null 검증`(input: String?) {
        assertThrows<IllegalArgumentException> {
            InputValidator.requireValidAttemptCountInput(input)
        }.apply {
            message shouldBe "입력값을 확인해주세요."
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["    ", "q2", "1 1", "33-3", "  1"])
    fun `숫자 입력, 검증 테스트`(input: String) {
        shouldThrow<IllegalArgumentException> {
            InputValidator.requireValidAttemptCountInput(input)
        }.apply {
            message shouldBe "숫자를 입력해주세요."
        }
    }

    @Test
    fun `숫자 입력값, 숫자가 아닌경우 검증`() {
        val input = "="
        assertThrows<IllegalArgumentException> {
            InputValidator.requireValidAttemptCountInput(input)
        }.apply {
            message shouldBe "숫자를 입력해주세요."
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "-20", "-1"])
    fun `숫자 입력, 최소입력 검증`(input: String) {
        assertThrows<IllegalArgumentException> {
            InputValidator.requireValidAttemptCountInput(input)
        }.apply {
            message shouldBe "최소 0보다 큰수를 입력해주세요."
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["0 1", "-2 0", "-100 0"])
    fun `숫자 입력값 사이 공백 검증`(input: String) {
        assertThrows<IllegalArgumentException> {
            InputValidator.requireValidAttemptCountInput(input)
        }.apply {
            message shouldBe "숫자를 입력해주세요."
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["3", "10", "4"])
    fun `숫자 입력 검증`(input: String) {
        val attemptCount = InputValidator.requireValidAttemptCountInput(input)
        attemptCount shouldBe input
    }
}
