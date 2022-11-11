package step3

class Round(val id: Int) {

    fun start(cars: List<Car>) {
        cars.forEach { car ->
            val oil = OilStation.getOilRandomly()
            car.move(oil = oil)
        }
    }
}
