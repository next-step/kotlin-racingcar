package racing_car

fun main() {

    // 자동차 대수는 몇 대인가요??
    println("자동차 대수는 몇 대인가요??")
    val numberOfCar = readln().toInt()
    val cars = List(numberOfCar) { Car() }

    // 시도할 횟수는 몇 회인가요???
    println("시도할 횟수는 몇 회인가요???")
    val numberOfMove = readln().toInt()

    // 실행 결과
    println("\n실행 결과")
    for (i in 1..numberOfMove) {
        cars.forEach { it ->
            it.move()
            val position = it.position
            println("-".repeat(position))
        }
        println()
    }
}
