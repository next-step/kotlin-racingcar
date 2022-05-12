package study.step3

fun main() {
    println("자동차 대수는 몇 대인가요?")
    val numOfCar = readLine()!!.toInt()

    println("시도할 횟수는 몇 회인가요?")
    val numOfTry = readLine()!!.toInt()

    println("$numOfCar, $numOfTry")

    println("실행결과")
}