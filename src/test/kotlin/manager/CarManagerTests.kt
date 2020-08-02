package manager

import model.Dice
import model.DiceStatus
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarManagerTests {
    @Test
    fun `tryMovingInlistElement`() {
        val dice = object : DiceStatus {
            override fun dice(): Int {
                return Dice.DICE_CHECK_SUCCESS_CONDITION + 1
            }

            override fun isSuccess(): Boolean {
                return true
            }
        }

        val carManager = CarManager(dice)
        carManager.addCarByDrivers(listOf("test"))
        val previousCarStep = carManager.carList[0].step
        carManager.tryCount = 1
        carManager.tryMoving()
        val afterCarStep = carManager.carList[0].step

        assertThat(previousCarStep).isNotEqualTo(afterCarStep)
    }

    @Test
    fun `addCarByDriversSizeIsEqualListSize`() {
        val list = listOf("test", "hello", "world")
        val carManager = CarManager(Dice())
        carManager.addCarByDrivers(list)
        assertThat(list.size).isEqualTo(carManager.carList.size)
    }
}
