package racingcar.domain

class Car(carName: CarName, private val conditionGenerator: ConditionGenerator = RandomConditionGenerator()) {
    constructor(name: String) : this(CarName(name))
    constructor(name: String, conditionGenerator: ConditionGenerator) : this(CarName(name), conditionGenerator)

    var position: Int = DEFAULT_POSITION
        private set

    var carName: CarName = CarName(carName.name)
        private set

    private var isWinner: Boolean = false

    fun move() {
        val condition = conditionGenerator.generate()
        if (isWinner || condition >= MOVE_CONDITION) {
            position++
        }
    }

    companion object {
        private const val DEFAULT_POSITION: Int = 0
        private const val MOVE_CONDITION: Int = 4
    }
}
