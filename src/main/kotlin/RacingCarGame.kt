import kotlin.random.Random

fun main() {
    RacingCarGame().run()
}

class RacingCarGame {
    fun run() {
        println("How many cars in the race?")
        val amount: String = readlnOrNull() ?: throw IllegalArgumentException()

        println("How many rounds will be played?")
        val rounds: String = readlnOrNull() ?: throw IllegalArgumentException()

        val cars: MutableList<Int> = MutableList(amount.toInt()) { 0 }
        println("Race Results:")
        for (i in 0 until rounds.toInt()) {
            for(j in 0 until amount.toInt()) {
                val number = generateRandomNumber()
                if(number >= 4) {
                    cars[j]++
                }
            }

            for(j in 0 until amount.toInt()) {
                println("-".repeat(cars[j]))
            }
            println()
        }
    }

    private fun generateRandomNumber(): Int {
        return Random.nextInt(10)
    }
}
