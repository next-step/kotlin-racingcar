package carracing

object ResultView {
    fun showStatus(cars: List<Car>) {
        cars.forEach {
            println("${it.name}: ${"-".repeat(it.position)}")
        }
    }
}
