package racingcar

fun racingStart(carCounts: Int, tryCounts: Int) {
    val cars = Cars.of(carCounts)
    repeat(tryCounts) {
        cars.move()
        println(cars.toMessages())
    }
}
