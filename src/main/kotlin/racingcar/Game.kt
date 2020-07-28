package racingcar

class Game {
    val cars = mutableListOf<Car>()
    var moveTime = 0

    fun makeCars(number: Int) {
        for (num in 1..number) {
            val car = Car()
            cars.add(car)
        }
    }

    fun readyGame(carNum: Int, moveTime: Int) {
        makeCars(carNum)
        this.moveTime = moveTime
    }

    fun startGame() {
        for (x in 1..moveTime) {
            println("${x}번째 입니다")
            for (car in cars) {
                car.goStop(car.isGo(car.randomValue()))
                println(car.viewMove)
            }
            println()
        }
    }
}
