package racing.model

class Racing(carCount: Int) {
    var cars: List<Car> = List(carCount) { Car() }
}
