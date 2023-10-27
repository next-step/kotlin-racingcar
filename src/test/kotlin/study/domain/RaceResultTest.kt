package study.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RaceResultTest {
    @Test
    fun empty() {
        assertThat(RaceResult.empty()).isEqualTo(RaceResult())
    }

    @Test
    fun recordRound() {
        val raceResult = RaceResult.empty()
        raceResult.recordRound(1, listOf(RaceCar()))
        assertThat(raceResult).isEqualTo(RaceResult(mutableMapOf(1 to listOf(RaceCar()))))
    }

    @Test
    fun getRounds() {
        val raceResult = RaceResult(mutableMapOf(1 to listOf(RaceCar())))
        assertThat(raceResult.getRounds()).isEqualTo(listOf(1))
    }

    @Test
    fun getCarPositions() {
        val raceResult = RaceResult(mutableMapOf(1 to listOf(RaceCar())))
        assertThat(raceResult.getCarPositions(1)).isEqualTo(listOf(0))
    }
}
