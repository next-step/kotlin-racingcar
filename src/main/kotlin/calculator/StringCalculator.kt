package calculator

import java.lang.IllegalArgumentException
import java.lang.NumberFormatException
import kotlin.jvm.Throws

class StringCalculator {

    companion object {

        @Throws(IllegalArgumentException::class)
        fun calc(input: String) : Any {
            val split = input.split(" ")
            var acc: Int = 0
            var block: (Int, Int) -> Int = Operation.ADD.block
            for (char: String in split) {
                when(val parseResult = parse(char)) {
                    is Operation -> block = parseResult.block
                    is Int -> acc = if(acc == 0) parseResult else block(acc, parseResult)
                }
            }
            return acc
        }

        private fun parse(input: String) = try {
            Integer.parseInt(input)
        } catch (e: NumberFormatException) {
            Operation.of(input)
        }
    }
}
