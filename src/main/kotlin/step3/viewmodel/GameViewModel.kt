package step3.viewmodel

import kotlinx.coroutines.flow.flow
import step3.model.Car
import step3.util.Message.Companion.MAX_CONDITION
import step3.util.Message.Companion.MIN_CONDITION_FOR_GOING
import java.util.Random

class GameViewModel {
    fun tryGo(listOfCar: ArrayList<Car>) = flow {
        listOfCar.map { car ->
            if (canGo()) car.go()
            emit(car)
        }
    }

    private fun canGo(): Boolean {
        val random = Random()
        return random.nextInt(MAX_CONDITION) > MIN_CONDITION_FOR_GOING
    }
}
