package racingCar2

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class InputIOTest {
    @Test
    fun `입력한 자동차 이름을 쉼표(,) 기준으로 구분한다`() {
        val inputIO = InputIO()
        val inputString = "BMW,Benz,Audi"
        val carNames = inputIO.inputCarNames(inputString)

        carNames shouldBe listOf("BMW", "Benz", "Audi")
    }

    @Test
    fun `시도할 횟수를 입력받는다`() {
        val inputIO = InputIO()
        val inputNumber = 5
        val gameCount = inputIO.inputGameCount(inputNumber)

        gameCount shouldBe 5
    }

    @Test
    fun `시도할 횟수는 양수만 입력받는다`() {
        val inputIO = InputIO()
        val inputNumber = -5

        shouldThrow<IllegalStateException> {
            inputIO.inputGameCount(inputNumber)
        }
    }
}
