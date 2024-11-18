package race

data class Cars(val values: List<Car>) : List<Car> by values {
    init {
        require(values.isNotEmpty()) { "최소 1대 이상 입력 해주세요. 입력 값: $values" }
    }

    constructor(names: Names) : this(names.map { Car(it, PositiveNumber.ONE) })

    fun moveAt(
        index: Int,
        condition: isMove,
    ) {
        if (condition) {
            values[index].move()
        }
    }
}
