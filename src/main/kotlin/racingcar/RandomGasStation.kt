package racingcar

import kotlin.random.Random

object RandomGasStation {
    fun refuel() : Int {
        return Random.nextInt(10)
    }
}
