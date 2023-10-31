package game.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class HistoryTest {

    @Test
    fun `라운드 자동차 히스트로를 추가한다`() {
        // given
        val history = History()

        // when
        val newHistory = history.addRound(listOf(Car.of("a"), Car.of("b")))

        // then
        assertAll(
            { assert(newHistory.rounds.size == 1) },
            { assert(newHistory.rounds[0].size == 2) },
            { assert(newHistory.rounds[0][0].name == "a") },
            { assert(newHistory.rounds[0][1].name == "b") }
        )
    }

    @Test
    fun `winner를 세팅한다`() {
        // given
        val history = History()

        // when
        val newHistory = history.setWinners(listOf("a", "b"))

        // then
        assertAll(
            { assert(newHistory.winners.size == 2) },
            { assert(newHistory.winners[0] == "a") },
            { assert(newHistory.winners[1] == "b") }
        )
    }
}
