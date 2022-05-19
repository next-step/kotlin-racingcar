package racingcar

import racingcar.application.RacingService
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

    val racing = RacingService(DefaultMoveStrategy())
    val racingResponse = racing.start(roundCount.toInt(), Cars(readyCars))

    OutputView.display(racingResponse.allResult)

    val winners = Winner(racingResponse.finalResult).winners
    OutputView.winner(winners)
}

fun ready(names: List<String>): List<Car> {
    return names.map { Car(it) }
}
