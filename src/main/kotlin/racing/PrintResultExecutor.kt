package racing

object PrintResultExecutor {
    fun execute(carList: List<Car>) {
        for (car in carList) {
            print(car.position)
            println()
        }
    }
}
