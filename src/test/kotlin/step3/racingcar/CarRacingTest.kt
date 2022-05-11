package step3.racingcar

import org.junit.jupiter.api.Test

class CarRacingTest {
    @Test
    fun `자동차 경주 테스트`() {
        val carCount = (1..9).random()
        val moveCount = (1..15).random()
        CarRacing.execute(carCount, moveCount)
    }
}
