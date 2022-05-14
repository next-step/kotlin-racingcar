package racing.application

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racing.model.Car
import racing.model.Round

internal class RefereeTest {

    @Test
    fun `judge test`() {
        val round = Round(
            listOf(
                Car("test1").go(),
                Car("test2").go().go(),
                Car("test3").go().go().go().go(),
                Car("test4").go(),
                Car("test5").go().go().go().go()
            )
        )
        val winner = Referee.judge(round)
        val expected = listOf(
            Car("test3").go().go().go().go(),
            Car("test5").go().go().go().go()
        )

        assertThat(winner).isEqualTo(expected)
    }
}