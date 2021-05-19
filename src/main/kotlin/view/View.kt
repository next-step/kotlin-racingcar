package view

import domain.Car
import java.util.*

class View {
    fun inputNumCar(): String? {
        println("자동차 대수는 몇 대인가요?")
        return readLine()
    }

    fun inputNumMatch(): String? {
        println("시도할 횟수는 몇 회인가요?")
        return readLine()
    }

    fun printInvalidGameInfo() {
        println("잘못된 게임 정보입니다.")
    }

    fun printCarScore(cars: ArrayList<Car>, numMatch: Int) {
        println("실행 결과")
        val random = Random();
        for (i in 0 until numMatch) {
            for (car in cars) {
                val randomNumber = random.nextInt(10)
                if (randomNumber > 4) {
                    car.move();
                }
                println(car.name + " : " + " - ".repeat(car.distance))
            }
            println()
        }
    }

}