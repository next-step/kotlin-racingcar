package racing.view

import racing.domain.Car

object ResultView {
    private const val NEXT_LINE = "\n"
    private const val PROGRESS_STRING = "-"
    private const val SEPERATOR = ", "
    private const val MAX_RANGE = 10

    fun showWinner(cars: List<Car>): String {
        val firstGradePosition = cars.maxOf(Car::position)
        return cars.filter {
            it.position == firstGradePosition
        }.joinToString(SEPERATOR, transform = Car::name)
    }

    fun showSkidMarks(cars: List<Car>) {
        cars.forEach { car ->
            val progressString = StringBuffer()
            repeat(car.position) {
                progressString.append(PROGRESS_STRING)
            }
            println("${car.name} : $progressString")
        }
    }
}
