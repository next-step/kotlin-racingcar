package racingCar2

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

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
    fun `경주를 진행하고 최종 우승자를 찾는다`() {
        val carNames = arrayOf("BMW", "Benz", "Audi")
        val gameCount = 3
        val racingField = RacingField(carNames, gameCount)
        val winners = racingField.racingStart(FixedNumberGenerator(7))

        winners shouldBe carNames
    }
}
