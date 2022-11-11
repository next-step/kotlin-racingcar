package racing.domain

import org.junit.jupiter.api.Test

internal class GameTest {

    @Test
    fun `레이싱 게임 정상 동작`() {
        val nameOfCars = "pobi,crong,honux"
        val cars = Cars.createCars(nameOfCars)
        val game = Game(cars, 5)
        game.play()
    }
}
