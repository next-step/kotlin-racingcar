package raicing.processor

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertAll
import raicing.model.RaceCar

class RaceProcessorTests {
    private val raceProcessor = RaceProcessor()

    fun `5대의 자동차로 7번의 경주를 진행하면 경주 결과는 7개 이고, 각 결과의 자동차 대수는 5대이다`() {
        val cars = RaceCar.of(listOf("a", "b", "c", "d", "e"))
        val raceCount = 7
        val result = raceProcessor.race(cars, raceCount)

        assertAll(
            "carCount",
            {
                result.raceCars.forEach {
                    assertThat(it.getCars().size).isEqualTo(cars.getCars().size)
                }
            }
        )
        assertThat(result.raceCars.size).isEqualTo(raceCount)
    }
}
