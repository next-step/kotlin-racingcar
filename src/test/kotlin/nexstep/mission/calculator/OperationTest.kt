package nexstep.mission.calculator

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import nexstep.mission.calculator.Operation.DIVISION
import nexstep.mission.calculator.Operation.MINUS
import nexstep.mission.calculator.Operation.MULTIPLE
import nexstep.mission.calculator.Operation.PLUS

class OperationTest : FunSpec({

    context("PLUS") {
        test("연산 기호는 + 다.") {
            PLUS.operator shouldBe "+"
        }

        test("계산은 두 인자를 더한다.") {
            PLUS.calculator(1, 2) shouldBe 3
        }
    }

    context("MINUS") {
        test("연산 기호는 - 다.") {
            MINUS.operator shouldBe "-"
        }

        test("계산은 두 인자를 뺀다.") {
            MINUS.calculator(2, 1) shouldBe 1
        }
    }

    context("MULTIPLE") {
        test("연산 기호는 * 다.") {
            MULTIPLE.operator shouldBe "*"
        }

        test("계산은 두 인자를 곱한다..") {
            MULTIPLE.calculator(2, 3) shouldBe 6
        }
    }

    context("DIVISION") {
        test("연산 기호는 / 다.") {
            DIVISION.operator shouldBe "/"
        }

        test("계산은 두 인자를 나눈다.") {
            DIVISION.calculator(10, 2) shouldBe 5
        }

        test("계산 시 두번째 피연산자가 0이면 예외를 던진다.") {
            val exception = shouldThrowExactly<IllegalArgumentException> { DIVISION.calculator(1, 0) }
            exception.message shouldBe "0으로 나눌 수 없습니다."
        }
    }
})
