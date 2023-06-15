package racingcar.domain.car

import racingcar.domain.car.carengine.CarEngine
import racingcar.domain.car.carengine.RandomCarEngine
import racingcar.domain.record.CarRecord

class Car(
    val name: String,
    private val carEngine: CarEngine = RandomCarEngine,
    position: Int = START_POSITION
) {
    var position: Int = position
        private set
    val carRecord = CarRecord(arrayListOf())

    init {
        require(name.length <= 5) { NAME_LIMIT_ERROR_MESSAGE }
    }

    fun move() {
        if (carEngine.canGo()) position++
        carRecord.record.add(position)
    }

    fun race(tryCount: Int) {
        repeat(tryCount) { move() }
    }

    companion object {
        const val START_POSITION = 0
        const val NAME_LENGTH_LIMIT = 5
        const val NAME_LIMIT_ERROR_MESSAGE = "자동차 이름은 ${NAME_LENGTH_LIMIT}을 넘을 수 없습니다."
    }
}
