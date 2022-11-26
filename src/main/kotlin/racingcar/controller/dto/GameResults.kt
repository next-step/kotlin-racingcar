package racingcar.controller.dto

import racingcar.domain.Position

class GameResults(positions: List<Position>) {

    val carPositions = positions.map { it.position }
}
