package step3

import kotlin.random.Random

fun main() {
    println("자동차 대수는 몇 대인가요?")
    val carCount = readln().toInt()
    println("시도할 횟수는 몇 회인가요?")
    val tryCount = readln().toInt()
    println("실행 결과")
    val cars = List(carCount) { Car() }
    repeat(tryCount) { index ->
        println("try ${index + 1}")
        cars.forEach { car ->
            car.move()
            car.printPosition()
        }
    }
}

class Car(private var position: Int = 0) {
    fun move() {
        val random = Random.nextInt(1, 10)
        position += if (random >= 4) 1 else 0
    }

    fun printPosition() {
        println("-".repeat(position))
    }
}
