package race

class Cars(private val cars: List<Car>) : List<Car> by cars {
    init {
        require(cars.isNotEmpty()) { "최소 1대 이상 입력 해주세요." }
    }

    constructor(names: Names) : this(names.map { Car(it, PositiveNumber(1)) })

    fun moveAt(
        indexedValue: Int,
        next: MoveCondition,
    ) {
        move(cars[indexedValue], next)
    }

    fun copy(): Cars {
        return Cars(cars.map { it.copy() })
    }

    private fun move(
        moveCar: Car,
        moveCondition: MoveCondition,
    ) {
        if (moveCondition.shouldMove()) {
            moveCar.move()
        }
    }
}
