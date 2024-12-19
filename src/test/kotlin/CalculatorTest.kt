import calc.Calculator
import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class CalculatorTest : StringSpec({
    "계산 잘~ 해봐 " {
        val result = Calculator("5 + 1 / 3").calc()
        result shouldBe 2
    }

    "형식 지키는지 보자" {
        shouldThrowWithMessage<IllegalArgumentException>("형식 지켜랴 ㅋ") {
            Calculator("223 h d23")
        }

    }
})