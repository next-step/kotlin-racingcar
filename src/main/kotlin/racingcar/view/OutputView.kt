package racingcar.view

import racingcar.domain.Cars

fun printResult(cars: Cars, numberOfAttempts: Int) {
    println("실행 결과")

    repeat(numberOfAttempts) {
        cars.attempt()
        cars.scores.forEach { position ->
            println("-".repeat(position))
        }
        println()
    }
}
