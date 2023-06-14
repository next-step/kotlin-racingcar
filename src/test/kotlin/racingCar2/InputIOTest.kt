package racingCar2

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class InputIOTest {
    @Test
    fun `입력한 자동차 이름을 쉼표(,) 기준으로 구분한다`() {
        val inputView = InputView()
        inputView.show(InputMessage.CAR_NAMES)

        val inputIO = InputIO()
        val inputString = "BMW,Benz,Audi"
        val carNames = inputIO.inputCarNames(inputString)

        carNames shouldBe listOf("BMW", "Benz", "Audi")
    }
}
