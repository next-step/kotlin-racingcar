package racingcar.view

class OutputView : OutputViewProtocol {

    override fun printLocation(location: Int) {
        for (i in 0 until location) {
            print("-")
        }
        println()
    }

    override fun printName(name: String) {
        print("$name : ")
    }

    override fun printRaceWinner(result: Set<String>) {
        result.forEachIndexed { index, str ->
            print(str)
            if (index != result.size - 1) {
                print(", ")
            }
        }
        println("가 최종 우승했습니다.")
    }
}
