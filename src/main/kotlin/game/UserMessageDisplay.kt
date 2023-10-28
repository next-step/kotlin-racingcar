package game

object UserMessageDisplay {

    fun display(cars: List<Car>) {
        cars.forEach(::display)
        println()
    }

    private fun display(car: Car) = println(car.draw())
}
