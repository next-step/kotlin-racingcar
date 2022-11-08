package racingcar

class ResultView {
    fun printResult(carList: List<Car>, count: Int) {
        for (i in 1..count) {
            carList.forEach {
                it.move((0..9).random())
                printStatus(it.status)
            }
            println()
        }
    }

    private fun printStatus(number: Int) {
        for (i in 0..number) {
            print("-")
        }
        println()
    }
}
