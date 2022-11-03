package study

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource
import kotlin.IllegalArgumentException

class StringCalculatorTest {

    @Test
    fun `2개 이상의 띄어쓰기를 하나로 만들기`() {
        val str: String = "2  +  3  *  44  /  2".replace("  ", " ")
        assertThat(str).isEqualTo("2 + 3 * 44 / 2")
    }

    @Test
    fun `문자열 자르기`() {
        val splits: List<String> = "22 + 3 * 4 / 2".split(" ")
        assertThat(splits.size).isEqualTo(7)
    }

    @Test
    fun `숫자와 기호 구분하기`() {
        val strings: List<String> = "23 + 3 * 4 / 2".split(" ")
        val groupBy: List<List<String>> = strings.withIndex()
            .groupBy { it.index % 2 }
            .map { it.value.map { valueIt -> valueIt.value } }
        println(groupBy[0])
        println(groupBy[1])
        assertThat(groupBy[0].size).isEqualTo(4)
        assertThat(groupBy[1].size).isEqualTo(3)
    }

    @Test
    fun `숫자 객체 생성 - 성공`() {
        val num1 = StringNumber(1)
        val num2 = StringNumber("1")
        assertEquals(num1, num2)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-", " ", "+"])
    @EmptySource
    fun `숫자 객체 생성 - 실패`(input: String) {
        assertThrows<IllegalArgumentException> {
            StringNumber(input)
        }
    }

    @Test
    fun `계산식에서 추출하여 숫자 리스트 생성`() {
        val strings: List<String> = "23 + 3 * 4 / 2".split(" ")
        val groupBy: List<List<String>> = strings.withIndex()
            .groupBy { it.index % 2 }
            .map { it.value.map { valueIt -> valueIt.value } }
        val stringNumbers = groupBy[0].map { StringNumber(it) }.toList()
        assertThat(stringNumbers.size).isEqualTo(4)
    }

    @ParameterizedTest
    @ValueSource(strings = ["+", "-", "/", "*"])
    fun `연산 기호 객체 생성 - 성공`(input: String) {
        assertDoesNotThrow {
            Operator.fromDescription(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = [" ", "r", "ㅁ", "_"])
    @NullAndEmptySource
    fun `연산 기호 객체 생성 - 실패`(input: String?) {
        assertThrows<IllegalArgumentException> {
            Operator.fromDescription(input)
        }
    }

    @Test
    fun `계산식에서 추출하여 연산 기호 리스트 생성`() {
        val strings: List<String> = "23 + 3 * 4 / 2".split(" ")
        val groupBy: List<List<String>> = strings.withIndex()
            .groupBy { it.index % 2 }
            .map { it.value.map { valueIt -> valueIt.value } }
        val operators = groupBy[1].map { Operator.fromDescription(it) }.toList()
        assertThat(operators.size).isEqualTo(3)
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 + 3 * 4 / 2", "200 + 3 * 4 / 2", "3 * 4 / 2"])
    fun `문자열 계산기 객체 생성 - 성공`(input: String) {
        assertDoesNotThrow {
            StringCalculator.execute(input)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["2 + - * 4 / 2", "2 + 3 * 4 /", "+ 3 * 4 / 2"])
    @EmptySource
    fun `문자열 계산기 객체 생성 - 실패`(input: String) {
        assertThrows<IllegalArgumentException> {
            StringCalculator.execute(input)
        }
    }

    @ParameterizedTest
    @CsvSource("2 + 3 * 4 / 2:10", "1 + 1 + 1 + 1:4", "0 - 0 - 0 - 0:0", delimiter = ':')
    fun `문자열 계산기 계산 - 성공`(input: String, expected: Long) {
        val actual = StringCalculator.execute(input)
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @ValueSource(strings = ["0 / 0"])
    fun `문자열 계산기 계산 - 실패`(input: String) {
        assertThrows<ArithmeticException> {
            StringCalculator.execute(input)
        }
    }
}
