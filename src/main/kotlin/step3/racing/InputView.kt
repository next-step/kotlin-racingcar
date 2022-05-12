package step3.racing

import step2.calculator.toLongOrThrow

object InputView {
  fun getLong(input: Any?): Long = input.toString().toLongOrThrow()
}
