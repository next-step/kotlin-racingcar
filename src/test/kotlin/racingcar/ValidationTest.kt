package racingcar

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.extension.StringExtension.isIntType
import racingcar.util.Validation

class ValidationTest {
    @ParameterizedTest
    @ValueSource(strings = ["4", "5", "6", "7", "8", "9"])
    fun `자동차 전진하기 조건인 경우`(input: String) {
        Assertions.assertTrue(Validation.isMatchCondition(input.toInt()))
    }

    @ParameterizedTest
    @ValueSource(strings = ["", " ", "한글", "english", "!", "12#$"])
    fun `입력값이 숫자가 아닌 경우`(input: String) {
        Assertions.assertFalse(input.isIntType())
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, -2, -3, 0])
    fun `입력값이 0또는 음수인 경우`(input: Int) {
        Assertions.assertFalse(Validation.isPositiveNumber(input))
    }
}
