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

    carList.forEach {
        for (i in 1..count) {
            it.move()
        }
    }

    println("실행 결과")
    println("$carNumber, $count")
}
