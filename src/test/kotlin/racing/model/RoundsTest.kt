package racing.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RoundsTest {

    @Test
    fun `put and get test`() {
        //given
        val roundNo = 5
        val expectedRound = Round(
            listOf(
                Car("testName").go(),
                Car("testName").go(),
                Car("testName"),
                Car("testName"),
                Car("testName").go()
            )
        )
        val rounds = Rounds()

        //when
        rounds.put(roundNo, expectedRound)

        //then
        assertThat(rounds.get(roundNo))
            .isEqualTo(expectedRound)
    }
}