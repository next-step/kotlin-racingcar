package racing

import RacingGame
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RacingGameTest {
    @Test
    fun `자동차 경주 테스트`() {
        val car1 = Car("Car1")
        val car2 = Car("Car2")
        val car3 = Car("Car3")

        val carList = listOf(car1, car2, car3)
        val racingGame = RacingGame(carList, RacingMovingRule(5))

        racingGame.goRacing()

        assertTrue(car1.route >= 0)
        assertTrue(car2.route >= 0)
        assertTrue(car3.route >= 0)
    }
}
