package step3

class Result(cars: List<Car>) {
    val records = cars.map { it.position }
}
