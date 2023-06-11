package domain

class Race(
    private val carList: List<Car>
) {

    fun moveCar() {
        for (car in carList) {
            car.move()
        }
    }
}
