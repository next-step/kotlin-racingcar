package racingcar.domain

class RacingGame(carCnt: Int, val tryCnt: Int) {
    var cars = mutableListOf<Car>()

    init {
        repeat(carCnt) { cars.add(Car()) }
    }

    fun execute(method: () -> Int): List<CarHistory> {
        val histories: MutableList<CarHistory> = mutableListOf()
        cars.forEach {
            val carHistory = it.move(method())
            histories.add(carHistory)
        }
        return histories.toList()
    }

    fun play(method: () -> Int): List<List<CarHistory>> {
        val recordList: MutableList<List<CarHistory>> = mutableListOf()
        repeat(tryCnt) {
            recordList.add(execute(method))
        }
        return recordList.toList()
    }
}
