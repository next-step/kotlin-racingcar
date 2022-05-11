import step3.racingcar.car.RacingGame
import step3.racingcar.view.InputView

fun main() {
    val numberOfCar = InputView.showNumberOfCarInitView()
    val trialCount = InputView.showTrialCountInitView()

    val racingGame = RacingGame.init(numberOfCar, trialCount)
    racingGame.play()
}
