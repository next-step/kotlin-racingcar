package racingCarMVC

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import racingCarMVC.domain.RacingField
import racingCarMVC.domain.dto.GameResult
import racingCarMVC.domain.dto.GameRecord

class RacingFieldTest {
    @Test
    fun `경주할 자동자의 이름을 입력받고 이름의 수만큼 자동차가 생성된다`() {
        val carNames = arrayOf("BMW", "Benz", "Audi")
        val racingField = RacingField(carNames, 1)

        racingField.carNames shouldBe carNames
    }

    @Test
    fun `경기장은 시도할 횟수를 갖는다`() {
        val carNames = arrayOf("BMW", "Benz", "Audi")
        val gameCount = 3
        val racingField = RacingField(carNames, gameCount)

        racingField.gameCount shouldBe 3
    }

    @Test
    fun `경주를 진행하고 경기 결과를 리턴한다`() {
        val carNames = arrayOf("BMW", "Benz", "Audi")
        val gameCount = 3
        val racingField = RacingField(carNames, gameCount)

        val gameResult = listOf(
            GameResult(listOf(GameRecord("BMW", 1), GameRecord("Benz", 1), GameRecord("Audi", 1))),
            GameResult(listOf(GameRecord("BMW", 2), GameRecord("Benz", 2), GameRecord("Audi", 2))),
            GameResult(listOf(GameRecord("BMW", 3), GameRecord("Benz", 3), GameRecord("Audi", 3))),
        )

        racingField.startRacing(FixedNumberGenerator(7)) shouldBe gameResult
    }
}
