import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class OperatorTest {

    @ParameterizedTest
    @CsvSource(value = ["+, ADD", "-,MINUS", "*,MULTIPLE", "/,DIVIDE" ])
    fun symbolOf(symbol: String, operation: String) {
        val operationEnum = Operator.symbolOf(symbol)

        operationEnum shouldBe Operator.valueOf(operation)
    }

    @NullAndEmptySource
    @ParameterizedTest
    @ValueSource(strings = ["%", "^", ")", " "])
    fun `symbolOf throw IllegalArgumentException`(symbol: String) {
        val exception = assertThrows<IllegalArgumentException> {
            Operator.symbolOf(symbol)
        }

        Assertions.assertThat(exception.message).isEqualTo(ErrorMessage.NotExistOperator.message)
    }

    @ParameterizedTest
    @ValueSource(strings = ["+", "-", "*", "/"])
    fun `isContains should be true`(operation: String) {
        val result = Operator.isContains(operation)

        result shouldBe true
    }

    @NullAndEmptySource
    @ParameterizedTest
    @ValueSource(strings = ["%", "^", ")", " "])
    fun `isContains should be false`(operation: String) {
        val result = Operator.isContains(operation)

        result shouldBe false
    }
}
