package calculation

class Quotient(lhs: String, rhs: String) : MathNumber() {
    override val value: Number

    init {
        require(rhs.toInt() != 0)
        this.value = lhs.toInt() / rhs.toInt()
    }
}
