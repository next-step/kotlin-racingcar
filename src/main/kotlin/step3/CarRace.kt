package step3

import step3.view.DisplayView
import step3.view.InputView
import kotlin.random.Random

class CarRace {

    private var numOfCar: Int = 0
    private var numOfMove: Int = 0
    private lateinit var carList: MutableList<MutableList<String>>

    fun race() {
        setUp()
        start()
    }

    private fun setUp() {
        getInput()
        createCarList()
    }

    private fun start() {
        DisplayView.displayHeader()
        repeat(numOfMove) {
            CarMover.move(carList)
            DisplayView.displayCarPosition(carList)
        }
    }

    private fun getInput() {
        this.numOfCar = InputView.inputNumOfCar()
        this.numOfMove = InputView.inputNumOfGame()
    }

    private fun createCarList() {
        repeat(this.numOfCar) {
            carList += mutableListOf<String>()
        }
    }
}