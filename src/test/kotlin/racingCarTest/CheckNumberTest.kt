package racingCarTest

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingCar.InputIO

class CheckNumberTest {
    @Test
    fun `입력값이 음수일 경우 null 을 리턴한다`() {
        val inputIO = InputIO()
        val negativeValue = inputIO.checkNumber("-1")
        assertThat(negativeValue).isEqualTo(null)
    }

    @Test
    fun `입력값이 양수일 경우 입력한 값을 Int 로 변환하여 리턴한다`() {
        val inputIO = InputIO()

        val positiveValue = inputIO.checkNumber("3")
        assertThat(positiveValue).isEqualTo(3)
    }
}
