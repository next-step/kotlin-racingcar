package racing.model

data class RoundHistory(
    val results: ArrayDeque<Car>
) {
    init {
        requireDistinct()
    }

    private fun requireDistinct() {
        require(
            results
                .map { it.name }
                .distinct().size == results.size
        ) { "자동차의 name 은 중복이 허용되지 않습니다" }
    }
}
