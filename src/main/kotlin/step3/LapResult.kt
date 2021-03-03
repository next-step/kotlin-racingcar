package step3

class LapResult(cars: Cars) {
    val records = Records(cars.cars.map { Record(it) })
}
