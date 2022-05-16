package racing

data class Car(
    val name: Int,
    val prevDistance: Int,
    val newDistance: Int,
) {
    val distance = prevDistance + newDistance
}

