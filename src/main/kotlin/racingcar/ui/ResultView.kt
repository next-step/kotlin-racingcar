package racingcar.ui

import racingcar.domain.RacingCar

private const val PRINT_SYMBOL = "-"

fun printStart() {
    println("실행 결과")
}

fun printPosition(racingCars: List<RacingCar>) {
    for (it in racingCars) {
        print(it.name() + " : ")
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

fun printWinner(winners: String) {
    println(winners + "가 최종 우승했습니다.")
}
