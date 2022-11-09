package calculator

class Calculator(
    private val cpu: CPU = CPU(),
    private val keypad: Keypad = Keypad(),
    private val monitor: Monitor = Monitor(),
    private var memory: Memory = Memory()
) {

    init {
        monitor.display("----on----")
    }

    fun pressButton(input: String?) {
        val terms: List<String> = if (input == null) {
            keypad.pressed()
        } else {
            keypad.pressed(input)
        }

        memory.store(terms)
    }

    fun calculate(): Int {
        for (index: Int in 1 until memory.size() step 2) {
            val accumulator = memory.accumulator
            val operator = Operator.getByValue(memory.fetch(index))
            val operand = memory.fetch(index + 1).toInt()

            val result = cpu.execute(operator, accumulator, operand)
            memory.accumulate(result)
        }

        monitor.display(memory.accumulator.toString())
        return memory.accumulator
    }
}
