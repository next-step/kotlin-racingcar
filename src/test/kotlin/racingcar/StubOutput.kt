package racingcar

import racingcar.view.output.Output

class StubOutput : Output {
    lateinit var result: String

    override fun show(message: String) {
        this.result = message
    }
}
