package calculator

import java.util.Deque
import java.util.LinkedList

class Calculator {
    companion object {
        fun convertToDq(input: String): Deque<String> {
            var dq: Deque<String> = LinkedList()
            val result: List<String> = input.split(" ")
            dq.addAll(result)
            return dq
        }

        fun calculate(input: String?): Long {
            Checker.checkInput(input)
            var target = convertToDq(input!!)

            var mid = ""
            while (target.size != 1) {
                var x = target.poll().toInt()
                var op = target.poll()
                Operator.checkOperator(op)
                var y = target.poll().toInt()
                mid = Operator.operate(x, y, Operator.operateTo(op)!!).toString()
                target.addFirst(mid)
            }
            return mid.toLong()
        }
    }
}
