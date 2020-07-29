package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.strategy.FairMovingStrategy

internal class ParticipantsTest {
    private val fairMovingStrategy = FairMovingStrategy()
    private val participants = Participants("car1, car2", fairMovingStrategy)

    @BeforeEach
    fun setUp() {
        for (i in 0 until 5) {
            participants.processRound()
        }
    }

    @Test
    fun participantsToString() {
        assertThat(participants.toString()).isEqualTo("No.1 car1 -----\nNo.2 car2 -----\n")
    }

    @Test
    fun findWinners() {
        assertThat(participants.findWinner()).isEqualTo(
            listOf(
                Car(1, "car1", fairMovingStrategy),
                Car(2, "car2", fairMovingStrategy)
            )
        )
    }
}
