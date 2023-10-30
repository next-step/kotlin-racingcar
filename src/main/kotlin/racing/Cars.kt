package racing

class Cars {
    val carList: List<Car>
    constructor() {
        carList = listOf()
    }

    constructor(carNumber : Int) {
        carList = List(carNumber) { Car() }
    }

    fun moveAll(){
        carList.forEach { car -> car.moveForward() }
    }
}

