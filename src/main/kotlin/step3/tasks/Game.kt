package step3.tasks

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import step3.model.Car
import step3.ui.getResult
import step3.viewmodel.GameViewModel

class Game {

    private val gameViewModel = GameViewModel()

    fun run(listOfCar: ArrayList<Car>) = runBlocking {
        gameViewModel.tryGo(listOfCar)
            .collect { getResult(it) }
    }

    fun setting(countOfCar: Int): ArrayList<Car> {
        val carFactory = CarFactory()
        val listOfCar = arrayListOf<Car>()
        repeat(countOfCar) {
            listOfCar.add(carFactory.createCar())
        }
        return listOfCar
    }
}
