package game.racingcar.view

import game.racingcar.domain.Car

class StandardOutputView : OutputView {
    override fun getResult(cars: List<Car>): String {

        val result = arrayListOf<String>()
        for (lap in 0 until cars[0].blackBox.size) {
            result += cars.map { it.history(lap) }
                .joinToString(CAR_DELIMITER) { DISPLAY_CHARACTER.repeat(it) }
        }
        return result.joinToString(LAP_DELIMITER)
    }

    companion object {
        const val DISPLAY_CHARACTER = "-"
        const val CAR_DELIMITER = "\n"
        const val LAP_DELIMITER = "\n\n"
    }
}
