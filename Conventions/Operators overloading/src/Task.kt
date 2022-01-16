import TimeInterval.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

// Supported intervals that might be added to dates:
enum class TimeInterval { DAY, WEEK, YEAR; }

class ExtendedTimeInterval(val timeInterval: TimeInterval, val times: Int)

private operator fun TimeInterval.times(i: Int): ExtendedTimeInterval {
    return ExtendedTimeInterval(this, i)
}

operator fun MyDate.plus(timeInterval: TimeInterval): MyDate {
    return addTimeIntervals(timeInterval, 1)
}

private operator fun MyDate.plus(extendedTimeInterval: ExtendedTimeInterval): MyDate {
    return addTimeIntervals(extendedTimeInterval.timeInterval, extendedTimeInterval.times)
}

fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}
