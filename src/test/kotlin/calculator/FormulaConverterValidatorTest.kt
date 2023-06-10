package calculator

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class FormulaConverterValidatorTest {
    private val sut = FormulaConverter.Validator

    @Test
    fun `빈 문자열이 전달된다면 예외가 발생한다`() {
        // given
        val emptyString = ""
        // when
        // then
        assertThatThrownBy {
            sut.checkValidInputOrThrows(emptyString)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
