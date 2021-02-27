package calculation

class Quotient(lhs: String, rhs: String) : MathNumber() {
    override val value: Number by lazy { lhs.toInt() / rhs.toInt() }

    init {
        require(rhs.toInt() != 0)
    }
}
