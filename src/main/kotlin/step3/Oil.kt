package step3

class Oil(val amount: Int) {
    operator fun compareTo(oil: Oil): Int {
        return this.amount.compareTo(oil.amount)
    }
}
