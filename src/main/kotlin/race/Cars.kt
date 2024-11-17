package race

data class Cars(val values: List<Car>) : List<Car> by values {
    init {
        require(values.isNotEmpty()) { "최소 1대 이상 입력 해주세요." }
    }

    constructor(names: Names) : this(names.map { Car(it, PositiveNumber(1)) })

    fun moveAt(
        index: Int,
        condition: isMove,
    ) {
        move(values[index], condition)
    }

    private fun move(
        moveCar: Car,
        isMove: isMove,
    ) {
        if (isMove) {
            moveCar.move()
        }
    }
}
