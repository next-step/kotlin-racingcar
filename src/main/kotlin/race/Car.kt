package race

data class Car(
    val position: Int,
    val name: String,
) {
    fun goForward() = copy(position = position + 1)

    companion object {
        fun getInitialCar(name: String): Car {
            return Car(position = 0, name = name)
        }
    }
}
