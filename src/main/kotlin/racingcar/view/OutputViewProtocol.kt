package racingcar.view

interface OutputViewProtocol {
    fun printLocation(location: Int)

    fun printName(name: String)

    fun printRaceWinner(result: Set<String>)
}
