package racingcar

import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    println("자동차 대수는 몇 대인가요?")
    val carNumber = sc.nextInt()
    println("시도할 횟수는 몇 회인가요?")
    val count = sc.nextInt()
    println("실행 결과")
    println("$carNumber, $count")
}
