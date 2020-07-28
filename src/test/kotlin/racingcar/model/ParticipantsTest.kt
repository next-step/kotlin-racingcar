package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.strategy.FairMovingStrategy

internal class ParticipantsTest {
    private val participants = Participants("car1, car2", FairMovingStrategy())

    @BeforeEach
    fun setUp() {
        for (i in 0 until 5) {
            participants.processRound()
        }
    }

    @Test
    fun getMovingStatus() {
        assertThat(participants.getMovingStatus()).isEqualTo("No.1 car1 -----\nNo.2 car2 -----\n")
    }
}
