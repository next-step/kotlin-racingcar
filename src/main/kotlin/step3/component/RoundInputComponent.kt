package step3.component

import step3.RoundFactory
import step3.RoundStore

class RoundInputComponent: Component {
    private var inputComponent: InputComponent

    init {
        this.inputComponent = InputComponent(label = "시도할 횟수는 몇 회인가요?")
        this.inputComponent.addCommandListener(this::onCommand)
    }

    fun onCommand(value: String) {
        val rounds = RoundFactory.createMany(amount = value.toInt())
        RoundStore.saveAll(rounds)
    }

    override fun render() {
        this.inputComponent.render()
    }
}
