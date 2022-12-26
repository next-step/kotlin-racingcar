package step2.calculator

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import step2.calculator.vo.Number

class CalculatorTest : StringSpec({
    "올바른 인풋에 대해서 오류 없이 계산기 생성이 가능하다." {
        shouldNotThrowAny { Calculator.from("3 + 2 * 4") }
    }

    "올바르지 않은 인풋에 대해서 오류 없이 계산기 생성이 불가능하다." {
        shouldThrowAny { Calculator.from("3+ 2 * 4") }
    }

    "계산결과가 출력된다." {
        assertSoftly {
            Calculator.from("3 + 2 * 4").calculate() shouldBe Number(20)
            Calculator.from("3 + 2 * 4 + 1").calculate() shouldBe Number(21)
            Calculator.from("3 + 2 * 4 / 5").calculate() shouldBe Number(4)
            Calculator.from("3 + 2 * 4 * 5").calculate() shouldBe Number(100)
        }

    }
})
