package raicing.view

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource
import raicing.Const
import java.io.ByteArrayInputStream

class InputViewTests {

    @ParameterizedTest(name = "입력값이 `{0}` 이면 성공")
    @CsvSource(
        value = [
            "'1', 1",
            "'10', 10"
        ]
    )
    fun `입력받은 데이터 valid 체크 - 성공`(inputStr: String?, expected: Int) {
        System.setIn(ByteArrayInputStream(inputStr?.toByteArray()))
        val result = InputView.readStrAndConvertToInt("Test Input")
        assertThat(result).isEqualTo(expected)
    }

    @ParameterizedTest(name = "입력값이 `{0}` 이면 IllegalArgumentException 발생")
    @EmptySource
    @ValueSource(strings = ["  ", "\t", "0", "3.1", "-2", "a"])
    fun `입력받은 데이터 valid 체크 - 실패`(inputStr: String?) {
        System.setIn(ByteArrayInputStream(inputStr?.toByteArray()))
        Assertions.assertThatIllegalArgumentException()
            .isThrownBy { InputView.readStrAndConvertToInt("Test Input") }
            .withMessage(Const.ErrorMsg.INPUT_IS_NOT_NATURAL_NUMBER_ERROR_MSG)
    }
}
