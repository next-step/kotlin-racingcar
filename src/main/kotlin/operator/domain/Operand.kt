package operator.domain

data class Operand(val num: Double) {

    operator fun plus(target: Operand): Operand {
        return Operand(num + target.num)
    }

    operator fun minus(target: Operand): Operand {
        return Operand(num - target.num)
    }

    operator fun times(target: Operand): Operand {
        return Operand(num * target.num)
    }

    operator fun div(target: Operand): Operand {
        return Operand(num / target.num)
    }
}
