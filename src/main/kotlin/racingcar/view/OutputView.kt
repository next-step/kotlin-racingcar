package racingcar.view

import racingcar.domain.result.CarRaceResult

interface OutputView {
    fun printCarRace(carRaceResult: CarRaceResult)
}
