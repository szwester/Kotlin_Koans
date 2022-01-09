data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override operator fun compareTo(date2: MyDate): Int {
        return if (year != date2.year) {
            year - date2.year
        } else if (month != date2.month) {
            month - date2.month
        } else
            dayOfMonth - date2.dayOfMonth
    }
}

fun test(date1: MyDate, date2: MyDate) {
    // this code should compile:
    println(date1 < date2)
}
