package step3_4.racing

class CarRacing {

    fun doRacing(repeat: Int, carList: List<Car>, showResult: (List<Car>) -> Unit) {
        repeat(repeat) {
            carList.forEach { car -> car.moveForward() }
            showResult(carList)
        }
    }
}
