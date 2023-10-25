package camp.nextstep.edu.step.calculator.domain

import camp.nextstep.edu.step.calculator.command.StringExpressionCalculate
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("계산기는")
class CalculatorTest {

    @Nested
    class `사용 계산기와 수학식을 입력시` {
        @Test
        fun `덧셈이 가능하다`() {
            // given
            val mathExperssion = "2 + 3"
            val requester = Requester(expression = mathExperssion)
            val calculator = Calculator(StringExpressionCalculate())

            // when
            val result = calculator.calculateExpression(requester)

            // then
            assertThat(result.calculationResult).isEqualTo(5L)
        }

        @Test
        fun `뺄셈이 가능하다`() {
            // given
            val mathExperssion = "5 - 2"
            val requester = Requester(expression = mathExperssion)
            val calculator = Calculator(StringExpressionCalculate())

            // when
            val result = calculator.calculateExpression(requester)

            // then
            assertThat(result.calculationResult).isEqualTo(3L)
        }

        @Test
        fun `곱셈이 가능하다`() {
            // given
            val mathExperssion = "2 * 3"
            val requester = Requester(expression = mathExperssion)
            val calculator = Calculator(StringExpressionCalculate())

            // when
            val result = calculator.calculateExpression(requester)

            // then
            assertThat(result.calculationResult).isEqualTo(6L)
        }

        @Test
        fun `나눗셈이 가능하다`() {
            // given
            val mathExperssion = "2 / 3"
            val requester = Requester(expression = mathExperssion)
            val calculator = Calculator(StringExpressionCalculate())

            // when
            val result = calculator.calculateExpression(requester)

            // then
            assertThat(result.calculationResult).isEqualTo(0L)
        }
    }

    @Nested
    class `만약 나눗셈시 0이 입력되면` {
        @Test
        fun `예외가 발생한다`() {
            // given
            val mathExperssion = "2 / 0"
            val requester = Requester(expression = mathExperssion)
            val calculator = Calculator(StringExpressionCalculate())

            // when & then
            Assertions.assertThatThrownBy { calculator.calculateExpression(requester) }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("0으로 나눌 수 없습니다.")
        }
    }
}
