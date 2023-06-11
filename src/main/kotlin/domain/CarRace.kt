package domain

import java.lang.Exception
import java.util.Random

class CarRace {

    private val carMovementCountList = arrayListOf<Car>()

    fun moveCar(carCount: Int): Int {
        if (carMovementCountList.size == 0 || carMovementCountList.size - 1 < carCount) throw IndexOutOfBoundsException(
            "The car does not exist."
        )
        return if (Random().nextInt(9) >= 4) {
            carMovementCountList[carCount].count = carMovementCountList[carCount].count + 1
            carMovementCountList[carCount].count
        } else {
            carMovementCountList[carCount].count
        }
    }

    fun initCarMovementCountList(carCount: Int) {
        try {
            repeat(carCount) {
                carMovementCountList.add(Car(it))
            }
        } catch (e: Exception) {
            println(e.message)
        }
    }

    fun getCarMovementCountList(carCount: Int): Car = carMovementCountList[carCount]
}
