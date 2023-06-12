package racingCar

import kotlin.random.Random

fun main() {
    println("자동차 대수는 몇 대인가요?")
    val numberOfCar = readLine()
    println("시도할 횟수는 몇 회인가요?")
    val count = readLine()

    print("$numberOfCar, $count")
}

fun generateRandomNum(gt: Int, lt: Int): Int {
    return Random.nextInt(gt, lt)
}

fun IsMovingForward(value: Int, ref: Int): Boolean {
    return value >= ref
}
