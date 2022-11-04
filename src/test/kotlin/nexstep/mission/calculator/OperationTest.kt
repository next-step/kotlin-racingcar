package nexstep.mission.calculator

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import nexstep.mission.calculator.Operator.DIVISION
import nexstep.mission.calculator.Operator.MINUS
import nexstep.mission.calculator.Operator.MULTIPLE
import nexstep.mission.calculator.Operator.PLUS

class OperationTest : FunSpec({

    context("PLUS") {
        test("연산 기호는 + 다.") {
            PLUS.symbol shouldBe "+"
        }

        test("계산은 두 인자를 더한다.") {
            PLUS.operate(1, 2) shouldBe 3
        }
    }

    context("MINUS") {
        test("연산 기호는 - 다.") {
            MINUS.symbol shouldBe "-"
        }

        test("계산은 두 인자를 뺀다.") {
            MINUS.operate(2, 1) shouldBe 1
        }
    }

    context("MULTIPLE") {
        test("연산 기호는 * 다.") {
            MULTIPLE.symbol shouldBe "*"
        }

        test("계산은 두 인자를 곱한다..") {
            MULTIPLE.operate(2, 3) shouldBe 6
        }
    }

    context("DIVISION") {
        test("연산 기호는 / 다.") {
            DIVISION.symbol shouldBe "/"
        }

        test("계산은 두 인자를 나눈다.") {
            DIVISION.operate(10, 2) shouldBe 5
        }

        test("계산 시 두번째 피연산자가 0이면 예외를 던진다.") {
            val exception = shouldThrowExactly<IllegalArgumentException> { DIVISION.operate(1, 0) }
            exception.message shouldBe "0으로 나눌 수 없습니다."
        }
    }

    context("Operation") {
        test("find - 연산 기호가 같은 Operation을 찾는다.") {
            Operator.find("+") shouldBe PLUS
        }

        test("find - 연산 기호를 찾지 못하면 예외를 던진다.") {
            val wrongOperator = ""
            val exception = shouldThrowExactly<IllegalArgumentException> { Operator.find(wrongOperator) }
            exception.message shouldBe "사칙 연산 기호가 잘못됐습니다."
        }
    }
})
