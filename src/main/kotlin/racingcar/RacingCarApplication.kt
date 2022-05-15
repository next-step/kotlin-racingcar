import racingcar.domain.Car
import racingcar.domain.CarRacing.getWinners
import racingcar.domain.CarRacing.initCars
import racingcar.domain.CarRacing.moveCars
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val carNamesStr = InputView.readCarNames()
    val trialCount = InputView.readNumOfTrials()
    raceStart(carNamesStr.split(","), trialCount)
}

fun raceStart(carNames: List<String>, trialCount: Int) {
    ResultView.showResultTitle()
    val listCar = race(carNames, trialCount)
    ResultView.showWinner(getWinners(listCar))
}

private fun race(carNames: List<String>, trialCount: Int): List<Car> {
    var listCar = initCars(carNames)
    (0 until trialCount).map {
        listCar = moveCars(listCar)
        ResultView.showPosition(listCar)
    }
    return listCar
}
