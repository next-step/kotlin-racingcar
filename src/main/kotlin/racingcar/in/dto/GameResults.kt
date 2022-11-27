package racingcar.`in`.dto

import racingcar.vo.Position

class GameResults(positions: List<Position>) {

    val carPositions = positions.map { it.position }
}
