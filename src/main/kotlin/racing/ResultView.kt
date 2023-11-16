package racing

class ResultView {
    fun view(cars: List<Car>) {
        cars.forEach {
            viewCar(it)
        }
        println()
    }
    
    fun viewWinner(names: List<String>) {
        println("${names.joinToString(", ")}(이)가 최종 우승했습니다.")
    }
    
    private fun viewCar(car: Car) {
        print("${car.name} : ")
        repeat(car.position) {
            print("-")
        }
        println()
    }
}
