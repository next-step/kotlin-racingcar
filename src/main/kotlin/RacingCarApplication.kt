import racingcar.domain.CarRacing.initCars
import racingcar.domain.CarRacing.moveCars
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val carCount = InputView.readNumOfCars()
    val trialCount = InputView.readNumOfTrials()
    raceStart(carCount, trialCount)
}

fun raceStart(carCount: Int, trialCount: Int) {
    var listCar = initCars(carCount)
    ResultView.showResultTitle()
    (0 until trialCount).map {
        listCar = moveCars(listCar)
        ResultView.show(listCar)
    }
}
