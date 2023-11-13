package racing

class ResultView {
    fun view(cars: List<Car>) {
        cars.forEach {
            print("${it.name} : ")
            repeat(it.position) {
                print("-")
            }
            println()
        }
        println()
    }
    
    fun viewWinner(names: List<String>) {
        println("${names.joinToString(", ")}(이)가 최종 우승했습니다.")
    }
}
