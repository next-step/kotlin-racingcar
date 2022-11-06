package racingcar

class ResultView {
    fun printResult(carList: List<Car>, count: Int) {
        for (i in 1..count) {
            carList.forEach {
                it.move((0..9).random())
                it.printStatus()
            }
            println()
        }
    }
}
