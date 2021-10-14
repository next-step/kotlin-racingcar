package calculator.domain

import calculator.domain.vo.Term
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

@DisplayName("간단한 계산기(SimpleCalculator)")
class SimpleCalculatorTest {

    @Test
    fun `사칙연산을 한다`() {
        assertAll(
            { assertThat(SimpleCalculator.calculate("1")).isEqualTo(Term(1.0)) },
            { assertThat(SimpleCalculator.calculate("1 + 2")).isEqualTo(Term(3)) },
            { assertThat(SimpleCalculator.calculate("1 - 2")).isEqualTo(Term(-1)) },
            { assertThat(SimpleCalculator.calculate("1 * 2")).isEqualTo(Term(2)) },
            { assertThat(SimpleCalculator.calculate("1 / 2")).isEqualTo(Term(0.5)) },
            { assertThat(SimpleCalculator.calculate("1 / 2 * 7 + 2")).isEqualTo(Term(5.5)) },
        )
    }
}
