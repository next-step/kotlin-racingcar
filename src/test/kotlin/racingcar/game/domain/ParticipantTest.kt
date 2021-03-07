package racingcar.game.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ParticipantTest {
    @Test
    fun `1라운드 지났을 때 결과 검증`() {
        // given
        val participant = Participant(listOf("test1", "test2", "test3"))

        // when
        participant.moveCars { 5 }

        // then
        assertThat(participant.cars.size).isEqualTo(3)
        assertThat(participant.cars)
            .extracting("position")
            .containsOnly(1)
    }

    @Test
    fun `3라운드 지났을 때 결과 검증`() {
        // given
        val participant = Participant(listOf("test1", "test2", "test3"))

        // when

        (0..2).forEach { participant.moveCars { 5 } }

        // then
        assertThat(participant.cars.size).isEqualTo(3)
        assertThat(participant.cars)
            .extracting("position")
            .containsOnly(3)
    }
}
