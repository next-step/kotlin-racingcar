package racingcar.ui

import racingcar.domain.RacingCar

private const val PRINT_SYMBOL = "-"

fun printStart() {
    println("실행 결과")
}

fun printPosition(racingCars: List<RacingCar>) {
    for (it in racingCars) {
        printPosition(it.position())
    }

    println()
}

fun printPosition(position: Int) {
    repeat((1..position).count()) {
        print(PRINT_SYMBOL)
    }
    println()
}
