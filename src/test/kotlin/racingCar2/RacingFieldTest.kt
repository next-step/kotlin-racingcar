package racingCar2

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class RacingFieldTest {
    @Test
    fun `경주할 자동자의 이름을 입력받고 이름의 수만큼 자동차가 생성된다`() {
        val carNames = listOf("BMW", "Benz", "Audi")
        val racingField = RacingField(*carNames.toTypedArray())

        racingField.carNames shouldBe carNames
    }
}
