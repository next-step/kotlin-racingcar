package racingcar.view

import racingcar.adapter.CarDto

class ResultViewImpl : ResultView {

    override fun printResultStart() {
        println("\n실행 결과")
    }

    override fun printResult(cars: List<CarDto>) {
        for (car in cars) {
            println(concatCarNameAndPosition(car.name, car.position))
        }
        println()
    }

    override fun printWinners(winners: List<String>) {
        println("${winners.joinToString()}가 최종 우승했습니다.")
    }

    private fun concatCarNameAndPosition(carName: String, position: Int): String {
        val msg = StringBuilder()
        msg.append(carName)
        msg.append(NAME_AND_POSITION_DELIMITER)
        msg.append(POSITION_SYMBOL.repeat(position))
        return msg.toString()
    }

    companion object {
        private const val POSITION_SYMBOL = "-"
        private const val NAME_AND_POSITION_DELIMITER = " : "
    }
}
