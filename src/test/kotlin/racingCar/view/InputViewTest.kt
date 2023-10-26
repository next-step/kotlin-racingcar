package racingCar.view

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullSource
import racingCar.error.ErrorMessage

class InputViewTest {
    @Test
    fun inputStringTest() {
        val inputView = InputView()

        val assertThrows = assertThrows<IllegalArgumentException> {
            System.setIn("no_number".byteInputStream())
            inputView.inputNumber()
        }
        assertEquals(assertThrows.message, ErrorMessage.INPUT_NUMBER_MESSAGE.message)
    }

    @ParameterizedTest
    @NullSource
    fun inputNullTest(setInput: String?) {
        val inputView = InputView()

        val assertThrows = assertThrows<IllegalArgumentException> {
            System.setIn(setInput?.byteInputStream())
            inputView.inputNumber()
        }
        assertEquals(assertThrows.message, ErrorMessage.NULL_MESSAGE.message)
    }
}
