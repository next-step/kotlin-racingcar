package racingcar.ui

import java.util.function.Consumer
import java.util.function.Supplier

class InputView(builder: Builder) {

    val numOfCar = builder.numOfCar
    val numOfRepetition = builder.numOfRepetition

    class Builder {
        var numOfCar = 0
        var numOfRepetition = 0

        fun build() = InputView(this)

        fun player(consumer: Consumer<String>, numOfCar: Supplier<String?>): Builder {
            consumer.accept(TITLE_SET_UP_PLAYER)
            this.numOfCar = numOfCar.get()?.toIntOrNull() ?: throw NullPointerException("numOfCar is null")
            return this
        }

        fun repetition(consumer: Consumer<String>, numOfRepetition: Supplier<String?>): Builder {
            consumer.accept(TITLE_SET_UP_REPETITION)
            this.numOfRepetition =
                numOfRepetition.get()?.toIntOrNull() ?: throw IllegalArgumentException("numOfRepetition is null")
            return this
        }
    }

    companion object {
        private const val TITLE_SET_UP_PLAYER = "How many cars are there?"
        private const val TITLE_SET_UP_REPETITION = "How many repetitions?"

        fun builder() = Builder()
    }
}
