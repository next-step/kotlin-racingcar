package calculator.domain

import calculator.model.ErrorCode
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage

class CalculatorTest : DescribeSpec({

    describe(name = "계산기를 실행할 때") {
        context(name = "사칙연산을 섞어 입력하면") {
            val actual = Calculator.calculate(
                inputString = "1 / 2 + 3 * 4",
            )

            it(name = "사칙연산에 관계없이 순서대로 계산된다.") {
                actual shouldBe ((1.0 / 2.0) + 3.0) * 4.0
            }
        }

        context(name = "나누기 뒤에 0을 입력하면") {
            val except = 0.0

            val exception = shouldThrow<IllegalArgumentException> {
                Calculator.calculate(
                    inputString = "1 / $except + 3 * 4",
                )
            }

            it(name = "나누기 뒤에 0이 올 수 없다는 에러가 발생한다.") {
                exception shouldHaveMessage ErrorCode.INVALID_NUMBER_INPUT_WHEN_DIVIDE.message(except.toString())
            }
        }
    }

    describe(name = "입력한 문자열을 계산기할 때") {
        context(name = "정상적인 문자열을 넣으면") {
            val actual = Calculator.calculate(
                inputString = "2 * 2 / 3",
            )

            it(name = "숫자와 연산자 모두 등록된다.") {
                actual shouldBe 2.0 * 2.0 / 3.0
            }
        }

        context(name = "홀수 부분에 숫자가 들어간 경우") {
            val exception = shouldThrow<IllegalArgumentException> {
                Calculator.calculate(
                    inputString = "2 2 2 / 3",
                )
            }

            it(name = "연산자를 컨버팅할 수 없다는 에러가 발생한다.") {
                exception shouldHaveMessage ErrorCode.INVALID_OPERATOR_CODE.message("2")
            }
        }

        context(name = "짝수 부분에 연산자가 들어간 경우") {
            val exception = shouldThrow<IllegalArgumentException> {
                Calculator.calculate(
                    inputString = "/ / 2 / 3",
                )
            }

            it(name = "짝수 부분에는 숫자가 들어가야 한다는 에러가 발생한다.") {
                exception shouldHaveMessage ErrorCode.INVALID_NUMBER_INPUT.message("/")
            }
        }
    }

    describe(name = "입력 받은 문자열을 계산할 때") {
        context(name = "연산자와 숫자의 값을 동일하게 넣으면") {
            val exception = shouldThrow<IllegalArgumentException> {
                Calculator.calculate(
                    inputString = "2 / 2 /"
                )
            }

            it(name = "생성하지 못하고, 에러가 발생한다.") {
                exception shouldHaveMessage ErrorCode.INVALID_CALCULATOR_INPUT.message("2 2")
            }
        }
    }
})
