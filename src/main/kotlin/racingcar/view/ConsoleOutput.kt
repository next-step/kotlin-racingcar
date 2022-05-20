package racingcar.view

import racingcar.dto.CarSnapshot

class ConsoleOutput : OutputView {
    override fun printCarPositions(carSnapShots: List<CarSnapshot>) {
        carSnapShots.forEach { carSnapShot -> println(carSnapShot.position.toStringForPrint()) }
    }
}

private fun Int.toStringForPrint(): String {
    var result = ""
    for (i in 0 until this) {
        result = result.plus("-")
    }
    return result
}
