package raicing.processor

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import raicing.model.NaturalNumber
import raicing.model.RaceCar

class RaceProcessorTests {
    private val raceProcessor = RaceProcessor()

    @ParameterizedTest(name = "`{0}`대의 자동차로 `{1}`번의 경주를 진행하면 경주 결과는 `{1}`개이고, 각 결과의 자동차 대수는 `{0}대 이다.")
    @CsvSource(
        value = [
            "3, 5",
            "4, 7",
            "5, 3"
        ]
    )
    fun `입력받은 자동차대수와 경기 횟수를 경기 결과와 비교`(carCount: Int, raceCount: Int) {
        val cars = RaceCar.of(NaturalNumber(carCount.toString()))
        val result = raceProcessor.race(cars, raceCount)

        assertAll(
            "carCount",
            {
                result.raceCars.forEach {
                    assertThat(it.getCars().size).isEqualTo(carCount)
                }
            }
        )
        assertThat(result.raceCars.size).isEqualTo(raceCount)
    }
}
