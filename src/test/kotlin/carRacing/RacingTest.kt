package carRacing

import carRacing.domain.Car
import carRacing.domain.Racing
import carRacing.serviceimpl.SimpleCarFactory
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RacingTest {

    @ParameterizedTest
    @CsvSource("2, 1", "2, 2", "2, 3")
    fun `Racing 결과에서 반환하는 자동차 List의 길이는 carCount와 동일하다`(carCount: Int, tryCount: Int) {
        val moveRacing = Racing(SimpleCarFactory())
        val result: List<Car> = moveRacing.getRaceResult(carCount, tryCount)

        assertThat(result.size).isEqualTo(carCount)
    }
}
