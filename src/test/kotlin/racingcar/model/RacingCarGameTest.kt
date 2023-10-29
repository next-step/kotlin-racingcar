package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import strategy.FakeMovingStrategy

class RacingCarGameTest {
    @Test
    fun `1회 전진 시 RacingCarGame에 참가한 Car들이 모두 1칸 전진한다`() {
        // given
        val cars = arrayListOf(Car("myCar"), Car("secondCar"))
        val strategy = FakeMovingStrategy(true)
        val racingCarGame = RacingCarGame(cars, strategy)
        // when
        racingCarGame.run(1)
        // then
        val afterRunCars = racingCarGame.cars
        assertThat(afterRunCars.size).isEqualTo(2)
        assertThat(afterRunCars[0].position).isEqualTo(1)
        assertThat(afterRunCars[1].position).isEqualTo(1)
    }

    @Test
    fun `시행 횟수만큼 RacingHistory 가 생성된다`() {
        // given
        val cars = arrayListOf(Car("myCar"))
        val strategy = FakeMovingStrategy(true)
        val racingCarGame = RacingCarGame(cars, strategy)
        val numbersOfTry = 5
        // when
        val racingHistories = racingCarGame.run(numbersOfTry)
        // then
        assertThat(racingHistories.size).isEqualTo(numbersOfTry)
        assertThat(racingHistories.last().round).isEqualTo(numbersOfTry)
    }
}
