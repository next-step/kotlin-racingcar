package racingcar

fun racing(carName: String, tryCounts: Int) {
    val names = carName.split(",")
    val cars = Cars.of(names)
    repeat(tryCounts) {
        cars.move()
        println(cars.toMessages())
    }
    println(cars.winner())
}

fun Cars.toMessages(): String = buildString {
    cars.forEach { car ->
        appendLine(car.toMessage())
    }
}

fun Car.toMessage(): String = buildString {
    append("$name : ")
    append("-".repeat(maxOf(0, position)))
}

fun Cars.winner(): String = buildString {
    val winnersCarNames = cars
        .filter { it.position == cars.maxOf { car -> car.position } }
        .joinToString(",") { it.name }

    appendLine("${winnersCarNames}가 최종 우승했습니다.")
}
