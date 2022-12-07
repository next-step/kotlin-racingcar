package src.racingcar

object ResultView {
    fun printRacingCarGameResult(tryCount: Int, raceCars: MutableList<Car>) {
        repeat(tryCount) {
            printRacing(raceCars)
        }

        printWinner(Winner(raceCars).findWinners())
    }

    private fun printRacing(raceCars: MutableList<Car>) {
        for (raceCar in raceCars) {
            print(raceCar.getCarName())
            print(" : ")
            println("-".repeat(raceCar.getMoveCount()))
        }
        println()
    }

    private fun printWinner(findWinners: List<Car>) {
        print(findWinners.joinToString { car -> car.getCarName() })
        print("가 최종 우승 했습니다.")
    }
}
