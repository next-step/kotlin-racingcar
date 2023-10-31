package calculator.operator

object SimpleFourBasicOperation: Operation {
    override fun add(front: Double, back: Double): Double {
        return front + back
    }

    override fun subtract(front: Double, back: Double): Double {
        return front - back
    }

    override fun multiply(front: Double, back: Double): Double {
        return front * back
    }

    override fun divide(front: Double, back: Double): Double {
        return front / back
    }
}
