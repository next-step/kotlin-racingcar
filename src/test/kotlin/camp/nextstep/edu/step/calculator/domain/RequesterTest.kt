package camp.nextstep.edu.step.calculator.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("계산기 사용 요청자는")
class RequesterTest {

    @Nested
    class `문자열 수식 입력시` {
        @Test
        fun `요청 객체생성이 가능하다`() {
            // given
            val mathExperssion = "2 + 3 * 4 / 2"

            // when
            val requester = Requester(expression = mathExperssion)

            // then
            assertThat(requester.expression).isEqualTo("2 + 3 * 4 / 2")
        }

        @Test
        fun `수식을 공백으로 분리할 수 있다`() {
            // given
            val mathExperssion = "2 + 3 * 4 / 2"
            val requester = Requester(expression = mathExperssion)

            // when
            val splitExpression = requester.splitExpression()

            // then
            assertThat(splitExpression).containsExactly("2", "+", "3", "*", "4", "/", "2")
        }
    }

    @Nested
    class `수식이 비어있을 경우` {
        @Test
        fun `예외가 발생한다`() {
            // when & then
            assertThatThrownBy { Requester().validate() }
                .isInstanceOf(IllegalArgumentException::class.java)
                .hasMessage("수식이 비어있습니다.")
        }
    }
}
