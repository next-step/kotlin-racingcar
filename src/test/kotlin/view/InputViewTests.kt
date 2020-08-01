package view

import manager.CarManager
import model.Dice
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputViewTests {
    @Test
    fun `InputCarsWithNameAndReturnList`() {
        // given
        val inputView = InputView()

        // when
        val list = inputView.inputCarsWithName { "name" }

        // then
        assertThat(1).isEqualTo(list.size)
    }

    @Test
    fun `InputCarsWithNameSplitBySymbol`() {
        // given
        val inputView = InputView()

        // when
        val list = inputView.inputCarsWithName { "name, name2, name3" }

        // then
        assertThat(3).isEqualTo(list.size)
    }

    @Test
    fun `tryMovingIncrementTryMoveCount`() {
        // given
        val inputView = InputView()

        // when
        val result = inputView.inputTryMoveCount { "5" }

        // then
        assertThat(5).isEqualTo(result)
    }

    @Test
    fun `inputNotNumberThrowExceptionTryMoveCount`() {
        val carManager = CarManager(Dice())
        val inputView = InputView()
        // then
        assertThrows<IllegalArgumentException> {
            // when invalid character
            inputView.inputTryMoveCount {
                "abcd"
            }
        }
    }
}
