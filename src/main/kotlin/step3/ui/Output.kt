package step3.ui

import step3.Car
import step3.Cars
import step3.Round

object Output {
    fun printResult(cars: Cars, round: Round) {
        println(RESULT_OF_EXECUTE)
        printCars(cars, round)
    }

    private fun printCars(cars: Cars, round: Round) {
        repeat(round.number) {
            val carList = cars.makeCar()
            carList.forEach {
                printCar(it)
            }
            cars.moveCars(carList)
            println(END_OF_LINE)
        }
    }

    fun printCar(car: Car) {
        println(printForward(car))
    }

    fun printForward(car: Car): String {
        val stringBuilder = StringBuilder()
        (0 until car.forward).map {
            stringBuilder.append(FORWARD_MARK)
        }
        return stringBuilder.toString()
    }
}

const val FORWARD_MARK = "-"
const val END_OF_LINE = "!-- End of line --!"
const val RESULT_OF_EXECUTE = "실행 결과"
