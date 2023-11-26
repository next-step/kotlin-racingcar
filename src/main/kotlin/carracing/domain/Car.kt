package carracing.domain

data class Car(
    val name: String,
) {
    var position: Int = 0
        private set

    fun move() {
        position++
    }

    fun copy() = Car(name).apply {
        this.position = this@Car.position
    }
}