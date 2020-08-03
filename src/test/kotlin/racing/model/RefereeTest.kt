package racing.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RefereeTest {
    @Test
    fun `우승자 판별 test`() {
        val raceCars = listOf(
            Car("a", mutableListOf(0, 1, 1, 1, 1)),
            Car("b", mutableListOf(1, 0, 0, 0, 1)),
            Car("c", mutableListOf(1, 1, 1, 1, 1)),
            Car("d", mutableListOf(1, 1, 1, 1, 1)),
            Car("e", mutableListOf(1, 1, 1, 0, 1))
        )

        assertThat(Referee().getWinner(raceCars)).containsExactlyInAnyOrderElementsOf(
            mutableListOf(
                Car("c", mutableListOf(1, 1, 1, 1, 1)),
                Car("d", mutableListOf(1, 1, 1, 1, 1))
            )
        )
    }
}
