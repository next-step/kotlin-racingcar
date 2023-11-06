package racingcar

fun main() {
    println("자동차 대수는 몇 대 인가요?")
    val carCounts = readln().toInt()
    println("시도할 횟수는 몇 회인가요?")
    val tryCounts = readln().toInt()

    val cars = Cars.of(carCounts)
    repeat(tryCounts) {
        cars.move()
        println(cars.toMessages())
    }
}
