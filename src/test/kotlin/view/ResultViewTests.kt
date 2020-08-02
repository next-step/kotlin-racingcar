package view

import manager.CarManager
import model.Car
import model.Dice
import model.DiceStatus
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResultViewTests {
    @Test
    fun `printCarStringHasANameAndStep`() {
        val dice = object : DiceStatus {
            override fun dice(): Int {
                return Dice.DICE_CHECK_SUCCESS_CONDITION + 1
            }

            override fun isSuccess(): Boolean {
                return true
            }
        }
        val car = Car("hello", 0, dice)
        val carManager = CarManager(Dice())
        car.move()
        val resultView = ResultView(carManager)
        assertThat(resultView.stepToString(car, 0)).isEqualTo("hello : -")
    }
}
