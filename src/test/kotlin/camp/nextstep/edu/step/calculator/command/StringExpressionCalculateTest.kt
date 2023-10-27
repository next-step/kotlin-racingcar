package camp.nextstep.edu.step.calculator.command

import camp.nextstep.edu.step.calculator.domain.Requester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("문자열 수식 계산기는")
class StringExpressionCalculateTest {

    @Nested
    class `문자열 수학식이 입력되면` {
        @Test
        fun `사칙연산 수행이 가능하다`() {
            // given
            val expression1 = Requester(expression = "2 + 3 * 4 / 2")
            val expression2 = Requester(expression = "2 + 3 * 4 / 2 - 1")
            val expression3 = Requester(expression = "2 + 3 * 4 / 2 - 1 * 2")

            // when
            val result1 = StringExpressionCalculate().calculate(expression1)
            val result2 = StringExpressionCalculate().calculate(expression2)
            val result3 = StringExpressionCalculate().calculate(expression3)

            // then
            Assertions.assertAll(
                { Assertions.assertEquals(10L, result1.calculationResult) },
                { Assertions.assertEquals(9L, result2.calculationResult) },
                { Assertions.assertEquals(18L, result3.calculationResult) }
            )
        }
    }

}
