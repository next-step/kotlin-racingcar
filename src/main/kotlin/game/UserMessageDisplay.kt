package game

object UserMessageDisplay {
    fun display(cars: List<Car>) {
        cars.forEach { car -> println(car.drawPosition()) }
        println()
    }
}
