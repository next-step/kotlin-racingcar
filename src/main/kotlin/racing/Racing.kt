package racing
class Racing(numOfCar: Int, move: Int) {
    val carList = ArrayList<Car>()
    val move = move

    init {
        for (i in 0 until numOfCar) {
            carList.add(Car())
        }
    }

    fun goRacing() {
        for (i in 0 until move) {
            for (car in carList) {
                car.forward()
                println(car.getRoute())
            }
            println()
        }
    }
}