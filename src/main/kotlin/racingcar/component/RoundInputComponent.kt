package racingcar.component

import racingcar.RoundFactory
import racingcar.store.RoundStore
import racingcar.ui.Input
import racingcar.ui.Span

class RoundInputComponent : Component {
    private val span = Span("시도할 횟수는 몇 회인가요?", block = true)
    private var input = Input()

    init { this.input.addCommandListener(this::onCommand) }

    fun onCommand(value: String) {
        val rounds = RoundFactory.createMany(amount = value.toInt())
        RoundStore.setState(rounds)
    }

    override fun render() {
        this.span.draw()
        this.input.draw()
    }
}
