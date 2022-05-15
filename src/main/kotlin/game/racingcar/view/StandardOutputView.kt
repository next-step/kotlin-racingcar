package game.racingcar.view

import game.racingcar.domain.Car

class StandardOutputView : OutputView {
    override fun getResult(cars: List<Car>): String {
        return cars.map { it.position }
            .joinToString("\n") { DISPLAY_CHARACTER.repeat(it) }
    }

    companion object {
        const val DISPLAY_CHARACTER = "-"
    }
}
