package racingcar.domain.car

import racingcar.domain.record.CarRecord

class Car(
    private val carEngine: CarEngine = RandomCarEngine,
    position: Int = START_POSITION
) {
    var position: Int = position
        private set
    val carRecord = CarRecord(arrayListOf())

    fun move() {
        if (carEngine.canGo()) position++
        carRecord.record.add(position)
    }

    fun race(tryCount: Int) {
        repeat(tryCount) { move() }
    }

    companion object {
        const val START_POSITION = 0
    }
}
