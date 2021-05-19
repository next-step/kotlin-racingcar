package view

import domain.Cars

class View {
    fun inputNumCar(): String? {
        println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).")
        return readLine()
    }

    fun inputNumMatch(): String? {
        val message = "시도할 횟수는 몇 회인가요?"
        println(message)
        return readLine()
    }

    fun printInvalidGameInfo() {
        println("잘못된 게임 정보입니다.")
    }

    fun printCarScore(cars: Cars, numMatch: Int) {
        for (car in cars.cars) {
            println(car.name + " : " + "-".repeat(car.distance))
        }
        println()
    }

    fun printWinner(winners: List<String>) {

        print(winners.joinToString(", ") + "가 최종 우승했습니다.")
    }
}
