package view

class InputView {
    fun enterAmountOfCars(): Int {
        println("How many cars in the race?")
        val cars = (readlnOrNull()
            ?: throw IllegalArgumentException("[ERROR] Enter valid number for amount of cars")).toInt()
        if (cars <= 0) {
            throw IllegalArgumentException("[ERROR] Enter positive number for amount of cars")
        }
        return cars
    }

    fun enterAmountOfRounds(): Int {
        println("How many rounds will be played?")
        val rounds = (readlnOrNull()
            ?: throw IllegalArgumentException("[ERROR] Enter valid number for amount of rounds")).toInt()
        if (rounds <= 0) {
            throw IllegalArgumentException("[ERROR] Enter positive number for amount of rounds")
        }
        return rounds
    }
}
