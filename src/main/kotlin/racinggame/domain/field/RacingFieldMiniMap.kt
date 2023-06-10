package racinggame.domain.field

import racinggame.domain.car.factory.RacingCarUniqueKey

interface RacingFieldMiniMap {

    val racingFieldMap: Map<RacingCarUniqueKey, Field>
}
