package racing

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class RacingCarTest {
    // @Test
    // fun `race를 수행하면 현재 라운드가 1 증가한다`() {
    //     val car = RacingCar(3)
    //     car.race()
    //
    //     Assertions.assertThat(car.currentRound).isEqualTo(1)
    // }

    @Test
    fun `시도한 횟수만큼 race를 수행하면 자동차의 거리 결과는 0 과 1을 포함한 배열이다`() {
        val tryRound = 3
        val car = RacingCar(tryRound)
        for (round in 0 until tryRound) {
            car.race(createRandom(1))
        }

        val distances = car.getDistances()

        Assertions.assertThat(distances).containsAnyOf(0, 1)
    }

    private fun createRandom(returnValue: Int): Int {
        return returnValue
    }
}
