package calculator

interface Calculator {
    fun parse(line: String)
    fun calculate()
    fun result(): Number
}
