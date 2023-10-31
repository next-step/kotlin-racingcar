package calculator.operator

interface Operation {
    fun add(front: Double, back: Double): Double
    fun subtract(front: Double, back: Double): Double
    fun multiply(front: Double, back: Double): Double
    fun divide(front: Double, back: Double): Double
}
