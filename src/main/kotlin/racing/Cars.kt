package racing

class Cars(private val carNumber: Int) {

    val carList: List<Car> = List(carNumber) { Car() }

    fun moveAll(){
        for (car in carList) {
            car.moveForward()
        }
    }

}
