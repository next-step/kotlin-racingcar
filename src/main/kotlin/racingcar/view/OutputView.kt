package racingcar.view

import racingcar.dto.CarSnapshot

interface OutputView {
    fun printCarPositions(carSnapShots: List<CarSnapshot>)
}
