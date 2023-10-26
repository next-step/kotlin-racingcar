package calculator.application

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ConverterTest {

    private val converter: Converter = Converter()

    @Test
    fun `infix 표기법 profix 표기법으로 수정`() {
        //given
        val infixTokens: List<String> = listOf("1", "+", "2", "-", "3")

        //when
        val actual = converter.covertToPostfix(infixTokens)

        //then
        assertThat(actual).isNotNull
        assertThat(actual).isNotEmpty
        assertThat(actual).isEqualTo(listOf("1", "2", "3", "-", "+"))
    }
}
