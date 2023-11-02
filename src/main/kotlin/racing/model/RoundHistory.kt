package racing.model

data class RoundHistory(
    val results: ArrayDeque<Car>
) {
    constructor(cars: List<Car>) : this(ArrayDeque(cars))

    init {
        requireDistinct()
    }

    private fun requireDistinct() {
        require(
            isExisited()
        ) { "자동차 name 은 중복이 허용되지 않습니다" }
    }

    private fun isExisited(): Boolean {
        return results
            .map { it.name }
            .distinct().size == results.size
    }
}
