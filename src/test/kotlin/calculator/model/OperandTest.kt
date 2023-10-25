package calculator.model

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldHaveSize

class OperandTest : StringSpec({

    "Operand 만을 잘 파싱해오는지 검증한다" {
        val actual = Operand.parseOperands("1+2+3")
        actual shouldHaveSize 3
        actual shouldContain Operand(1)
        actual shouldContain Operand(2)
        actual shouldContain Operand(3)
    }
})
