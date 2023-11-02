package carRace

class CarList(val cars: List<Car>) {
    fun driveCars() {
        cars.forEach {
            it.drive()
        }
    }
}
