package study.step3.domain

class Race(private val carCount: Int, private val moveCount: Int) {
    private val cars = List(carCount) { Car() }

    fun run() {
        repeat(moveCount) {
            cars.forEach { car ->
                val shouldMove = (0..9).random() >= 4
                car.move(shouldMove)
            }
            ResultView.displayCars(cars)
        }
    }
}
