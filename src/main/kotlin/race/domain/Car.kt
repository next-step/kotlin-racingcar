package race.domain

data class Car(
    val position: Int,
    val name: String,
) {
    fun goForward(): Car = copy(position = position + 1)

    fun isDraw(otherCar: Car): Boolean {
        return this.position == otherCar.position
    }

    companion object {
        fun getInitialCar(name: String): Car {
            return Car(position = 0, name = name)
        }

        fun winner(car1: Car, car2: Car): Car {
            return if (car1.position > car2.position) car1 else car2
        }
    }
}
