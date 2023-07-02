package racing.model

class Racing(carCount: Int, val tryGameCount: Int) {
    var cars: List<Car> =
        List(carCount) { Car() }
    fun play() {
        repeat(tryGameCount) {
            cars.forEach { car ->
                val moving = car.run()
                println(car.CAR_SYMBOL.repeat(moving))
            }
            println()
        }
        println()
    }

}
