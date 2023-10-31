package racingcar

import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.verifyOrder
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingGameTest {

    @Test
    fun `자동차 경주 관련 이벤트 발행`() {
        val racingGameEventListener = createMockRacingGameEventListener()
        val racingGame = RacingGame(
            racingGameEventListener,
            createStubRandomGenerator(4, 3, 4, 3, 3, 4, 4, 4, 4), listOf("a", "b", "c")
        )

        racingGame.start(3)

        verifyOrder {
            racingGameEventListener.notify(RacingGameEvent.STARTED, racingGame)
            racingGameEventListener.notify(RacingGameEvent.MOVED, racingGame)
            racingGameEventListener.notify(RacingGameEvent.MOVED, racingGame)
            racingGameEventListener.notify(RacingGameEvent.MOVED, racingGame)
            racingGameEventListener.notify(RacingGameEvent.FINISHED, racingGame)
        }
    }

    @Test
    fun `단일 우승자 조회`() {
        val racingGameEventListener = createMockRacingGameEventListener()
        val racingGame = RacingGame(
            racingGameEventListener,
            createStubRandomGenerator(4, 3, 3, 4, 3, 3, 4, 3, 3), listOf("a", "b", "c")
        )

        racingGame.start(3)

        assertThat(racingGame.winners()).containsExactly("a")
    }

    @Test
    fun `공동 우승자 조회`() {
        val racingGameEventListener = createMockRacingGameEventListener()
        val racingGame = RacingGame(
            racingGameEventListener,
            createStubRandomGenerator(4, 3, 4, 4, 3, 4, 4, 3, 4), listOf("a", "b", "c")
        )

        racingGame.start(3)

        assertThat(racingGame.winners()).containsExactlyInAnyOrder("a", "c")
    }

    private fun createMockRacingGameEventListener(): RacingGameEventListener {
        val racingGameEventListener = mockk<RacingGameEventListener>()
        every { racingGameEventListener.notify(any(), any()) } just Runs
        return racingGameEventListener
    }
}
