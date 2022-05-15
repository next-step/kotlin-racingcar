package study.step3

fun main() {
    println("자동차 대수는 몇 대인가요?")
    val numOfCar = readLine()!!.toInt()

    println("시도할 횟수는 몇 회인가요?")
    val numOfTry = readLine()!!.toInt()

    val moving = Moving()
    val racingCars = (1..numOfCar).map { RacingCar(moving) }

    println("실행결과")
    repeat((1..numOfTry).count()) {
        println()
        racingCars.forEach {
            it.move()
            println(it.view.state)
        }
    }
}
