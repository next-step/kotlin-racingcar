package racingcar

class Driver(val name: String, private val car: Car) {

    val driveRecord = mutableListOf<Int>()

    init {
        require(name.trim().length in (1..5)) {
            throw RuntimeException(NAME_CONVENTION)
        }
    }

    fun drive(isMovable: Boolean) {
        if (isMovable) {
            car.move()
        }
        driveRecord.add(car.movement)
    }

    companion object {
        private const val NAME_CONVENTION = "자동차의 이름은 1글자에서 5글자 사이입니다."
    }
}
