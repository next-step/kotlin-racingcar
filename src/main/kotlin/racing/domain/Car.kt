package racing.domain

class Car(
    val name: String,
    private val moveStrategy: MoveStrategy,
) {
    var position = 0
        private set

    init {
        require(name.isNotBlank() && name.length <= 5) { "자동차의 이름은 1~5글자여야 합니다." }
    }

    fun move() {
        position += moveStrategy.getMoveDistance()
    }
}
