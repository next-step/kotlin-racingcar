package racingcar.domain.car

import racingcar.domain.record.CarRecord

class Car(
    val lineNumber: Int
) {
    var position: Int = 0
        private set

    fun move() {
        if (CarRandomGenerator.canGo()) position++
    }

    fun race(tryCount: Int): CarRecord {
        val record = arrayListOf<Int>()
        repeat(tryCount) {
            move()
            record.add(this.position)
        }

        return CarRecord(this, record)
    }
}
