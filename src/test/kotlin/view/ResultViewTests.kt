package view

import manager.CarManager
import model.Car
import model.Dice
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResultViewTests {
    @Test
    fun `printCarStringHasANameAndStep`() {
        val car = Car("hello", 0)
        val carManager = CarManager(Dice())
        carManager.addCar(car)
        car.move(true)
        val resultView = ResultView(carManager)
        assertThat(resultView.stepToString(car, 0)).isEqualTo("hello : -")
    }
}
