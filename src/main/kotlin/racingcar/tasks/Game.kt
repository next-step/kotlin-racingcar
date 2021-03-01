package racingcar.tasks

import kotlinx.coroutines.flow.collectIndexed
import kotlinx.coroutines.runBlocking
import racingcar.model.Car
import racingcar.ui.OutputView.getResult
import racingcar.viewmodel.GameViewModel

class Game {

    fun run(listOfCar: ArrayList<Car>) = runBlocking {
        GameViewModel.tryGo(listOfCar)
            .collectIndexed { index, value ->
                getResult(index == listOfCar.lastIndex, value)
            }
    }

    fun settingRacingCar(countOfCar: Int): ArrayList<Car> {
        val listOfCar = arrayListOf<Car>()
        repeat(countOfCar) {
            listOfCar.add(CarFactory.createCar())
        }
        return listOfCar
    }
}
