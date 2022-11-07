package step2

class Adder(private val a: Int, private val b: Int) : Operator {
    override fun calculate(): Int = a + b
}
