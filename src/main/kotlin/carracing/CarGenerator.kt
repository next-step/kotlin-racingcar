package carracing


object CarGenerator {
    fun generateCars(cars: List<String>) = cars.map { Car(name = it) }
}