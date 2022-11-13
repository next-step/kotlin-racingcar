package racingcar

import racingcar.io.InputView
import racingcar.io.ResultView

fun main() {
    val delimiters = ","

    ResultView.printMessage(ResultView.Message.CAR_NAMES_WITH_COMMA)
    val names: List<String> = InputView.requestString(delimiters)
    val cars: List<Car> = names.map { Car(name = it) }

    ResultView.printMessage(ResultView.Message.PLAY_COUNT)
    val playCount: Int = InputView.requestPositiveNumber()

    ResultView.printMessage(ResultView.Message.RESULT)
    val track = Track { (0..9).random() }
    val finishedRacingCars: List<Car> = track.play(playCount, cars)

    val winners: String = Rank.getWinnerNames(finishedRacingCars)
    ResultView.printMessage(winners, ResultView.Message.WINNER)
}
