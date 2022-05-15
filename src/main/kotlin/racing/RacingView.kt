package racing

object RacingView {
    private const val DISPLAY_NUMBER = 1
    fun result(round: Int, carDistances: List<MutableList<Int>>) {
        for (currentRound in 0 until round) {
            println("${currentRound + 1} round")
            printDistance(currentRound, carDistances)
        }
    }

    private fun printDistance(round: Int, carDistances: List<MutableList<Int>>) {
        for (car in carDistances) {
            for (i in 0..car.size) {
                if (i >= round) {
                    break
                }

                if (car[i] == DISPLAY_NUMBER) {
                    print("-")
                }
            }
            println("")
        }
    }
}
