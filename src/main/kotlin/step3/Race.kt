package step3

import java.util.Random

object Race {
    private const val MIN_VALUE_TO_MOVE = 4

    fun initiate(carNumber: Int): ArrayList<Car> {
        val carList = ArrayList<Car>()
        for (i in 1..carNumber) {
            carList.add(Car(0))
        }
        return carList
    }

    fun makeTurn(cars: ArrayList<Car>): ArrayList<Car> {
        for (car in cars) {
            car.distance = getDistanceForEachCar(car.distance)
        }
        return cars
    }

    fun getDistanceForEachCar(distance: Int): Int {
        return if (successToMove(getRandomNumber())) distance + 1 else distance
    }

    fun successToMove(random: Int): Boolean {
        return random >= MIN_VALUE_TO_MOVE
    }

    fun getRandomNumber(): Int {
        return Random().nextInt(10)
    }
}
