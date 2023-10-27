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
        return nextInt(from = FROM_ZERO, until = UNTIL_TEN) >= CAN_GO_NUMBER
    }

    companion object {
        private const val FROM_ZERO = 0
        private const val UNTIL_TEN = 10
        private const val CAN_GO_NUMBER = 4
    }
}
