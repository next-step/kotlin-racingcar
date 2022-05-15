package racingcar

import kotlin.random.Random

object RandomGasStation {
    private fun refuel() : Int {
        return Random.nextInt(10)
    }

    fun refuels(count: Int): List<Int> {
        val refuels : MutableList<Int> = mutableListOf()
        for (i in 1 .. count) refuels.add(refuel())
        return refuels.toList()
    }
}
