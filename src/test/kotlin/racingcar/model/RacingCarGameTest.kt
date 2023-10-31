package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import strategy.FakeMovingStrategy

class RacingCarGameTest {
    @Test
    fun `1회 전진 시 RacingCarGame에 참가한 Car들이 모두 1칸 전진한다`() {
        // given
        val cars = arrayListOf(Car("car1"), Car("car2"))
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
    fun `RacingHistory의 round는 0부터 총 횟수 - 1 까지 생성된다`() {
        // given
        val cars = arrayListOf(Car("myCar"))
        val strategy = FakeMovingStrategy(true)
        val racingCarGame = RacingCarGame(cars, strategy)
        val numbersOfTry = 5
        // when
        val racingHistories = racingCarGame.run(numbersOfTry)
        // then
        assertThat(racingHistories.size).isEqualTo(numbersOfTry)
        assertThat(racingHistories.first().round).isEqualTo(0)
        assertThat(racingHistories.last().round).isEqualTo(numbersOfTry - 1)
    }
}
