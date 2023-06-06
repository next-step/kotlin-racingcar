package step2.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.throwable.shouldHaveMessage
import step2.model.ErrorCode

class CalculatorInputConverterTest : DescribeSpec({

    describe(name = "입력한 문자열을 계산기 입력용으로 변환할 때") {
        context(name = "정상적인 문자열을 넣으면") {
            val convertToCalculatorInput = CalculatorInputConverter.convertToCalculatorInput(
                inputString = "2 * 2 / 3",
            )

            it(name = "숫자와 연산자 모두 등록된다.") {
                convertToCalculatorInput.numbers.size shouldBe 3
                convertToCalculatorInput.operators.size shouldBe 2
            }
        }

        context(name = "홀수 부분에 숫자가 들어간 경우") {
            val exception = shouldThrow<IllegalArgumentException> {
                CalculatorInputConverter.convertToCalculatorInput(
                    inputString = "2 2 2 / 3",
                )
            }

            it(name = "연산자를 컨버팅할 수 없다는 에러가 발생한다.") {
                exception shouldHaveMessage ErrorCode.INVALID_OPERATOR_CODE.message("2")
            }
        }

        context(name = "짝수 부분에 연산자가 들어간 경우") {
            val exception = shouldThrow<IllegalArgumentException> {
                CalculatorInputConverter.convertToCalculatorInput(
                    inputString = "/ / 2 / 3",
                )
            }

            it(name = "짝수 부분에는 숫자가 들어가야 한다는 에러가 발생한다.") {
                exception shouldHaveMessage ErrorCode.INVALID_NUMBER_INPUT.message("/")
            }
        }
    }
})
