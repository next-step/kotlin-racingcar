package view

class InputView {
    fun enterAmountOfCars(): Int {
        println("How many cars in the race?")
        return (readlnOrNull() ?:
        throw IllegalArgumentException("[ERROR] Enter valid number for amount of cars")).toInt()
    }

    fun enterAmountOfRounds(): Int {
        println("How many rounds will be played?")
        return (readlnOrNull() ?:
        throw IllegalArgumentException("[ERROR] Enter valid number for amount of rounds")).toInt()
    }
}
