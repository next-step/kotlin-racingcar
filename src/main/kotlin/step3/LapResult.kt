package step3

class LapResult(cars: Cars) {
    val records = cars.cars.map { it.position }
}
