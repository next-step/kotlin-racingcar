package racing

import kotlin.random.Random

class Cars {
    val carList: List<Car>
    constructor(carList: List<Car>) {
        this.carList = carList
    }

    constructor(carNumber : Int) {
        carList = List(carNumber) { Car() }
    }

    fun moveAll(){
        val randomMove = Random.nextInt(10)
        carList.forEach { car -> car.moveForward(randomMove) }
    }
}

