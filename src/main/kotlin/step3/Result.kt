package step3

class Result(cars: Cars) {
    val records = cars.cars.map { it.position }
}
