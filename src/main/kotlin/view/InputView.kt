package view

class InputView {
    fun enterAmountOfRounds(): Int {
        println("How many rounds will be played?")
        val rounds = (readlnOrNull()
            ?: throw IllegalArgumentException("[ERROR] Enter valid number for amount of rounds")).toInt()
        if (rounds <= 0) {
            throw IllegalArgumentException("[ERROR] Enter positive number for amount of rounds")
        }
        return rounds
    }

    fun enterCarNames(): List<String> {
        println("Enter the names of the cars (separated by commas):")
        return readlnOrNull()?.split(",")?.map {it.trim()}
            ?: throw IllegalArgumentException("[ERROR] Enter valid car names")
    }
}
