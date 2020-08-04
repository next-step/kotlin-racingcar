package RacingCarRefactoryTest

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import RacingcarWinner.Domain.Car

import org.assertj.core.api.Assertions.assertThat

class RacingWinnerReTest {
    @Test
    @DisplayName("이름과 진행사항 저장")
    fun cars() {
        val cartest = Car("joseph")
        assertThat(cartest.position.toInt()).isEqualTo(0)
    }
}


