package step2.domain.operator.enums

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import step2.domain.operation.enums.Operator

class OperatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["+", "-", "*", "/"])
    internal fun `문자열에서 Operator enum 으로 변환`(operatorString: String) {
        val operator = Operator.operatorOf(operatorString)
        assertThat(operator).isNotNull
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "__", "++", "!"])
    internal fun `문자열에서 Operator enum 으로 변환 오류`(operatorString: String) {
        assertThrows<IllegalArgumentException> { Operator.operatorOf(operatorString) }
    }

    @Test
    internal fun `Operator enum 을 Command 로 전환`() {
        Operator.values().forEach {
            assertThat(it.toCommand()).isNotNull
        }
    }
}
