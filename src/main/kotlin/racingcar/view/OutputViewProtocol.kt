package racingcar.view

interface OutputViewProtocol {
    fun printLocation(location: Int)

    fun printName(name: String)

    fun printRaceResult(result: Set<String>)
}
