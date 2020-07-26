package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.Racing.isRunnable

class RacingTest {

    @Test
    fun `is not runnable when randomNum is between 0 and 3`() {
        for(i in 0..1)
            RacingCarFactory.makeCar()
        val cars = RacingCarFactory.cars
        cars[0].randomNum = 0
        cars[1].randomNum = 3
        assertThat(isRunnable(0)).isEqualTo(false)
        assertThat(isRunnable(1)).isEqualTo(false)
    }

    @Test
    fun `is runnable when randomNum is between 4 and 9`() {
        for(i in 0..1)
            RacingCarFactory.makeCar()
        val cars = RacingCarFactory.cars
        cars[0].randomNum = 4
        cars[1].randomNum = 9
        assertThat(isRunnable(0)).isEqualTo(true)
        assertThat(isRunnable(1)).isEqualTo(true)
    }
}