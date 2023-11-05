package racing

object PrintResultExecutor {
    fun execute(cars: List<Car>) {
        for (car in cars) {
            print(car.position)
            println()
        }
    }
}
