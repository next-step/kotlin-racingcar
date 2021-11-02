package racingcar

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.util.Validation

class CarValidationTest {
    @ParameterizedTest
    @ValueSource(strings = ["4", "5", "6", "7", "8", "9"])
    fun `자동차를 한칸 전진한다`(input: String) {
        Assertions.assertTrue(Validation.isMatchStartCondition(input.toInt()))
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, -2, -3, 0])
    fun `입력값이 0보다 큰 정수가 아니다`(input: Int) {
        Assertions.assertFalse(Validation.isPositiveNumber(input))
    }

    @ParameterizedTest
    @ValueSource(strings = ["sanghun"])
    fun `자동차 이름은 5자를 초과할 수 없다`(input: String) {
        assertThatThrownBy {
            Validation.checkNameCountCondition(input)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}
