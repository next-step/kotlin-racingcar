package racing

fun main() {
    println("자동차 대수는 몇 대인가요?")
    val numberOfCars = readln().toInt()
    
    println("시도할 횟수는 몇 회인가요?")
    val tryCount = readln().toInt()
    
    Game(numberOfCars, tryCount).start()
}

class Game(
    private val numberOfCar: Int,
    private val tryCount: Int
) {
    private val carList = mutableListOf<Car>()
    
    fun start() {
        repeat(numberOfCar) {
            carList.add(Car(0))
        }
        
        repeat(tryCount) {
            run()
            println("")
        }
    }
    
    private fun run() {
        carList.forEach { 
            it.move()
            it.printPosition()
        }
    }
}