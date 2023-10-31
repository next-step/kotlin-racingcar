package calculator.parser

import types.Try

interface Parser<T, R> {
    fun apply(input: T?): Try<R> {
        return Try.pure(input)
            .flatMap { checkNull(it) }
            .flatMap { parse(it) }
            .flatMap { validate(it) }
    }

    fun checkNull(inputStr: T?): Try<T>
    fun parse(inputStr: T): Try<R>
    fun validate(inputStr: R): Try<R>
}

data class ParserOutput<numberType, operandType>(
    val numbers: List<numberType>,
    val operands: List<operandType>
)
