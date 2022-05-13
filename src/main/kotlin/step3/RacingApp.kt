package step3

fun main() {
    println("자동차 대수는 몇 대인가요?")
    val numberOfCars = readLine()!!.toInt()
    println("시도할 횟수는 몇 회인가요?")
    val tries = readLine()!!.toInt()
    println()

    val racing = CarRacing(numberOfCars, tries)
    racing.start()
    val resultView = RacingResultView(tries, racing.eachRoundMap)
    println("실행 결과")
    resultView.display()
}
