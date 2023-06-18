package racingCarMVC

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import racingCarMVC.domain.RacingGameResult
import racingCarMVC.domain.dto.GameRecord

class RacingGameResultTest {
    @Test
    fun `우승자 선정 테스트`() {
        val bmwCar = GameRecord("BMW", 5)
        val audiCar = GameRecord("Audi", 4)
        val benzCar = GameRecord("Benz", 3)

        val players = listOf(bmwCar, audiCar, benzCar)
        val racingGameResult = RacingGameResult(players)
        val winners = racingGameResult.getWinners()

        winners shouldBe listOf("BMW")
    }
}
