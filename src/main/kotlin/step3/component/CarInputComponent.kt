package step3.component

import step3.CarFactory
import step3.CarStore

class CarInputComponent : Component {
    private var inputComponent: InputComponent

    init {
        this.inputComponent = InputComponent(label = "자동차 대수는 몇 대인가요?")
        this.inputComponent.addCommandListener(this::onCommand)
    }

    fun onCommand(value: String) {
        val cars = CarFactory.createMany(amount = value.toInt())
        CarStore.saveAll(cars)
    }

    override fun render() { this.inputComponent.render() }
}
