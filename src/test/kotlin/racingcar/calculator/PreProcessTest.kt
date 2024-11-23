package racingcar.calculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class PreProcessTest {
    @Test
    fun `연산식에서 공백 기준으로 분리`() {
        val userInputString = UserInputString("3 + 5")
        val result: List<String> = PreProcess.splitBySpace(userInputString)
        assertThat(listOf("3", "+", "5")).isEqualTo(result)
    }

    @Test
    fun `문자열 리스트에서 숫자만 추출`() {
        val userInputString = UserInputString("3 + 5")
        val result: List<String> = PreProcess.splitBySpace(userInputString)
        assertThat(listOf("3", "+", "5")).isEqualTo(result)

        val numbers: List<Double> = PreProcess.extractNumbers(result)
        assertThat(listOf(3.0, 5.0)).isEqualTo(numbers)
    }

    @Test
    fun `문자열 리스트에서 연산자만 추출`() {
        val userInputString = UserInputString("3 + 5 - 2")
        val result: List<String> = PreProcess.splitBySpace(userInputString)
        assertThat(listOf("3", "+", "5", "-", "2")).isEqualTo(result)

        val operators: List<String> = PreProcess.extractOperators(result)
        assertThat(listOf("+", "-")).isEqualTo(operators)
    }

    @Test
    fun `문자열 리스트에서 연산자만 추출시 비정상 연산자 포함시 예외 처리`() {
        val userInputString = UserInputString("3 + 5 & 2")
        val result: List<String> = PreProcess.splitBySpace(userInputString)
        assertThat(listOf("3", "+", "5", "&", "2")).isEqualTo(result)

        assertThatThrownBy {
            PreProcess.extractOperators(result)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
