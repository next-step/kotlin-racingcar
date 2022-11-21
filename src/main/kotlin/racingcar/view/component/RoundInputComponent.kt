package racingcar.view.component

import racingcar.domain.RoundFactory
import racingcar.view.store.RoundStore
import racingcar.view.ui.Input
import racingcar.view.ui.Span

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
