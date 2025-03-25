package carracing

class InputView {
    fun inputTotalCar(): Int {
        println("How many cars are in the race?")
        return readLine()!!.toInt()
    }

    fun inputTotalRound(): Int {
        println("How many rounds will be played?")
        return readLine()!!.toInt()
    }
}
