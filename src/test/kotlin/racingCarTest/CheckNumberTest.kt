package racingCarTest

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingCar.InputIO

class CheckNumberTest {
    @Test
    fun checkNumberTest() {
        val inputIO = InputIO()
        val negativeValue = inputIO.checkNumber("-1")
        assertThat(negativeValue).isEqualTo(null)

        val positiveValue = inputIO.checkNumber("3")
        assertThat(positiveValue).isEqualTo(3)
    }
}
