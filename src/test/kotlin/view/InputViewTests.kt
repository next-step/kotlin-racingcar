package view

import manager.CarManager
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import view.InputView

class InputViewTests {
    @Test
    fun `carsAdd`() {
        val carManager = CarManager()
        val inputView = InputView(carManager)
        inputView.carsAdd(5)
        assertThat(5).isEqualTo(carManager.carList.size)
    }

    @Test
    fun `tryMoving`() {
        val carManager = CarManager()
        val inputView = InputView(carManager)
        inputView.tryMoving(5)
        assertThat(5).isEqualTo(carManager.tryCount)
    }

    @Test
    fun `inputNotNumberThrowExceptionCarCount`() {
        val carManager = CarManager()
        val inputView = InputView(carManager)
        assertThrows<IllegalArgumentException> { inputView.inputCarCount("abcd") }
    }

    @Test
    fun `inputNotNumberThrowExceptionTryMoveCount`() {
        val carManager = CarManager()
        val inputView = InputView(carManager)
        assertThrows<IllegalArgumentException> { inputView.inputTryMoveCount("abcd") }
    }
}
