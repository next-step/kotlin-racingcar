package view

import manager.CarManager
import model.Dice
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputViewTests {
    @Test
    fun `carsAddAndThenCreateCarListEqualsInputValue`() {
        // given
        val carManager = CarManager(Dice())
        val inputView = InputView(carManager)

        // when
        inputView.inputCarsWithName { "name" }

        // then
        assertThat(1).isEqualTo(carManager.getCarList().size)
    }

    @Test
    fun `tryMovingIncrementTryMoveCount`() {
        // given
        val carManager = CarManager(Dice())
        val inputView = InputView(carManager)

        // when
        inputView.inputTryMoveCount { "5" }

        // then
        assertThat(5).isEqualTo(carManager.tryCount)
    }

    @Test
    fun `inputNotNumberThrowExceptionTryMoveCount`() {
        val carManager = CarManager(Dice())
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
