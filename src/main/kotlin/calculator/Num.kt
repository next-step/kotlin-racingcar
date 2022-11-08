package calculator

data class Num(var value: Int) {

    constructor(value: String) : this(Integer.parseInt(value))

    fun add(number: Num) = Num(this.value + number.value)

    fun sub(number: Num) = Num(this.value - number.value)

    fun multiply(number: Num) = Num(this.value * number.value)

    fun divide(number: Num) = Num(this.value / number.value)
}
