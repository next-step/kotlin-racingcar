package step3

class Car(
    private val engine: ConditionalOperatingCarEngine,
    val name: String,
) {
    init {
        require(name.isNotBlank() && name.length <= MAXIMUM_NAME_LENGTH) { "이름은 5자 이하여야 합니다" }
    }

    var movedDistance: Distance = Distance(0)
        private set

    fun move() {
        movedDistance += engine.move()
    }

    companion object {
        private const val MAXIMUM_NAME_LENGTH = 5
    }
}
