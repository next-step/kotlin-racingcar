package step3.racing

import step2.calculator.toLongOrThrow

object InputView {
  fun getCarCount(input: Any?): Long = input.toString().toLongOrThrow()
  fun getTryCount(input: Any?): Long = input.toString().toLongOrThrow()
}
