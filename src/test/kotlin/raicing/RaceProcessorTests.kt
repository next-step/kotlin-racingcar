package raicing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import raicing.processor.RaceProcessor

class RaceProcessorTests {
    private val raceProcessor = RaceProcessor()

    @Test
    fun `입력받은 자동차 대수, 시도횟수가 경기 결과 리스트 값의 size와 같아야한다`() {
        val carCount = 3
        val raceCount = 5

        val result = raceProcessor.raceStart(carCount, raceCount)

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
