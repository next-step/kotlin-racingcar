package game.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class GameControllerTest {

    @Test
    fun `시도 횟수 만큼 CarFleet를 전진시키고 횟수만큼 history에 저장한다`() {
        // given
        val carFleet = CarFleet(Cars(Car.from(listOf("a", "b", "c"))), FixedMoveConditionGenerator(5))
        val gameController = GameController()

        // when
        val history = gameController.playGame(3, carFleet)

        // then
        assertAll(
            { assertThat(history.rounds.size).isEqualTo(3) },
            { assertThat(history.rounds[0].carList.all { it.position == 1 }).isTrue() },
            { assertThat(history.rounds[1].carList.all { it.position == 2 }).isTrue() },
            { assertThat(history.rounds[2].carList.all { it.position == 3 }).isTrue() },
        )
    }
}
