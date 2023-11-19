import racing.Car
import racing.Cars
import racing.RacingMovingRule
import racing.ui.ResultView

data class RacingGame(private val carList: List<Car>, private val movingRule: RacingMovingRule) {
    fun goRacing() {
        repeat(movingRule.movingCount) {
            for (car in carList) {
                if (movingRule.isMove()) {
                    car.forward(movingRule)
                }
            }
            ResultView.showCarRoute(Cars(carList))
        }
        ResultView.printFinalResult(Cars(carList).winner)
    }
}
