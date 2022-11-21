package racingcar.view.store

import racingcar.domain.CarGroup

object CarGroupStore : Store<CarGroup>() {
    private var carGroup = CarGroup(cars = listOf())

    override fun getState(): CarGroup {
        return this.carGroup
    }

    override fun setState(state: CarGroup) {
        this.carGroup = state
        this.listeners.forEach { listener -> listener() }
    }

    override fun subscribe(listener: Listener): UnSubscribe {
        this.listeners.add(listener)
        return { this.listeners.remove(listener) }
    }
}
