package step3.racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CarRacingTest {
    @ParameterizedTest
    @CsvSource(
        value = [
            "5,10",
            "3,3",
            "5,5"
        ],
        delimiter = ','
    )
    fun `자동차 경주 테스트`(carCount: Int, moveCount: Int) {
        val carRacing = CarRacing.execute(carCount, moveCount)
        assertEquals(carRacing.count(), carCount)
        assertEquals(carRacing.flatMap { it.movements }.count(), moveCount.times(carCount))
    }
}
