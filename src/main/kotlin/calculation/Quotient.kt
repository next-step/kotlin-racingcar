package calculation

class Quotient(lhs: String, rhs: String) : MathNumber() {
    override val value: Number

    init {
        if (rhs.toInt() == 0) {
            throw IllegalArgumentException()
        }
        this.value = lhs.toInt() / rhs.toInt()
    }
}
