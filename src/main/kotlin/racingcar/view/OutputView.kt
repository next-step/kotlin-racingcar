package racingcar.view

import racingcar.domain.RacingResult
import racingcar.domain.car.Name
import racingcar.domain.car.Position

private const val POSITION_DISPLAY_SYMBOL = "-"

fun printPlayResult(result: RacingResult) {
    println("실행 결과")
    result.value
        .forEach { racingRecord -> printPosition(racingRecord.value) }
}

private fun printPosition(racingRecord: List<Pair<Name, Position>>) = with(StringBuilder()) {
    racingRecord.forEach { append("${it.first.value} : ${convertToPositionSymbol(it.second)}\n") }
    println(this.toString())
}

private fun convertToPositionSymbol(position: Position): String {
    return POSITION_DISPLAY_SYMBOL.repeat(position.value)
}

fun printWinners(names: List<Name>) {
    names.joinToString(",") { it.value }
        .also { println("${it}가 최종 우승했습니다.") }
}
