package racingCar

object OutputView {
    fun showResultMessage() {
        println("실행 결과")
    }

    fun showResult(cars: Cars) {
        cars.cars.forEach {
            printCarDistance(it.distance, it.getName())
            println()
        }
        println()
    }

    fun showWinners(cars: List<Car>) {
        val sb = StringBuilder()

        cars.forEach {
            sb.append(it.getName())
            sb.append(",")
        }

        print("$sb 가 최종 우승했습니다.")
    }

    private fun printCarDistance(distance: Int, name: String) {
        print("$name : ")
        repeat(distance) {
            print("-")
        }
    }
}
