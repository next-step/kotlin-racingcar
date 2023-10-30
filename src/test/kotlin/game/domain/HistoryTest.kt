package game.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class HistoryTest {

    @Test
    fun `라운드 자동차 히스트로를 추가한다`() {
        // given
        val history = History()

        // when
        history.addRound(listOf(Car.of("a"), Car.of("b")))

        // then
        assertAll(
            { assert(history.rounds.size == 1) },
            { assert(history.rounds[0].size == 2) },
            { assert(history.rounds[0][0].name == "a") },
            { assert(history.rounds[0][1].name == "b") }
        )
    }

    @Test
    fun `winner를 세팅한다`() {
        // given
        val history = History()

        // when
        history.setWinners(listOf("a", "b"))

        // then
        assertAll(
            { assert(history.winners.size == 2) },
            { assert(history.winners[0] == "a") },
            { assert(history.winners[1] == "b") }
        )
    }
}
