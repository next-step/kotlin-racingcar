package step2

import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : AnnotationSpec() {
    @Test
    fun `순서를 무시한 사칙연산이 이뤄지는지 확인`() {
        val calculator = Calculator()
        val example = "2 + 3 * 4 / 2"
        val result = calculator.calculate(example)

        result shouldBe 10
    }

    @Test
    fun `공백문자열을 넘기면 exception이 발생하는지 확인`() {
        val calculator = Calculator()
        val example = "   "
        shouldThrowWithMessage<IllegalArgumentException>("입력값이 null이거나 빈 공백이 아니여야합니다.") {
            calculator.calculate(example)
        }
    }

    @Test
    fun `빈 문자열을 넘기면 exception이 발생하는지 확인`() {
        val calculator = Calculator()
        val example = ""

        shouldThrowWithMessage<IllegalArgumentException>("입력값이 null이거나 빈 공백이 아니여야합니다.") {
            calculator.calculate(example)
        }
    }

    @Test
    fun `null인 문자열을 넘기면 exception이 발생하는지 확인`() {
        val calculator = Calculator()
        val example = null

        shouldThrowWithMessage<IllegalArgumentException>("입력값이 null이거나 빈 공백이 아니여야합니다.") {
            calculator.calculate(example)
        }
    }

    @Test
    fun `사칙연산 외의 기호가 포함될 경우 exception이 발생하는지 확인`() {
        val calculator = Calculator()
        val example = "2 % 3 * 4 / 2"

        shouldThrowWithMessage<IllegalArgumentException>("수학기호는 +, -, *, / 만 허용됩니다.") {
            calculator.calculate(example)
        }
    }
}
