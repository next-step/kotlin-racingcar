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
        raceResult.recordRound(1, listOf(RaceCar("name")))
        assertThat(raceResult).isEqualTo(RaceResult(result = mutableMapOf(1 to listOf(RaceCar("name")))))
    }

    @Test
    fun getResults() {
        val resultMap = mutableMapOf(1 to listOf(RaceCar("name")))
        val raceResult = RaceResult(result = resultMap)
        assertThat(raceResult.getResult()).isEqualTo(resultMap.toMap())
    }

    @Test
    fun recordWinners() {
        val raceResult = RaceResult.empty()
        val winners = listOf(RaceCar("name"))
        raceResult.recordWinners(winners)
        assertThat(raceResult.winners).isEqualTo(winners)
    }
}
