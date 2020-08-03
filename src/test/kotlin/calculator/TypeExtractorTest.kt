package calculator

import com.sun.xml.internal.fastinfoset.util.StringArray
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import calculator.TypeExtractor.mappingOperator
import java.util.stream.Stream

class TypeExtractorTest {

    @ParameterizedTest
    @CsvSource(value = ["1, 1", "1111, 1111", "a1, 1", "1a, 1"])
    fun `Extract number test`(input: String, result: Int) {
        assertThat(TypeExtractor.extractNumber(input)).isEqualTo(listOf(result))
    }

    @ParameterizedTest
    @CsvSource(value = ["aa10bb20cc30, 3, 10, 20, 30", "10aa20bb30cc, 3, 10, 20, 30"])
    fun `Extract number test - item size's 3`(
        expression: String,
        size: Int,
        firstItem: Int,
        secondItem: Int,
        thirdItem: Int
    ) {
        assertThat(TypeExtractor.extractNumber(expression)).satisfies {
            assertThat(it.size).isEqualTo(size)
            assertThat(it).isEqualTo(listOf(firstItem, secondItem, thirdItem))
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["+", "-", "*", "/"])
    fun `Extract Operator test - single operator`(operator: String) {
        assertThat(TypeExtractor.extractOperator(operator)).isEqualTo(listOf(operator))
    }

    @ParameterizedTest
    @ValueSource(strings = ["?", "&", "#"])
    fun `Extract Operator test - invalid operator`(operator: String) {
        assertThat(TypeExtractor.extractOperator(operator)).isEqualTo(emptyList<String>())
    }

    @ParameterizedTest
    @CsvSource(value = ["++++++, +"])
    fun `Extract Operator test - multiple operator`(input: String, operator: String) {
        assertThat(TypeExtractor.extractOperator(input)).isEqualTo(operator.repeat(6).map { it.toString() })
    }

    @ParameterizedTest
    @CsvSource(value = ["??????", "####"])
    fun `Extract Operator test - invalid multiple operator`(input: String) {
        assertThat(TypeExtractor.extractOperator(input)).isEqualTo(emptyList<String>())
    }

    @ParameterizedTest
    @MethodSource(value = ["provideExpressionAndReturnStringOperator"])
    fun `Extract Operator test - multiple operator * character`(
        expression: String,
        size: Int,
        operators: List<String>
    ) {
        assertThat(TypeExtractor.extractOperator(expression)).satisfies {
            assertThat(it.size).isEqualTo(size)
            assertThat(it).isEqualTo(operators)
        }
    }

    @ParameterizedTest
    @MethodSource(value = ["provideExpressionAndReturnOperator"])
    fun `Valid expression`(expression: String, number: List<Int>, operator: List<Operator>) {
        assertThat(TypeExtractor.extract(expression)).satisfies {
            assertThat(it.first).isEqualTo(number)
            assertThat(it.second).isEqualTo(operator)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["*1*2*3*4*5", "1**2*3*4*5", "1*2*3*4**5", "/1++2-3/4**5"])
    fun `Invalid expression`(expression: String) {
        assertThatThrownBy { TypeExtractor.extract(expression) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid expression's format")
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "11", "+"])
    fun `Empty expression`(expression: String) {
        assertThatThrownBy { TypeExtractor.extract(expression) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Invalid empty expression")
    }

    @Test
    fun `Mapping Operator enum class`(stringArray: StringArray) {
        assertThat(listOf("+", "-", "*", "/").mappingOperator())
            .isEqualTo(listOf(Operator.ADD, Operator.SUB, Operator.MUL, Operator.DIV))

        assertThatThrownBy { listOf("-", "-", "-", "0").mappingOperator() }
            .isInstanceOf(IllegalStateException::class.java)
            .hasMessageContaining("Invalid operator type")
    }

    companion object {
        @JvmStatic
        fun provideExpressionAndReturnStringOperator(): Stream<Arguments> {
            return Stream.of(
                Arguments.of("1**3*4*5", 4, listOf("*", "*", "*", "*")),
                Arguments.of("*1-2+3//5", 5, listOf("*", "-", "+", "/", "/"))
            )
        }

        @JvmStatic
        fun provideExpressionAndReturnOperator(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(
                    "1*2*3*4*5",
                    listOf(1, 2, 3, 4, 5),
                    listOf(Operator.MUL, Operator.MUL, Operator.MUL, Operator.MUL)
                ),
                Arguments.of(
                    "11+2/3*4-5",
                    listOf(11, 2, 3, 4, 5),
                    listOf(Operator.ADD, Operator.DIV, Operator.MUL, Operator.SUB)
                )
            )
        }
    }
}
