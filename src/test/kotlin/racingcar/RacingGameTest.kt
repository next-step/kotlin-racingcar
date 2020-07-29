package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.domain.Car
import racingcar.strategy.FairMovingStrategy

internal class RacingGameTest {
    private val fairMovingStrategy = FairMovingStrategy()
    private val game = RacingGame("a, b, c", 3, fairMovingStrategy)

    @BeforeEach
    fun setUp() {
        while (game.isProgress()) {
            game.startRound()
        }
    }

    @Test
    fun findWinners() {
        assertThat(game.findWinners()).isEqualTo(
            listOf(
                Car(1, "a", fairMovingStrategy),
                Car(2, "b", fairMovingStrategy),
                Car(3, "c", fairMovingStrategy)
            )
        )
    }

    @Test
    fun isProgress() {
        assertThat(game.isProgress()).isFalse()
    }
}
