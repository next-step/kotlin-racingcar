package calculation

class Product(lhs: String, rhs: String) : MathNumber() {
    override val value: Number

    init {
        value = lhs.toInt() * rhs.toInt()
    }
}
