package calculator

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class FormulaConverterValidatorTest {
    private val sut = FormulaConverterValidator

    @Test
    fun `빈 문자열이 전달된다면 예외가 발생한다`() {
        // given
        val emptyString = ""
        // when
        // then
        assertThatThrownBy {
            sut.checkValidateFormulaOrThrows(emptyString)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `숫자가 포함되지 않은 문자열이 전달된다면 예외가 발생한다`() {
        // given
        val noFormulaString = " "
        // when
        // then
        assertThatThrownBy {
            sut.checkValidateFormulaOrThrows(noFormulaString)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `공백을 기준으로 문자열을 분리했을 때 짝수번째 위치한 값이 수가 아니라면 예외가 발생한다`() {
        // given
        val formulaString = "1 + +"
        // when
        // then
        assertThatThrownBy {
            sut.checkValidateFormulaOrThrows(formulaString)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `공백을 기준으로 문자열을 분리했을 때 홀수번째 위치한 값이 Operation 에 해당하지 않는다면 예외가 발생한다`() {
        // given
        val formulaString = "1 x 1"
        // when
        // then
        assertThatThrownBy {
            sut.checkValidateFormulaOrThrows(formulaString)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `공백을 기준으로 문자열을 분리했을때 짝수개로 분리된다면 예외가 발생한다`() {
        // given
        val formulaString = "1 + 1 -"
        // when
        // then
        assertThatThrownBy {
            sut.checkValidateFormulaOrThrows(formulaString)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
