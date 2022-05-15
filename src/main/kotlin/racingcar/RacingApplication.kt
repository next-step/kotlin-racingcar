package racingcar

fun main() {

    RacingView.InputView.displayCarNames()
    val carNames: String = readln()
    require(carNames.isNotBlank()) { "잘못된 요청 입니다." }

    RacingView.InputView.displayRoundCount()
    val roundCount: String = readln()
    require(roundCount.isNotBlank()) { "잘못된 요청 입니다." }

    val readyCars = ready(CarSelector(carNames).names)

    val racing = Racing(Cars(readyCars))
    racing.start(roundCount.toInt(), DefaultMoveStrategy())

    RacingView.OutputView.display(racing.result)
}

fun ready(names: List<String>): List<Car> {
    return names.map { Car(it) }
}
