package racing

class Cars(private val carNumber: Int) {

    val carList: List<Car> = List(carNumber) { Car() }

    fun moveAll(){
        carList.forEach { car -> car.moveForward() }
    }

}
