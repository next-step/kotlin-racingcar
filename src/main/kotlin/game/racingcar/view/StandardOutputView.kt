package game.racingcar.view

import game.racingcar.domain.Car

class StandardOutputView : OutputView {
    override fun getResult(cars: List<Car>): String {

        var result = ""

        for (lap in 0 until cars[0].blackBox.size) {
            result += cars.map { it.history(lap) }
                .joinToString("\n") { DISPLAY_CHARACTER.repeat(it) }
            result += "\n\n"
        }
        return result
    }

    companion object {
        const val DISPLAY_CHARACTER = "-"
    }
}
