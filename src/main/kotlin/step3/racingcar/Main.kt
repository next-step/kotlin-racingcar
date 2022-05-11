import step3.racingcar.car.RacingGame
import step3.racingcar.view.InputView
import step3.racingcar.view.ResultView

fun main() {
    val numberOfCar = InputView.showNumberOfCarInitView()
    val trialCount = InputView.showTrialCountInitView()

    val racingGame = RacingGame.init(numberOfCar, trialCount)

    repeat(racingGame.trialCount) {
        racingGame.play()
        ResultView.showRecordsAsDash(racingGame.getPlayResults())
    }
}
