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
    fun `차들 중 가장 멀리 위치한 차가 우승자가 된다`() {
        // given
        val firstCar = Car("car1", 2)
        val secondCar = Car("car2", 4)
        val racingHistories = listOf(RacingHistory(0, listOf(firstCar, secondCar)))

        // when
        val winner = RacingCarGame.getWinners(racingHistories)

        // then
        assertThat(winner.size).isEqualTo(1)
        assertThat(winner.first().name).isEqualTo("car2")
        assertThat(winner.first().position).isEqualTo(4)
    }

    @Test
    fun `5번을 전진시도할 때 게임이 시작되면 0부터 4까지 5개의 게임 기록이 존재해야한다`() {
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
