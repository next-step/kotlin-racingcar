package calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

class TokenizeTest {

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "   ", "\t", "\n", "\t\n", "\n\t", " \n \t"])
    fun `공백 문자를 입력하면 빈 리스트를 출력한다`(input: String) {
        assertThat(input.tokenize()).isEmpty()
    }

    @Test
    fun `앞선 공백 문자나 연속된 공백 문자, 뒤의 공백문자는 제거된다`() {
        assertThat("  1 + 2".tokenize()).isEqualTo(listOf("1", "+", "2"))
        assertThat("13 - 21   ".tokenize()).isEqualTo(listOf("13", "-", "21"))
        assertThat("15543 * 21121 \n ".tokenize()).isEqualTo(listOf("15543", "*", "21121"))
        assertThat("-231 \t  /  232".tokenize()).isEqualTo(listOf("-231", "/", "232"))
    }

    @Test
    fun `null 이 입력되면 IllegalArgumentException 을 던진다`() {
        assertThatThrownBy {
            val expression: String? = null
            expression.tokenize()
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}

class ParseTest {

    @Test
    fun `빈 리스트는 Undefined object 를 리턴한다`() {
        assertThat(emptyList<String>().parse()).isEqualTo(Expression.Undefined)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, -1, 100, Int.MAX_VALUE, Int.MIN_VALUE])
    fun `단일 숫자 리스트는 숫자 값을 value 로 갖는 Operand 클래스를 리턴한다`(input: Int) {
        assertThat(listOf(input.toString()).parse()).isEqualTo(Expression.Operand(input))
    }

    @Test
    fun `사칙 연산자는 Operator 클래스를 리턴한다`() {
        assertThat(listOf("+").parse()).isEqualTo(Expression.Operator(Int::plus))
        assertThat(listOf("-").parse()).isEqualTo(Expression.Operator(Int::minus))
        assertThat(listOf("*").parse()).isEqualTo(Expression.Operator(Int::times))
        assertThat(listOf("/").parse()).isEqualTo(Expression.Operator(Int::div))
    }

    @Test
    fun `사칙 연산은 피 연산자를 operand 로 갖는 Operator 클래스를 리턴한다`() {
        assertThat(listOf("1", "+", "-1").parse()).isEqualTo(
            Expression.Operator(Int::plus, Expression.Operand(1), Expression.Operand(-1))
        )
        assertThat(listOf("24", "-", "31").parse()).isEqualTo(
            Expression.Operator(Int::minus, Expression.Operand(24), Expression.Operand(31))
        )
        assertThat(listOf("6", "*", "53").parse()).isEqualTo(
            Expression.Operator(Int::times, Expression.Operand(6), Expression.Operand(53))
        )
        assertThat(listOf("7", "/", "2").parse()).isEqualTo(
            Expression.Operator(Int::div, Expression.Operand(7), Expression.Operand(2))
        )
    }

    @Test
    fun `숫자와 사칙연산 이외의 문자열은 IllegalArgumentException 을 던진다`() {
        assertThatThrownBy { listOf("31.42", "+", "-1").parse() }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { listOf("42", "^", "21").parse() }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { listOf("(", "3", ")").parse() }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { listOf("abc", "+", "가나다").parse() }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `여러 사칙 연산이 조합된 수식은 마지막 연산자의 Operator 클래스를 리턴한다`() {
        val parsed = listOf("7", "+", "2", "-", "3").parse()
        assertThat(parsed).isInstanceOf(Expression.Operator::class.java)

        val operator = parsed as Expression.Operator
        assertThat(operator.function).isEqualTo((listOf("-").parse() as Expression.Operator).function)
        assertThat(operator.firstOperand).isEqualTo(listOf("7", "+", "2").parse())
        assertThat(operator.secondOperand).isEqualTo(Expression.Operand(3))
    }
}

class CalculatorTest {

    @ParameterizedTest
    @MethodSource("providePlusTestArgument")
    fun `덧셈 연산`(input: String, result: Int) {
        assertThat(input.calculate()).isEqualTo(result)
    }

    @ParameterizedTest
    @MethodSource("provideMinusTestArgument")
    fun `뺄셈 연산`(input: String, result: Int) {
        assertThat(input.calculate()).isEqualTo(result)
    }

    @ParameterizedTest
    @MethodSource("provideTimesTestArgument")
    fun `곱셈 연산`(input: String, result: Int) {
        assertThat(input.calculate()).isEqualTo(result)
    }

    @ParameterizedTest
    @MethodSource("provideDivTestArgument")
    fun `나눗셈 연산`(input: String, result: Int) {
        assertThat(input.calculate()).isEqualTo(result)
    }

    @ParameterizedTest
    @ValueSource(strings = ["5 / 0", "3 + 4 / 0", "10 / 0 * 4"])
    fun `0 으로 나누는 경우 ArithmeticException 을 던진다`(input: String) {
        assertThatThrownBy { input.calculate() }.isInstanceOf(ArithmeticException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["4 ^ 3", "abc + 가나다", "32.21 + 0.94", "@2$3"])
    fun `사칙 연산 기호가 아닌 경우에는 IllegalArgumentException 을 던진다`(input: String) {
        assertThatThrownBy { input.calculate() }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `입력 값에 따라 계산 순서가 결정된다`() {
        assertThat("1 + 2 * 3".calculate()).isEqualTo(9)
        assertThat("4 - 2 / 2".calculate()).isEqualTo(1)
        assertThat("7 + 3 * 6 - 22 / 2".calculate()).isEqualTo(19)
    }

    companion object {

        @JvmStatic
        fun providePlusTestArgument(): Stream<Arguments> = Stream.of(
            Arguments.of("1 + 2", 3),
            Arguments.of("2 + 3", 5),
            Arguments.of("10 + 0", 10),
            Arguments.of("100 + 100", 200),
            Arguments.of("-1 + 2", 1),
            Arguments.of("1 + -2", -1),
        )

        @JvmStatic
        fun provideMinusTestArgument(): Stream<Arguments> = Stream.of(
            Arguments.of("1 - 2", -1),
            Arguments.of("5 - 3", 2),
            Arguments.of("0 - 9", -9),
            Arguments.of("10 - 0", 10),
        )

        @JvmStatic
        fun provideTimesTestArgument(): Stream<Arguments> = Stream.of(
            Arguments.of("1 * 1", 1),
            Arguments.of("5 * 0", 0),
            Arguments.of("0 * 9", 0),
            Arguments.of("10 * 5", 50),
            Arguments.of("10 * -1", -10),
        )

        @JvmStatic
        fun provideDivTestArgument(): Stream<Arguments> = Stream.of(
            Arguments.of("4 / 2", 2),
            Arguments.of("5 / 2", 2),
            Arguments.of("100 / 101", 0),
            Arguments.of("100 / -10", -10),
        )
    }
}