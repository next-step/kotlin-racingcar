package carRace

class CarList(val cars: MutableList<Car>) {
    fun driveCars() {
        cars.forEach {
            it.drive()
        }
    }
}
