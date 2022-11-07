package racingCar.view

import racingCar.domain.Position
import racingCar.dto.ResultDto
import java.util.stream.Collectors
import java.util.stream.IntStream

object OutputView {

    private const val CAR_NUM_ASK_QST = "자동차 대수는 몇 대인가요?"
    private const val TRY_NUM_ASK_QST = "시도할 횟수는 몇 회인가요?"
    private const val POSITION_UNIT = "-"

    fun askCarNumber() = println(CAR_NUM_ASK_QST)
    fun askTryNumber() = println(TRY_NUM_ASK_QST)

    fun printResult(result: ResultDto) {
        println()
        result.positions.forEach {
            println(toPositionUnits(it))
        }
    }

    private fun toPositionUnits(position: Position): String {
        return IntStream.range(0, position.position)
            .mapToObj { POSITION_UNIT }
            .collect(Collectors.joining())
    }
}
