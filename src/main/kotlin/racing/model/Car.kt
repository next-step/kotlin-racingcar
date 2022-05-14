package racing.model

data class Car(
    val name: String,
    val position: String = CAR_PROGRESS_CHAR
) {

    companion object {
        private const val CAR_PROGRESS_CHAR = "-"
    }

    fun go() : Car {
        return Car(name, position + CAR_PROGRESS_CHAR)
    }

    override fun toString(): String {
        return "$name : $position"
    }
}
