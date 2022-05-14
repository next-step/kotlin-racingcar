package racing

object Show {
    fun result(carDistances: ArrayList<Array<Int>>) {
        for(round in 1..5) {
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

                if (car[i] == 1) { // 매직 넘버
                    print("-")
                }
            }
            println("")
        }
    }
}
