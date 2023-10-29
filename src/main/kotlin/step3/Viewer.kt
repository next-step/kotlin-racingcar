package step3

class Viewer {

    private var carsCount: Int = 0
    private var round: Int = 0

    fun getCarsCount() = carsCount

    fun getRound() = round

    fun inputCars() {
        println("자동차 대수는 몇 대 인가요?")
        carsCount = readln().toInt()
    }

    fun inputRound() {
        println("시도할 회수는 몇 회 인가요?")
        round = readln().toInt()
    }

    fun showCarStatus(carStatus: List<Int>) {
        carStatus.forEach {
            println("-".repeat(it))
        }
        println()
    }

    fun showResultWords() {
        println("\n실행 결과")
    }
}
