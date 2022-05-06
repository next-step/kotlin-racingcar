package step2

abstract class Calculator {
    abstract fun calculate(firstNum: Int, secondNum: Int): Int
}

class PlusCalculator : Calculator() {
    override fun calculate(firstNum: Int, secondNum: Int): Int {
        return firstNum + secondNum
    }
}

class MinusCalculator : Calculator() {
    override fun calculate(firstNum: Int, secondNum: Int): Int {
        return firstNum - secondNum
    }
}

class MultipleCalculator : Calculator() {
    override fun calculate(firstNum: Int, secondNum: Int): Int {
        return firstNum * secondNum
    }
}

class DivisionCalculator : Calculator() {
    override fun calculate(firstNum: Int, secondNum: Int): Int {
        if (firstNum % secondNum != 0) {
            throw IllegalArgumentException()
        }
        return firstNum / secondNum
    }
}
