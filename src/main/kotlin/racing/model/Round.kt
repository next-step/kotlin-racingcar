package racing.model

import racing.application.CarRacing
import racing.util.RandomGenerator

data class Round(val cars: List<Car>) {

    fun next(): Round {
        return Round(
            cars.map { car ->
                if(willCarGo()) car.go()
                else car
            }
        )
    }

    private fun willCarGo(): Boolean =
        CarRacing.GO_THRESHOLD_VALUE <= RandomGenerator.getIntRangeRandom()
}