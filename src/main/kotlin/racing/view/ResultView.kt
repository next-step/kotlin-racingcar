package racing.view

import racing.domain.Car

object ResultView {
    private const val PROGRESS_STRING = "-"
    private const val SEPERATOR = ","

    fun showWinner(cars: List<Car>) {
        val firstGradePosition = cars.maxOf { it.position }
        val winners = cars.filter {
            it.position == firstGradePosition
        }.joinToString(SEPERATOR, transform = Car::name)
        print("${winners}가 최종 우승했습니다.")
    }

    fun showSkidMarks(cars: List<Car>) {
        cars.forEach { car ->
            println("${car.name} : ${PROGRESS_STRING.repeat(car.position)}")
        }
        println()
    }
}
