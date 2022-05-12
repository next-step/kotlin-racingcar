package racingcar.view

import racingcar.domain.Car

private const val POSITION_DISPLAY_SYMBOL = "-"

fun printPlayResult(result: List<List<Car>>) {
    println("실행 결과")
    result.forEach { cars -> printPosition(cars) }
}

private fun printPosition(cars: List<Car>) {
    val result = StringBuilder().apply {
        cars.forEach { append("${convertPositionTo(it)}\n") }
        append("\n")
    }.toString()
    println(result)
}

private fun convertPositionTo(car: Car): String {
    return POSITION_DISPLAY_SYMBOL.repeat(car.position)
}
