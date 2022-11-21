package racingcar.view.store

import racingcar.domain.CarGroup

object CarGroupStore : Store<CarGroup>(initialState = CarGroup(cars = listOf()))
