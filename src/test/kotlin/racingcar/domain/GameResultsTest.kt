package racingcar.domain

import org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class GameResultsTest {

    @DisplayName("게임 결과가 존재해야 합니다")
    @Test
    fun gameResult() {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy {
                GameResults(emptyList())
            }
            .withMessage("게임 결과가 존재해야 합니다")
    }
}
