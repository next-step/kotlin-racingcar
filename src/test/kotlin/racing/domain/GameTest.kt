package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import racing.view.GameOutputView

internal class GameTest {

    @Test
    fun `레이싱 게임 정상 동작`() {
        val nameList = listOf("pobi", "crong", "honux")
        val cars = CarsFactory.createCars(nameList)
        val game = Game(cars, 5)
        game.play { GameOutputView.printRaceStatus(it) }
    }

    @Test
    fun `위치가 동일하면 전부 우승 자동차이다`() {
        val nameList = listOf("pobi", "crong", "honux")
        val cars = CarsFactory.createCars(nameList)
        val game = Game(cars, 0)
        val gameResult = game.play { GameOutputView.printRaceStatus(it) }
        assertThat(gameResult.getWinner().size).isEqualTo(nameList.size)
    }

    @RepeatedTest(5)
    fun `우승 자동차 수는 최소 1 이상이다`() {
        val nameList = listOf("pobi", "crong", "honux")
        val cars = CarsFactory.createCars(nameList)
        val game = Game(cars, 5)
        val gameResult = game.play { GameOutputView.printRaceStatus(it) }
        assertThat(gameResult.getWinner().size).isGreaterThanOrEqualTo(1)
    }
}
