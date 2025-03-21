fun main() {
    RacingCarGame().run()
}

class RacingCarGame {
    fun run() {
        println("How many cars in the race?")
        val amount: String? = readlnOrNull()

        println("How many rounds will be played?")
        val rounds: String? = readlnOrNull()
    }
}
