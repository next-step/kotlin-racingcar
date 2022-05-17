package racingcar.view

import racingcar.domain.Car
import racingcar.domain.Name
import racingcar.domain.RacingResult

private const val POSITION_DISPLAY_SYMBOL = "-"

fun printPlayResult(result: RacingResult) {
    println("실행 결과")
    result.value
        .forEach { cars -> printPosition(cars.cars) }
}

private fun printPosition(cars: List<Car>) {
    val result = StringBuilder().apply {
        cars.forEach { append("${it.name.value} : ${convertToPositionSymbol(it)}\n") }
    }.toString()
    println(result)
}

private fun convertToPositionSymbol(car: Car): String {
    return POSITION_DISPLAY_SYMBOL.repeat(car.position)
}

fun printWinners(names: List<Name>) {
    names.joinToString(",") { it.value }
        .also { println("${it}가 최종 우승했습니다.") }
}
