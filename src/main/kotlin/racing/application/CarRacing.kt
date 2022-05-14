package racing.application

import racing.model.Car

class CarRacing(private val numberOfCars: Int, private val tries: Int) {

    companion object {
        const val RANDOM_VALUE_FROM = 0
        const val RANDOM_VALUE_UNTIL = 9
        const val GO_THRESHOLD_VALUE = 4

        fun willGo(): Boolean =
            GO_THRESHOLD_VALUE <= getRandom()

        fun getRandom(): Int =
            (RANDOM_VALUE_FROM..RANDOM_VALUE_UNTIL).random()
    }

    val eachRoundMap = mutableMapOf<Int, List<Car>>()

    fun start() {
        repeat(tries) { round(it) }
    }

    fun round(roundNo: Int) {
        if(eachRoundMap[roundNo - 1].isNullOrEmpty()) {
            eachRoundMap[roundNo] = List(numberOfCars) { Car() }
        } else {
            eachRoundMap.computeIfAbsent(roundNo) {
                eachRoundMap[roundNo - 1]!!.map {car ->
                    if(willGo()) car.go()
                    else car
                }
            }
        }
    }
}