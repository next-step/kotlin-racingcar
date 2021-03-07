package racingcar.ui

interface InputParser<T> {
    fun parse(input:String):T
}