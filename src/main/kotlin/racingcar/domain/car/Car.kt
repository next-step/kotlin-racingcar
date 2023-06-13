package racingcar.domain.car

import racingcar.domain.record.CarRecord

class Car(
    val lineNumber: Int,
    private val carEngine: CarEngine = RandomCarEngine
) {
    var position: Int = START_POSITION
        private set

    fun move() {
        if (carEngine.canGo()) position++
    }

    fun race(tryCount: Int): CarRecord {
        val record = arrayListOf<Int>()
        repeat(tryCount) {
            move()
            record.add(this.position)
        }

        return CarRecord(this, record)
    }

    companion object {
        const val START_POSITION = 0
    }
}
