import step3.racingcar.car.RacingGame
import step3.racingcar.car.strategy.RandomNumberStrategy
import step3.racingcar.view.InputView
import step3.racingcar.view.ResultView

fun main() {
    val numberOfCar = InputView.showNumberOfCarInitView()
    val trialCount = InputView.showTrialCountInitView()
    val strategy = RandomNumberStrategy()

    val racingGame = RacingGame.init(numberOfCar, trialCount, strategy)

    repeat(racingGame.trialCount) {
        racingGame.play()
        ResultView.showRecordsAsDash(racingGame.getPlayResults())
    }
}
