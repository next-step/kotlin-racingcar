package raicing.processor

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import raicing.model.CarName
import raicing.model.RaceCar

class RaceProcessorTests {
    private val raceProcessor = RaceProcessor()

    @Test
    fun `5대의 자동차로 7번의 경주를 진행하면 경주 결과는 7개 이고, 각 결과의 자동차 대수는 5대이다`() {
        val carNames = listOf(
            CarName("a"),
            CarName("b"),
            CarName("c"),
            CarName("d"),
            CarName("e")
        )
        val raceCar = RaceCar.of(carNames)
        val raceCount = 7
        val result = raceProcessor.race(raceCar, raceCount)

        assertAll(
            "carCount",
            {
                result.raceCars.forEach {
                    assertThat(it.getCars().size).isEqualTo(raceCar.getCars().size)
                }
            }
        )
        assertThat(result.raceCars.size).isEqualTo(raceCount)
    }
}
