package racing.model

class Racing(carNames: List<String>, val tryGameCount: Int) {
    var cars: MutableList<Car> = mutableListOf()

    init {
        for (carName in carNames) {
            cars.add(Car(carName))
        }
    }

    fun play() {
        repeat(tryGameCount) {
            cars.forEach { car ->
                val moving = car.run()
                print("${car.name} : ")
                println(Car.CAR_SYMBOL.repeat(moving))
            }
            println()
        }
        println()
    }
}
