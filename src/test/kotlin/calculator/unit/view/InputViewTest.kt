package calculator.unit.view

import calculator.view.InputView
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test

class InputViewTest {

    @Test
    fun `수식이 입력되지 않으면 예외가 발생한다`() {
        assertThrows(IllegalArgumentException::class.java) {
            InputView.input { "" }
        }
    }

    @Test
    fun `수식이 공백이면 예외가 발생한다`() {
        assertThrows(IllegalArgumentException::class.java) {
            InputView.input { " " }
        }
    }
}
