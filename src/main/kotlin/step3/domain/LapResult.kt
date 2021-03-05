package step3.domain

class LapResult(cars: Cars) {
    val records = Records(cars.cars.map { Record(it) })
}
