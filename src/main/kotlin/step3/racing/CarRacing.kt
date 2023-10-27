package step3.racing

import step3.view.ResultView
import kotlin.random.Random.Default.nextInt

class CarRacing(
    private val resultView: ResultView,
) {

    fun doRacing(repeat: Int, carList: List<Car>) {
        repeat(repeat) {
            carList.forEach { car -> if (canGo()) car.moveForward() }
            resultView.showResult(carList)
        }
    }

    private fun canGo(): Boolean {
        return nextInt(0, 10) >= 4
    }
}
