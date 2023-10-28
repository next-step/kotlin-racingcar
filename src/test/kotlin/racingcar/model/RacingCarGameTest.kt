package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.strategy.UnconditionalMovingStrategy

class RacingCarGameTest {
    @Test
    fun `1회 전진`() {
        val cars = arrayListOf(Car("myCar"), Car("secondCar"))
        val strategy = UnconditionalMovingStrategy()
        val racingCarGame = RacingCarGame(cars, strategy)
        racingCarGame.run()
        val afterRunCars = racingCarGame.cars
        assertThat(afterRunCars.size).isEqualTo(2)
        assertThat(afterRunCars[0].name).isEqualTo("myCar")
        assertThat(afterRunCars[0].position).isEqualTo(1)
        assertThat(afterRunCars[1].name).isEqualTo("secondCar")
        assertThat(afterRunCars[1].position).isEqualTo(1)
    }
}
