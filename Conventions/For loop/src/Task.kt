class DateRange(val start: MyDate, val end: MyDate) : Iterable<MyDate> {

    override fun iterator(): Iterator<MyDate> {
        var current = start
        return object : Iterator<MyDate> {
            override fun hasNext(): Boolean = current <= end

            override fun next(): MyDate {
                val toReturn = current
                current = current.followingDate()
                return toReturn
            }
        }
    }
}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in firstDate..secondDate) {
        handler(date)
    }
}