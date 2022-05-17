package step3.racing

object ResultView {
    fun showDistance(name: String, input: Int) {
        print("$name : ")
        repeat(input) { print("-") }
        println()
    }

    fun showFirstRacer(name: String) = println("$name 가 최종 우승했습니다.")
}
