package step2.calculator

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.core.spec.style.StringSpec

class CalculatorTest : StringSpec({
    "올바른 인풋에 대해서 오류 없이 계산기 생성이 가능하다." {
        shouldNotThrowAny { Calculator.from("3 + 2 * 4") }
    }

    "올바르지 않은 인풋에 대해서 오류 없이 계산기 생성이 불가능하다." {
        shouldThrowAny { Calculator.from("3+ 2 * 4") }
    }
})
