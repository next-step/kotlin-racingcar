package racing.domain

data class Car(
    val name: Name,
    var position: Int = 0
) {
    companion object {
        fun from(name: String) = Car(Name(name))
        fun of(name: String, position: Int) = Car(Name(name), position)
    }

    fun move(movable: Boolean) {
        if (movable) {
            position++
        }
    }

    fun samePosition(position: Int): Boolean = this.position == position

    fun name() = name.value
}
