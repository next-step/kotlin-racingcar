package calculrate

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource

class CalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    fun `입력값이 Null 이거나 빈 공백 문자일 경우 IllegalArgumentException throw`(input: String?) {
        Assertions.assertThatThrownBy {
            Calculator.calculate(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
