package calculator.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class OperatorTest : StringSpec({

    "사칙연산 기호가 아닌 경우 IllegalArgumentException throw" {
        shouldThrow<IllegalArgumentException> {
            Operator.parseOperators("1+2#4-33")
        }
    }
})
