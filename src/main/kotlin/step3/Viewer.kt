package step3

class Viewer {

    private var cars: Int = 0
    private var round: Int = 0
    private var result = false

    fun getCars() = cars

    fun getRound() = round

    fun inputCars() {
        println("자동차 대수는 몇 대 인가요?")
        cars = readln().toInt()
    }

    fun inputRound() {
        println("시도할 회수는 몇 회 인가요?")
        round = readln().toInt()
    }

    fun showCarStatus(carStatus: List<Int>) {
        if (!result) {
            result = true
            println("\n실행 결과")
        }
        carStatus.forEach {
            println("-".repeat(it))
        }
        println()
    }
}
