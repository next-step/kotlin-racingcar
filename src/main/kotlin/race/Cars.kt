package race

class Cars(private val cars: List<Car>) : List<Car> by cars {
    constructor(names: Names) : this(names.map { Car(it, PositiveNumber(1)) })

    init {
        require(cars.isNotEmpty()) { "최소 1대 이상 입력 해주세요." }
    }

    fun moveAll(moveConditions: MoveConditions) {
        validMoveCondition(moveConditions)

        cars.zip(moveConditions.values)
            .forEach { (moveCar, moveCondition) ->
                move(moveCar, moveCondition)
            }
    }

    private fun move(
        moveCar: Car,
        moveCondition: MoveCondition,
    ) {
        if (moveCondition.shouldMove()) {
            moveCar.move()
        }
    }

    private fun validMoveCondition(moveConditions: MoveConditions) {
        require(moveConditions.size == size) { "Car의 갯수와 moveCondition의 갯수가 다릅니다." }
    }
}
