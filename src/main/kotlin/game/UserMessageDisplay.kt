package game

object UserMessageDisplay {

    private const val POSITION_MARKER = "-"

    fun display(cars: List<Car>) {
        cars.forEach(::display)
        println()
    }

    private fun display(car: Car) = println(draw(car))

    private fun draw(car: Car) = POSITION_MARKER.repeat(car.position)
}
