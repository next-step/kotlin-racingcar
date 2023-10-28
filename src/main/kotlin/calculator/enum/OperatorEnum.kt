package calculator.enum

import calculator.operator.SimpleFourBasicOperation

sealed class Op {
    companion object {
        fun match(sign: String): Op {
            return when (sign) {
                "+" -> Add()
                "-" -> Subtract()
                "*" -> Multiply()
                "/" -> Divide()
                else -> throw IllegalArgumentException("")
            }
        }
    }
    val operation = SimpleFourBasicOperation
    abstract val sign: String
    abstract fun run(front: Double, back: Double): Double
}

class Add : Op() {
    override val sign = "+"
    override fun run(front: Double, back: Double): Double {
        return operation.add(front, back)
    }
}
class Subtract : Op() {
    override val sign = "-"
    override fun run(front: Double, back: Double): Double {
        return operation.subtract(front, back)
    }
}
class Multiply : Op() {
    override val sign = "*"
    override fun run(front: Double, back: Double): Double {
        return operation.multiply(front, back)
    }
}
class Divide : Op() {
    override val sign = "/"
    override fun run(front: Double, back: Double): Double {
        return operation.divide(front, back)
    }
}



