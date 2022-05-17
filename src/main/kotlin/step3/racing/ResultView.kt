package step3.racing

object ResultView {
    fun showDistance(name: String, distance: Int) {
        print("$name : ")
        repeat(distance) { print("-") }
        println()
    }

    fun showWinner(names: String) = println("$names 가 최종 우승했습니다.")
}
