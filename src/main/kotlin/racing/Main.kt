package racing

import racing.domain.CarRacing

fun main() {
    println("자동차 대수는 몇 대인가요?")
    val numOfCars = readLine()!!.toInt()
    println("시도할 횟수는 몇 회인가요?")
    val numOfMove = readLine()!!.toInt()

    val carRacing = CarRacing(numOfCars)

    println("실행 결과")
    for (i in 1..numOfMove) {
        carRacing.move()

        carRacing.positions.forEach { println("-".repeat(it)) }
        println()
    }
}
