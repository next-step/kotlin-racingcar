package racingcar

import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    println("자동차 대수는 몇 대인가요?")
    val carNumber = sc.nextInt()

    val carList = mutableListOf<Car>()
    for (i in 1..carNumber) {
        carList.add(Car())
    }

    println("시도할 횟수는 몇 회인가요?")
    val count = sc.nextInt()

    for (i in 1..count) {
        carList.forEach {
            it.move((0..9).random())
            it.printStatus()
        }
        println()
    }
}
