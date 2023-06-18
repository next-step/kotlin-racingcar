package racingCarMVC

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import racingCarMVC.domain.dto.Player
import racingCarMVC.domain.RacingPlayers

class RacingPlayersTest {
    @Test
    fun `우승자 선정 테스트`() {
        val bmwCar = Player("BMW",5)
        val audiCar = Player("Audi",4)
        val benzCar = Player("Benz",3)

        val players = listOf(bmwCar, audiCar, benzCar)
        val racingPlayers = RacingPlayers(players)
        val winners = racingPlayers.getWinners()

        winners shouldBe listOf("BMW")
    }
}