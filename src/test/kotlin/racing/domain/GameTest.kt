package racing.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test

internal class GameTest {

    @Test
    fun `레이싱 게임 정상 동작`() {
        val nameOfCars = "pobi,crong,honux"
        val cars = Cars.createCars(Cars.splitNameOfCars(nameOfCars))
        val game = Game(cars, 5)
        game.play()
    }

    @Test
    fun `위치가 동일하면 전부 우승 자동차이다`() {
        val nameList = Cars.splitNameOfCars("pobi,crong,honux")
        val cars = Cars.createCars(nameList)
        val game = Game(cars, 0)
        game.play()
        assertThat(game.getWinner(cars).size).isEqualTo(nameList.size)
    }

    @RepeatedTest(5)
    fun `우승 자동차 수는 최소 1 이상이다`() {
        val nameList = Cars.splitNameOfCars("pobi,crong,honux")
        val cars = Cars.createCars(nameList)
        val game = Game(cars, 5)
        game.play()
        assertThat(game.getWinner(cars).size).isGreaterThanOrEqualTo(1)
    }
}
