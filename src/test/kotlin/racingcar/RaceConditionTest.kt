package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.exception.Exception
import racingcar.exception.Exception.Companion.CASE_INPUT_DATA_WRONG
import racingcar.model.CarName
import racingcar.model.RaceCondition

class RaceConditionTest {
    @Test
    @DisplayName("레이스 조건 객체 생성 테스트")
    fun `check race condition data class`() {
        val item = RaceCondition(listOf(CarName("1")), 2)

        Assertions.assertThat(item).isEqualTo(RaceCondition(listOf(CarName("1")), 2))
        Assertions.assertThat(item.carsName).isEqualTo(listOf(CarName("1")))
        Assertions.assertThat(item.tryCount).isEqualTo(2)
    }

    @Test
    @DisplayName("레이싱 조건이 옳바르지 않은 경우")
    fun `check validation of race condition of car names`() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { RaceCondition(listOf(), 2) }
            .withMessage(CASE_INPUT_DATA_WRONG)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1, -100])
    @DisplayName("레이싱 조건이 옳바르지 않은 경우")
    fun `check validation of race condition of try count`(tryCount: Int) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { RaceCondition(listOf(), tryCount) }
            .withMessage(Exception.CASE_ZERO_RACING_ROUND)
    }
}
