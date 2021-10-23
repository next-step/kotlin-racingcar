package racingcar

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.util.CarValidation

class CarValidationTest {
    @ParameterizedTest
    @ValueSource(strings = ["4", "5", "6", "7", "8", "9"])
    fun `자동차를 한칸 전진한다`(input: String) {
        Assertions.assertTrue(CarValidation.isMatchCondition(input.toInt()))
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, -2, -3, 0])
    fun `입력값이 0보다 큰 정수가 아니다`(input: Int) {
        Assertions.assertFalse(CarValidation.isPositiveNumber(input))
    }
}
