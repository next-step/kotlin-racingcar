package racingcar.domain

import org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class TryGamesTest {

    @DisplayName("경주는 1회 이상이어야 합니다")
    @Test
    fun name() {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy {
                TryGames(count = 0)
            }
            .withMessage("경주는 1회 이상이어야 합니다")
    }
}
