package racingcar.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.exception.Exception

class RoundTest {
    @Test
    @DisplayName("라운드 객체 생성 테스트")
    fun `check round data class`() {
        val item = Round(3, RacingCars(listOf(Car(CarName("밤"), 3))))

        Assertions.assertThat(item.roundResult).isEqualTo(listOf(Car(CarName("밤"), 3)))
        Assertions.assertThat(item.round).isEqualTo(3)
    }

    @Test
    @DisplayName("라운드 숫자가 옳바르지 않은 경우")
    fun `check validation of round condition of round`() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Round(-1, RacingCars(listOf(Car(CarName("밤"), 3)))) }
            .withMessage(Exception.CASE_ZERO_RACING_ROUND)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1, -100])
    @DisplayName("라운드 결과가 옳바르지 않은 경우")
    fun `check validation of round condition of result`(tryCount: Int) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy { Round(4, RacingCars(listOf())) }
            .withMessage(Exception.CASE_ZERO_WINNER)
    }
}
