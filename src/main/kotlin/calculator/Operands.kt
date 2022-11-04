package calculator

private const val CALCULABLE = 2

class Operands {

    val operands : ArrayDeque<Int> = ArrayDeque()

    fun add(operand : Int){
        validate()
        this.operands.add(operand)
    }

    fun add(operand : String){
        validate()
        try{
            this.operands.add(operand.toInt())
        }catch (e: java.lang.NumberFormatException){
           throw IllegalArgumentException("피연산자는 숫자여야만 합니다.");
        }
    }

    private fun validate() {
        if (operands.size >= CALCULABLE) {
            throw IllegalArgumentException("유효하지 않은 입력값입니다.")
        }
    }

    fun isCalculable() = this.operands.size == CALCULABLE

    fun getOperand() = this.operands.removeFirst()

    fun getResult() :Int{
        if (this.operands.size != 1){
            throw IllegalArgumentException("유효하지 않은 입력값입니다.")
        }
        return getOperand()
    }
}
