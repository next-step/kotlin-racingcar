package racing

object RacingView {
    private val DISPLAY_NUMBER = 1
    fun result(round: Int, carDistances: ArrayList<Array<Int>>) {
        for(round in 0 until round) {
            println("$round round")
            printDistance(round, carDistances)
        }
    }

    private fun printDistance(round: Int, carDistances: ArrayList<Array<Int>>) {
        for(car in carDistances) {
            for(i in 0..car.size) {
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
