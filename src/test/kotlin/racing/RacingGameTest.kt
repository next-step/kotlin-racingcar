package racing

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racing.domain.Car
import racing.domain.CarName
import racing.domain.RacingGame
import racing.domain.RacingMovingRule

class RacingGameTest {
    @ValueSource(ints = [1, 7])
    @ParameterizedTest
    fun `자동차 경주에 전체 자동차가 움직이는 횟수를 정할 수 있다`(count: Int) {
        val racingMovingRule = RacingMovingRule(count)
        Assertions.assertEquals(racingMovingRule.movingCount, count)
    }

    @Test
    fun `여러대의 자동차가 경주를 시작하면 이동거리가 0이상 이여한다`() {
        val car1 = Car(CarName("car1"))
        val car2 = Car(CarName("car2"))
        val car3 = Car(CarName("car3"))

        val carList = listOf(car1, car2, car3)
        val racingGame = RacingGame(carList, RacingMovingRule(5))

        racingGame.goRacing()

        Assertions.assertTrue(car1.route >= 0)
        Assertions.assertTrue(car2.route >= 0)
        Assertions.assertTrue(car3.route >= 0)
    }
}
