package racingcar.view

import racingcar.domain.CarRacingRoundResult

data class CarRacingRoundOutput(
    val carPositionsInOrder: List<Int>
) {
    fun draw(): String =
        carPositionsInOrder.joinToString("\n") { drawLine((it)) }

    private fun drawLine(size: Int) = "-".repeat(size)

    companion object {
        fun from(result: CarRacingRoundResult): CarRacingRoundOutput =
            CarRacingRoundOutput(
                carPositionsInOrder = result.getCarPositionsInorder(),
            )
    }
}
