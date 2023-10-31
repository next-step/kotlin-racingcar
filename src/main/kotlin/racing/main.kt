package racing

fun main() {
    println("자동차 대수는 몇 대인가요?")
    val numOfCar = readln().toInt()

    println("시도할 횟수는 몇 회인가요?")
    val move = readln().toInt()

    println("실행결과")

    var racing = Racing(numOfCar, move)
    racing.goRacing()
}