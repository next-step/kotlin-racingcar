package racing.domain

data class Car(
    val position: Int
) {
    fun movePosition(): Car {
        return Car(position + 1)
    }
}
