package racingcar.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.mock.AlwaysForwardRacingCarForwardCondition

class RacingCarGameTest {

    @Test
    fun `RacingCarGame 기능 테스트`() {
        // given
        val gameCount = GameCount(5)
        val condition = AlwaysForwardRacingCarForwardCondition()
        val carList = listOf(
            Car(carName = CarName("pobi"), condition = condition),
            Car(carName = CarName("crong"), condition = condition),
            Car(carName = CarName("honux"), condition = condition)
        )
        val cars = Cars(carList)
        val game = RacingCarGame(gameCount = gameCount, cars = cars)

        // when
        val expected = game.startGame()

        // then
        val actual = RacingCarGameResult(
            gameCount = gameCount,
            snapshots = List(gameCount.count) { round ->
                RacingCarSnapshot(
                    round = round + 1,
                    cars = carList.map { it.copy(position = round + 1) }
                )
            },
            winnerCars = cars.filterWinners()
        )
        assertEquals(expected, actual)
    }
}
