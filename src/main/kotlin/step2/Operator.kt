package step2

class Operator(val calculateBlock: (a: Double, b: Double) -> Double) {
    fun <T : Number> execute(a: T, b: T) = calculateBlock(a.toDouble(), b.toDouble())
}
