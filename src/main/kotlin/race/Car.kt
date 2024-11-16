package race

data class Car(val name: Name, var position: PositiveNumber) {
    val progress: Int
        get() = position.value
    val displayName: String
        get() = name.value

    constructor(a: String, position: Int) : this(Name(a), PositiveNumber(position))

    companion object {
        private const val MOVE_POSITION = 1
    }

    fun move() {
        this.position += PositiveNumber(MOVE_POSITION)
    }
}
