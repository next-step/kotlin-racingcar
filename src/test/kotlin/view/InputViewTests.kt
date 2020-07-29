package view

import manager.CarManager
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputViewTests {
    @Test
    fun `carsAddAndThenCreateCarListEqualsInputValue`() {
        // given
        val carManager = CarManager()
        val inputView = InputView(carManager)

        // when
        inputView.inputCarCount { "5" }

        // then
        assertThat(5).isEqualTo(carManager.getCarList().size)
    }

    @Test
    fun `tryMovingIncrementTryMoveCount`() {
        // given
        val carManager = CarManager()
        val inputView = InputView(carManager)

        // when
        inputView.inputTryMoveCount { "5" }

        // then
        assertThat(5).isEqualTo(carManager.getTryCount())
    }

    @Test
    fun `inputNotNumberThrowExceptionCarCount`() {
        // given
        val carManager = CarManager()
        val inputView = InputView(carManager)
        // then
        assertThrows<IllegalArgumentException> {
            // when invalid character
            inputView.inputCarCount { "abcd" }
        }
    }

    @Test
    fun `inputNotNumberThrowExceptionTryMoveCount`() {
        val carManager = CarManager()
        val inputView = InputView(carManager)
        // then
        assertThrows<IllegalArgumentException> {
            // when invalid character
            inputView.inputTryMoveCount {
                "abcd"
            }
        }
    }
}
