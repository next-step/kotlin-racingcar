package first_week_carrace

class Viewer {

    private lateinit var carsName: List<String>
    private var round: Int = 0

    fun getRound() = round

    fun getCarsName() = carsName.toList()

    fun inputCars() {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,) 기준으로 구분).")
        carsName = readln().split(",").map { it.trim() }
    }

    fun inputRound() {
        println("시도할 회수는 몇 회 인가요?")
        round = readln().toInt()
    }

    fun showCarsPosition(carStatus: List<Pair<String, Int>>) {
        carStatus.forEach {
            println("""%-5s : ${"-".repeat(it.second)}""".format(it.first))
        }
        println()
    }

    fun showResultWords() {
        println("\n실행 결과")
    }

    fun showWinners(winners: List<String>) {
        println("${winners.joinToString(", ")}(이|가) 최종 우승했습니다.")
    }
}
