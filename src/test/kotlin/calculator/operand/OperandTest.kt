package calculator.operand

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class OperandTest: StringSpec({
    "숫자가 아닌 문자가 입력되면 예외가 발생한다." {
        shouldThrow<IllegalArgumentException> {
            Operand.of("+")
        }
    }
})
