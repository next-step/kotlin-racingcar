package racing.view

import racing.domain.CarModel
import racing.domain.RaceResult

interface RaceDisplayInterface {
    fun displayRacing(cars: List<CarModel>)

    fun displayWinners(winners: RaceResult)
}

class PrintRaceDisplay : RaceDisplayInterface {
    override fun displayRacing(cars: List<CarModel>) {
        for (car in cars) {
            printCar(car)
        }
        println()
    }

    override fun displayWinners(winners: RaceResult) {
        println("${winners.getCarNames()}가 최종 우승했습니다.")
    }

    private fun printCar(car: CarModel) {
        print("${car.name} : ")
        repeat(car.currentPosition) {
            print("-")
        }
        println()
    }
}
