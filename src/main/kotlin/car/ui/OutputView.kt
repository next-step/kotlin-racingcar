package car.ui

import car.domain.Position

private const val CAR_RESULT_POSITION = "-"

object OutputView {

    fun result() {
        println("실행 결과")
    }

    fun output(positions: List<Position>) {
        positions.forEach { println(CAR_RESULT_POSITION.repeat(it.value)) }
        println()
    }
}
