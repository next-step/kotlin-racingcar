package racingcar.domain.model

import org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PositionTest {

    @DisplayName("위치는 0보다 크거나 같아야 합니다")
    @Test
    fun position() {
        assertThatExceptionOfType(IllegalArgumentException::class.java)
            .isThrownBy {
                Position(-1)
            }
            .withMessage("위치는 0보다 크거나 같아야 합니다")
    }
}
