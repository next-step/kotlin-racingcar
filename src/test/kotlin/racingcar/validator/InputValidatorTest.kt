package racingcar.validator

import io.kotest.core.spec.style.StringSpec
import org.assertj.core.api.Assertions.assertThatThrownBy

class InputValidatorTest : StringSpec({
    "숫자가 아닌 값을 전달하면 오류를 반환한다" {
        assertThatThrownBy {
            InputValidator.validateInput("a")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    "음수를 전달하면 오류를 반환한다" {
        assertThatThrownBy {
            InputValidator.validateInput("-1")
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
})
