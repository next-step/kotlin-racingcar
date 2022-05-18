package racingcar.domain

class Car private constructor(val name: String, position: Int = DEFAULT_POSITION){
    var position = position
        private set

    private val _positionList = ArrayList<Int>()
    val positionList
        get() = ArrayList(_positionList)

    fun move(movingStrategy: MovingStrategy) {
        if (movingStrategy.movable()) {
            position++
        }
        _positionList.add(position)
    }

    companion object {
        const val DEFAULT_POSITION: Int = 0
        const val CAR_NAME_NUMBER_FIVE_EXCEED = "자동차 이름은 1글자에서 5글자 사이입니다."
        private val NAME_LENGTH_RANGE: IntRange = 1..5
        fun makeCar(name: String): Car {
            require(name.trim().length in (NAME_LENGTH_RANGE)) { CAR_NAME_NUMBER_FIVE_EXCEED }
            return Car(name)
        }
    }
}
