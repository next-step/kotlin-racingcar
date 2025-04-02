package carracing


object CarGenerator {
     fun generateCars(numCars: Int) = List(numCars) { Car(name = "Car ${it + 1}") }
}