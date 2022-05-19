package racingcar

import racingcar.domain.Car
import racingcar.domain.CarSelector
import racingcar.domain.Cars
import racingcar.domain.Winner
import racingcar.infra.DefaultMoveStrategy

fun main() {

    InputView.displayCarNames()
    val carNames: String = readln()
    require(carNames.isNotBlank()) { "잘못된 요청 입니다." }

    InputView.displayRoundCount()
    val roundCount: String = readln()
    require(roundCount.isNotBlank()) { "잘못된 요청 입니다." }

    val readyCars = ready(CarSelector(carNames).names)

    val racing = Racing(Cars(readyCars))
    racing.start(roundCount.toInt(), DefaultMoveStrategy())

    OutputView.display(racing.history)

    val winners = Winner(racing.result).winners
    OutputView.winner(winners)
}

fun ready(names: List<String>): List<Car> {
    return names.map { Car(it) }
}
