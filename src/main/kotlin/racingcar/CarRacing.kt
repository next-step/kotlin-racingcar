package racingcar

import racingcar.util.RandomUtil

class CarRacing {
    fun participate(cars: List<Car>, tryCount: Int) {
        for (i in 1..tryCount) {
            println("${i}회 시도")
            cars.forEach {
                val randomNumber = RandomUtil.generateRandomNumber(0, 9)
                it.go(randomNumber)
                println(it.currentLocation())
            }
        }
    }
}
