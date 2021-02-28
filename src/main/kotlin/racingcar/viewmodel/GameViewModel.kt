package racingcar.viewmodel

import kotlinx.coroutines.flow.flow
import racingcar.model.Car
import racingcar.util.Message.Companion.MAX_CONDITION
import racingcar.util.Message.Companion.MIN_CONDITION_FOR_GOING
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
