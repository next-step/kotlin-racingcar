package racing.application

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racing.model.Car
import racing.model.Round

internal class RefereeTest {

    @Test
    fun `judge test`() {
        //given
        val cars = Round(
            listOf(
                Car("test1").go(),
                Car("test2").go().go(),
                Car("test3").go().go().go().go(),
                Car("test4").go(),
                Car("test5").go().go().go().go()
            )
        )
        val expected = listOf(
            Car("test3").go().go().go().go(),
            Car("test5").go().go().go().go()
        )

        //when
        val winner = Referee.judge(cars)

        //then
        Assertions.assertThat(winner).isEqualTo(expected)
    }
}