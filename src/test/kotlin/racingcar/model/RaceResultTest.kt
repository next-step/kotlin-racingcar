package racingcar.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import racingcar.exception.Exception

class RaceResultTest {
    @Test
    @DisplayName("레이스 결과 객체 생성 테스트")
    fun `check race result data class`() {
        val item = RaceResult(
            listOf(Round(0, RacingCars(listOf(Car(CarName("밤"), 3))))),
            listOf(CarName("이름"))
        )

        Assertions.assertThat(item.roundList.size).isEqualTo(1)
        Assertions.assertThat(item.winners.size).isEqualTo(1)
    }

    @Test
    @DisplayName("레이싱 결과의 라운드 리스트 조건이 옳바르지 않은 경우")
    fun `check validation of race result of round list`() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { RaceResult(listOf(), listOf()) }
            .withMessage(Exception.CASE_INCORRECT_RESULT)
    }
}
