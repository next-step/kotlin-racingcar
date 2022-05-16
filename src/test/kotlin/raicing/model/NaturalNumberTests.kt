package raicing.model

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import raicing.Const

class NaturalNumberTests {
    @ParameterizedTest(name = "입력값이 `{0}` 이면 IllegalArgumentException 발생")
    @ValueSource(strings = [" ", "\t", "a", "0", "-3", "3.2"])
    fun `입력값이 자연수가 아니면 실패 - IllegalArgumentException 발생`(numberStr: String) {
        assertThatIllegalArgumentException()
            .isThrownBy { NaturalNumber(numberStr) }
            .withMessage(Const.ErrorMsg.INPUT_IS_NOT_NATURAL_NUMBER_ERROR_MSG)
    }

    @ParameterizedTest(name = "입력값이 `{0}` 이면 성공")
    @ValueSource(strings = ["3", "1", "100", "24"])
    fun `입력값이 자연수이면 성공`(numberStr: String) {
        assertDoesNotThrow { NaturalNumber(numberStr) }
    }

    @ParameterizedTest
    @CsvSource(
        value =
        [
            "'3', 3",
            "'1', 1",
            "'100', 100",
            "'24', 24"
        ]
    )
    fun `입력받은 NaturalNumber값을 Int로 변환`(numberStr: String, expected: Int) {
        val result = NaturalNumber(numberStr).toInt()
        assertThat(result).isEqualTo(expected)
    }
}
