package racingCar

import racingCar.model.Cars
import racingCar.view.EndView
import racingCar.view.InputView
import racingCar.view.ResultView
import racingCar.view.StartView

fun main() {
    Billboard(StartView(), InputView(), ResultView(), EndView()).proceed()
}

class Billboard(private val startView: StartView, inputView: InputView, private val resultView: ResultView, private val endView: EndView) {
    private var numberOfCars = 0
    private var numberOfTrial = 0

    init {
        val (numberOfCars, numberOfTrial) = inputView.inputData()
        this.numberOfCars = numberOfCars
        this.numberOfTrial = numberOfTrial
    }

    fun proceed() {
        startView.show()
        val cars = Cars(numberOfCars) { distanceOfDrive() }
        repeat(numberOfTrial) {
            cars.move()
            resultView.show(cars, numberOfTrial)
        }
        endView.show()
    }
}
