package step4.racingcar.racingcar

fun main() {

    val racers = InputView.racers()
    val movementCount = InputView.movementCount()

    CarRacing.execute(racers, movementCount).also {
        ResultView.view(it, movementCount)
    }
}
