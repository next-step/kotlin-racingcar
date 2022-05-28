package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.domain.CarHistory
import racingcar.domain.Winner

class WinnerTest {
    @Test
    fun `자동차 경주 게임을 완료한 후 우승자를 알려준다`() {
        val expectWinner = "glenn"
        val lastCarHistory = listOf(
            CarHistory("glenn", 4),
            CarHistory("teo", 2),
            CarHistory("jun", 3)
        )
        val result = listOf(lastCarHistory)
        val winner: List<String> = Winner(result).winner()

        assertThat(winner.first()).isEqualTo(expectWinner)
    }
    @Test
    fun `자동차 경주 게임 우승자는 1명 이상일 수 있다`() {
        val expectCount = 2
        val lastCarHistory = listOf(
            CarHistory("glenn", 4),
            CarHistory("teo", 4),
            CarHistory("jun", 3)
        )
        val result = listOf(lastCarHistory)
        val winner: List<String> = Winner(result).winner()
        val expect = listOf("glenn", "teo")

        assertThat(winner).hasSize(expectCount)
        assertThat(winner).isEqualTo(expect)
    }
}
