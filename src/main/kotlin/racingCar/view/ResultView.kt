package racingCar.view

import racingCar.domain.Car

private const val PRINT_SYMBOL = "-"
fun printStart() {
    println("실행 결과")
}

fun printResult(cars: List<Car>) {
    cars.forEach { car ->
        printPosition(car.position)
    }
    println()
}

fun printPosition(position: Int) {
    repeat((1..position).count()) {
        print(PRINT_SYMBOL)
    }
    println()
}
