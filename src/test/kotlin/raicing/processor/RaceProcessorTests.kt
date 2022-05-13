package raicing.processor

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class RaceProcessorTests {
    private val raceProcessor = RaceProcessor()

    @ParameterizedTest(name = "자동차 대수가 `{0}` 이면, cars의 size도 `{0}` 이다.")
    @ValueSource(ints = [3, 5, 1])
    fun `입력받은 자동차의 대수만큼 자동차 리스트의 길이가 만들어져야 한다`(carCount: Int) {
        val cars = raceProcessor.initCars(carCount)
        assertThat(cars.size).isEqualTo(carCount)
    }

    @ParameterizedTest
    @CsvSource(
        value = [
            "3, 5",
            "4, 7",
            "5, 3"
        ]
    )
    fun `입력받은 자동차 대수, 시도횟수가 경기 결과 리스트 값의 size와 같아야한다`(carCount: Int, raceCount: Int) {
        val cars = raceProcessor.initCars(carCount)
        val result = raceProcessor.race(cars, raceCount)

        assertAll(
            "carCount",
            {
                result.forEach {
                    assertThat(it.cars.size).isEqualTo(carCount)
                }
            }
        )
        assertThat(result.size).isEqualTo(raceCount)
    }
}
