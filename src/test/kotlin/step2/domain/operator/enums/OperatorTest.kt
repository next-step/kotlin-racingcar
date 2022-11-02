package step2.domain.operator.enums

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import step2.domain.operation.enums.Operator
import step2.domain.operation.model.BinaryInputCommand

internal class OperatorTest {

    companion object {
        private const val ADDITION_LITERAL_STRING = "+"
        private const val SUBTRACTION_LITERAL_STRING = "-"
        private const val MULTIPLICATION_LITERAL_STRING = "*"
        private const val DIVISION_LITERAL_STRING = "/"
    }

    @ParameterizedTest
    @ValueSource(strings = [ADDITION_LITERAL_STRING, SUBTRACTION_LITERAL_STRING, MULTIPLICATION_LITERAL_STRING, DIVISION_LITERAL_STRING])
    fun `문자열에서 Operator enum 으로 변환`(operatorString: String) {
        val operator = Operator.operatorOf(operatorString)
        assertThat(operator).isNotNull
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "__", "++", "!"])
    fun `문자열에서 Operator enum 으로 변환 오류`(operatorString: String) {
        assertThrows<IllegalArgumentException> { Operator.operatorOf(operatorString) }
    }

    @Test
    fun `Operator enum 을 Command 로 전환`() {
        Operator.values().forEach {
            assertThat(it.toCommand()).isNotNull
        }
    }

    @ParameterizedTest
    @ValueSource(strings = [ADDITION_LITERAL_STRING, SUBTRACTION_LITERAL_STRING, MULTIPLICATION_LITERAL_STRING, DIVISION_LITERAL_STRING])
    fun `Operator Command 동작 확인`(operatorString: String) {
        val binaryInputCommand = BinaryInputCommand(firstNumber = 1, secondNumber = 2)
        val result = Operator.operatorOf(operatorString).toCommand().operate(binaryInputCommand)
        when (operatorString) {
            ADDITION_LITERAL_STRING -> assertThat(result).isEqualTo(3)
            SUBTRACTION_LITERAL_STRING -> assertThat(result).isEqualTo(-1)
            MULTIPLICATION_LITERAL_STRING -> assertThat(result).isEqualTo(2)
            DIVISION_LITERAL_STRING -> assertThat(result).isEqualTo(0)
        }
    }
}
