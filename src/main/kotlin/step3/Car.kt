package step3

data class Car(val position: Int = 1) {
    fun move(): Car = Car(position + 1)
    override fun toString(): String = "-".repeat(position)
}