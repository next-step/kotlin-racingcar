package racing.application

import racing.model.Car

class CarRacing(private val carNames: List<String>, private val tries: Int) {

    companion object {
        const val RANDOM_VALUE_FROM = 0
        const val RANDOM_VALUE_UNTIL = 9
        const val GO_THRESHOLD_VALUE = 4


    }

    val eachRoundMap = mutableMapOf<Int, List<Car>>()

    fun start() {
        repeat(tries) { round(it) }
    }

    fun round(roundNo: Int) {
        if (isFirstRound(roundNo)) {
            eachRoundMap[roundNo] = initFirstRound(carNames)
        } else {
            setRound(roundNo)
        }
    }

    private fun isFirstRound(roundNo: Int): Boolean =
        eachRoundMap[roundNo - 1].isNullOrEmpty()

    private fun initFirstRound(names: List<String>): List<Car> =
        names.map { Car(name = it) }

    private fun setRound(roundNo: Int) {
        eachRoundMap.computeIfAbsent(roundNo) {
            eachRoundMap[roundNo - 1]!!.map {car ->
                if(willGo()) car.go()
                else car
            }
        }
    }

    private fun willGo(): Boolean =
        GO_THRESHOLD_VALUE <= getRandom()

    private fun getRandom(): Int =
        (RANDOM_VALUE_FROM..RANDOM_VALUE_UNTIL).random()

}