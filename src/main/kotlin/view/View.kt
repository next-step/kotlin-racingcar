package view

import domain.Car
import java.util.*

class View {
    fun inputNumCar(): String? {
        print("자동차 대수는 몇 대인가요?")
        return readLine()
    }

    fun inputNumMatch(): String? {
        print("시도할 횟수는 몇 회인가요?")
        return readLine()
    }

    fun printInvalidGameInfo() {
        print("잘못된 게임 정보입니다.")
    }

    fun printCarScore(cars: ArrayList<Car>) {
        for (car in cars) {
            println("-".repeat(car.distance))
        }

        println()
    }

}