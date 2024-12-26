package study.step3.domain

@JvmInline
value class Mileage(val value: Int) {
    operator fun plus(mileage: Mileage): Mileage {
        return Mileage(this.value + mileage.value)
    }
}
