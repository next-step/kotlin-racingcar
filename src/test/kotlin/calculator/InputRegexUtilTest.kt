package calculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InputRegexUtilTest {

    @Test
    fun `숫자만 허용하는 정규식`() {
        val regex = regexForNumber
        val number = "123"
        val character = "안녕"
        val specialCharacter = "!"
        val blank = " "
        val operator = "+"

        assertThat(regex.matches(number)).isTrue
        assertThat(regex.matches(character)).isFalse()
        assertThat(regex.matches(specialCharacter)).isFalse()
        assertThat(regex.matches(blank)).isFalse()
        assertThat(regex.matches(operator)).isFalse()
    }

    @Test
    fun `사칙연산 기호만 허용하는 정규식`() {
        val regex = regexForOperator
        val operator = "/"
        val operatorTwice = "/-"
        val character = "안녕"
        val specialCharacter = "!"
        val blank = " "
        val number = "123"

        assertThat(regex.matches(operator)).isTrue
        assertThat(regex.matches(operatorTwice)).isFalse()
        assertThat(regex.matches(character)).isFalse()
        assertThat(regex.matches(specialCharacter)).isFalse()
        assertThat(regex.matches(blank)).isFalse()
        assertThat(regex.matches(number)).isFalse()
    }

    @Test
    fun `사칙연산과 슷자 그리고 공백을 허용하는 정규식`() {
        val regex = regexForNumberAndOperator
        val correctInput = "1 + 2 * 3 / 4"
        val operator = "/"
        val character = "안녕"
        val specialCharacter = "!"
        val blank = " "

        assertThat(regex.matches(correctInput)).isTrue
        assertThat(regex.matches(operator)).isTrue
        assertThat(regex.matches(character)).isFalse()
        assertThat(regex.matches(specialCharacter)).isFalse()
        assertThat(regex.matches(blank)).isTrue
    }
}
