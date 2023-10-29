package calculator.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ArithmeticTest : StringSpec({

    "사칙연산의 연산자 우선순위를 적용하지 않고 입력받은 순서대로 계산한다" {
        val actual = Arithmetic(
            listOf(Operator.PLUS, Operator.MULTI),
            listOf(OperandFixture.one, OperandFixture.two, OperandFixture.four)
        ).act()
        actual shouldBe 12
    }

    "덧셈 기능이 동작 해야 한다" {
        val actual = Arithmetic(
            listOf(Operator.PLUS),
            listOf(OperandFixture.one, OperandFixture.two)
        ).act()
        actual shouldBe 3
    }

    "뻴셈 기능이 동작 해야 한다"() {
        val actual = Arithmetic(
            listOf(Operator.MINUS),
            listOf(OperandFixture.five, OperandFixture.three)
        ).act()
        actual shouldBe 2
    }

    "곱셈 기능이 동작 해야 한다"() {
        val actual = Arithmetic(
            listOf(Operator.MULTI),
            listOf(OperandFixture.three, OperandFixture.two)
        ).act()
        actual shouldBe 6
    }

    "나눗셈 기능이 동작 해야 한다"() {
        val actual = Arithmetic(
            listOf(Operator.DIVIDE),
            listOf(OperandFixture.four, OperandFixture.two)
        ).act()
        actual shouldBe 2
    }

    "계산이 불가능한 수식이 입력되면 IllegalArgumentException throw" {
        shouldThrow<IllegalArgumentException> {
            Arithmetic(
                listOf(Operator.DIVIDE, Operator.DIVIDE, Operator.DIVIDE),
                listOf(OperandFixture.four, OperandFixture.two)
            ).act()
        }
    }
})
