package calculator

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows

class OperandTest : FunSpec({

    context("연산을 처리한다.") {
        test("덧셈(+)") {
            Operand(1) + Operand(3) shouldBe Operand(4)
        }

        test("뺄셈(-)") {
            Operand(7) - Operand(2) shouldBe Operand(5)
        }

        test("곱셈(*)") {
            Operand(10) * Operand(2) shouldBe Operand(20)
        }

        test("나누셈(/)") {
            Operand(10) / Operand(2) shouldBe Operand(5)
        }
    }

    test("0으로는 나눌 수 없다.") {
        assertThrows<IllegalArgumentException> { Operand(10) / Operand.ZERO }
    }
})
