package game.racingcar.view

import game.racingcar.domain.Car

class StandardOutputView : OutputView {
    override fun getResult(cars: List<Car>, winners: List<Car>): String {
        val longestNameLength = cars.maxByOrNull { it.name.length }!!.name.length
        val result = arrayListOf<String>()
        for (lap in 0 until cars[0].blackBox.size) {
            result += cars.joinToString(CAR_DELIMITER) {
                "${it.name.padEnd(longestNameLength, ' ')} : ${DISPLAY_CHARACTER.repeat(it.history(lap))}"
            }
        }
        result += "${winners.joinToString(", ") { it.name }}가 최종 우승했습니다."

        return result.joinToString(LAP_DELIMITER)
    }

    companion object {
        const val DISPLAY_CHARACTER = "-"
        const val CAR_DELIMITER = "\n"
        const val LAP_DELIMITER = "\n\n"
    }
}
