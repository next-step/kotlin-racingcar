package step3

data class Car(
    val distance: Int = Distance().calculate(),
    val forward: Int = DEFAULT_NUMBER_OF_COUNT
) {

    fun move(): Car {
        val currentForward = when {
            distance >= FORWARD_CONDITION -> this.forward + 1
            else -> forward
        }
        return Car(Distance().calculate(), currentForward)
    }
}

private const val FORWARD_CONDITION = 4
