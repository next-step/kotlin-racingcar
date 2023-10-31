package carRacing

import carRacing.domain.Car
import carRacing.domain.Racing
import carRacing.testcontroller.TestCarController
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class RacingTest {

    @ParameterizedTest
    @CsvSource("2, 1", "2, 2", "2, 3")
    fun `Racing 결과를 반환`(carCount: Int, tryCount: Int) {
        val moveRacing = Racing(TestCarController())
        val result: List<Car> = moveRacing.getRaceResult(carCount, tryCount)

        assertThat(result.size).isEqualTo(carCount)
    }
}
