package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

class TokenizeTest {

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "   ", "\t", "\n", "\t\n", "\n\t", " \n \t"])
    fun `공백 문자를 입력하면 빈 리스트를 출력한다`(input: String) {
        assertThat(input.tokenize()).isEmpty()
    }

    @ParameterizedTest
    @MethodSource("provideTokenWhiteSpaceTestArgument")
    fun `앞선 공백 문자나 연속된 공백 문자, 뒤의 공백문자는 제거된다`(input: String, result: List<String>) {
        assertThat(input.tokenize()).isEqualTo(result)
    }

    @Test
    fun `null 이 입력되면 IllegalArgumentException 을 던진다`() {
        assertThatThrownBy {
            val expression: String? = null
            expression.tokenize()
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    companion object {

        @JvmStatic
        fun provideTokenWhiteSpaceTestArgument(): Stream<Arguments> = Stream.of(
            Arguments.of("  1 + 2", listOf("1", "+", "2")),
            Arguments.of("13 - 21   ", listOf("13", "-", "21")),
            Arguments.of("15543 * 21121 \n ", listOf("15543", "*", "21121")),
            Arguments.of("-231 \t  /  232", listOf("-231", "/", "232")),
        )
    }
}

class NonPrecedenceParserTest {

    private val parser = NonPrecedenceParser()

    @Test
    fun `빈 리스트는 Undefined object 를 리턴한다`() {
        assertThat(parser.parse(emptyList())).isEqualTo(Expression.Undefined)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, -1, 100, Int.MAX_VALUE, Int.MIN_VALUE])
    fun `단일 숫자 리스트는 숫자 값을 value 로 갖는 Operand 클래스를 리턴한다`(input: Int) {
        assertThat(parser.parse(listOf(input.toString()))).isEqualTo(Expression.Operand(input))
    }

    @Test
    fun `사칙 연산자는 Operator 클래스를 리턴한다`() {
        assertThat(parser.parse(listOf("+"))).isEqualTo(Expression.Operator(Int::plus))
        assertThat(parser.parse(listOf("-"))).isEqualTo(Expression.Operator(Int::minus))
        assertThat(parser.parse(listOf("*"))).isEqualTo(Expression.Operator(Int::times))
        assertThat(parser.parse(listOf("/"))).isEqualTo(Expression.Operator(Int::div))
    }

    @Test
    fun `사칙 연산은 피 연산자를 operand 로 갖는 Operator 클래스를 리턴한다`() {
        assertThat(parser.parse(listOf("1", "+", "-1"))).isEqualTo(
            Expression.Operator(Int::plus, Expression.Operand(1), Expression.Operand(-1))
        )
        assertThat(parser.parse(listOf("24", "-", "31"))).isEqualTo(
            Expression.Operator(Int::minus, Expression.Operand(24), Expression.Operand(31))
        )
        assertThat(parser.parse(listOf("6", "*", "53"))).isEqualTo(
            Expression.Operator(Int::times, Expression.Operand(6), Expression.Operand(53))
        )
        assertThat(parser.parse(listOf("7", "/", "2"))).isEqualTo(
            Expression.Operator(Int::div, Expression.Operand(7), Expression.Operand(2))
        )
    }

    @Test
    fun `숫자와 사칙연산 이외의 문자열은 IllegalArgumentException 을 던진다`() {
        assertThatThrownBy { parser.parse(listOf("31.42", "+", "-1")) }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { parser.parse(listOf("42", "^", "21")) }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { parser.parse(listOf("(", "3", ")")) }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { parser.parse(listOf("abc", "+", "가나다")) }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `여러 사칙 연산이 조합된 수식은 마지막 연산자의 Operator 클래스를 리턴한다`() {
        val parsed = parser.parse(listOf("7", "+", "2", "-", "3"))
        assertThat(parsed).isInstanceOf(Expression.Operator::class.java)

        val operator = parsed as Expression.Operator
        assertThat(operator.function).isEqualTo((parser.parse(listOf("-")) as Expression.Operator).function)
        assertThat(operator.firstOperand).isEqualTo(parser.parse(listOf("7", "+", "2")))
        assertThat(operator.secondOperand).isEqualTo(Expression.Operand(3))
    }
}

class CalculatorTest {

    private val calculator = Calculator()

    @ParameterizedTest
    @CsvSource(value = ["1 + 2:3", "2 + 3:5", "10 + 0:10", "100 + 100:200", "-1 + 2:1", "1 + -2:-1"], delimiter = ':')
    fun `덧셈 연산`(input: String, result: Int) {
        assertThat(calculator.calculate(input)).isEqualTo(result)
    }

    @ParameterizedTest
    @CsvSource(value = ["1 - 2:-1", "5 - 3:2", "0 - 9:-9", "10 - 0:10"], delimiter = ':')
    fun `뺄셈 연산`(input: String, result: Int) {
        assertThat(calculator.calculate(input)).isEqualTo(result)
    }

    @ParameterizedTest
    @CsvSource(value = ["1 * 1:1", "5 * 0:0", "0 * 9:0", "10 * 5:50", "10 * -1:-10"], delimiter = ':')
    fun `곱셈 연산`(input: String, result: Int) {
        assertThat(calculator.calculate(input)).isEqualTo(result)
    }

    @ParameterizedTest
    @CsvSource(value = ["4 / 2:2", "5 / 2:2", "100 / 101:0", "100 / -10:-10"], delimiter = ':')
    fun `나눗셈 연산`(input: String, result: Int) {
        assertThat(calculator.calculate(input)).isEqualTo(result)
    }

    @ParameterizedTest
    @ValueSource(strings = ["5 / 0", "3 + 4 / 0", "10 / 0 * 4"])
    fun `0 으로 나누는 경우 ArithmeticException 을 던진다`(input: String) {
        assertThatThrownBy { calculator.calculate(input) }.isInstanceOf(ArithmeticException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["4 ^ 3", "abc + 가나다", "32.21 + 0.94", "@2$3"])
    fun `사칙 연산 기호가 아닌 경우에는 IllegalArgumentException 을 던진다`(input: String) {
        assertThatThrownBy { calculator.calculate(input) }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `입력 값에 따라 계산 순서가 결정된다`() {
        assertThat(calculator.calculate("1 + 2 * 3")).isEqualTo(9)
        assertThat(calculator.calculate("4 - 2 / 2")).isEqualTo(1)
        assertThat(calculator.calculate("7 + 3 * 6 - 22 / 2")).isEqualTo(19)
    }
}
