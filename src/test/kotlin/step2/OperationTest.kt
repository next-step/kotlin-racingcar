package step2

import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.NullSource
import org.junit.jupiter.params.provider.ValueSource

class OperationTest {

    @ParameterizedTest
    @NullSource
    @EmptySource
    @ValueSource(strings = [" "])
    fun `입력값이 null이거나 빈 공백 문자일 경우 예외처리 검증`(symbol: String?) {
        assertThatIllegalArgumentException().isThrownBy {
            Operation.findCalculation(symbol)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["!", "@", "#", "$", "%"])
    fun `사칙연산 기호가 아닌 경우 예외처리 검증`(symbol: String) {
        assertThatIllegalArgumentException().isThrownBy {
            Operation.findCalculation(symbol)
        }
    }
}
