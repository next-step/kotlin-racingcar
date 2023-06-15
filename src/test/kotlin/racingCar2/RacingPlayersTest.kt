package racingCar2

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class RacingPlayersTest {
    @Test
    fun `우승자 선정 테스트`() {
        val bmwCar = Car("BMW")
        val audiCar = Car("Audi")
        val benzCar = Car("Benz")

        bmwCar.move(5)

        val cars = listOf(bmwCar, audiCar, benzCar)
        val racingPlayers = RacingPlayers(cars)
        val winners = racingPlayers.getWinners()

        winners shouldBe listOf("BMW")
    }
}