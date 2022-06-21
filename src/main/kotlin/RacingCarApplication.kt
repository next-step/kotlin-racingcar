import racingcar.domain.CarCount
import racingcar.domain.CarRace
import racingcar.domain.TrialCount
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val carCount = CarCount(InputView.readNumOfCars())
    val trialCount = TrialCount(InputView.readNumOfTrials())
    ResultView.showResult(
        CarRace.start(carCount, trialCount)
    )
}
