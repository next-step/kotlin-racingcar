package raicing.view

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource
import raicing.Const
import raicing.model.NaturalNumber
import java.io.ByteArrayInputStream

class InputViewTests {

    @ParameterizedTest(name = "입력값이 `{0}` 이면 성공")
    @CsvSource(
        value = [
            "'1', 1",
            "'10', 10"
        ]
    )
    fun `입력받은 데이터 valid 체크 - 성공`(inputStr: String?, expected: String) {
        System.setIn(ByteArrayInputStream(inputStr?.toByteArray()))
        val result = InputView.readStrAndConvertToNaturalNum("Test Input")
        assertThat(result).isEqualTo(NaturalNumber(expected))
    }

    @ParameterizedTest(name = "입력값이 `{0}` 이면 IllegalArgumentException 발생")
    @EmptySource
    @ValueSource(strings = ["  ", "\t",])
    fun `입력받은 데이터 valid 체크 - null이거나 empty이면 실패`(inputStr: String?) {
        System.setIn(ByteArrayInputStream(inputStr?.toByteArray()))
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { InputView.readStrAndConvertToNaturalNum("Test Input") }
            .withMessage(Const.ErrorMsg.INPUT_IS_EMPTY_ERROR_MSG)
    }

    @ParameterizedTest(name = "입력값이 `{0}` 이면 IllegalArgumentException 발생")
    @ValueSource(strings = ["0", "3.1", "-2", "a"])
    fun `입력받은 데이터 valid 체크 - 자연수가 아니면 실패`(inputStr: String?) {
        System.setIn(ByteArrayInputStream(inputStr?.toByteArray()))
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { InputView.readStrAndConvertToNaturalNum("Test Input") }
            .withMessage(Const.ErrorMsg.INPUT_IS_NOT_NATURAL_NUMBER_ERROR_MSG)
    }
}
