public class Date {
    private int month; // 1-12
    private int day; // 1-31 based on month
    private int year; // any year

    // constructor: confirm proper value for month and day given the year
    public Date(int month, int day, int year) {
        // check if month in range
        if (month <= 0 || month > 12) {
            throw new IllegalArgumentException(
                "month (" + month + ") must be 1-12");
        }

        // check if day in range for month
        if (day <= 0 || 
            (day > 31 && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)) ||
            (day > 30 && (month == 4 || month == 6 || month == 9 || month == 11)) ||
            (day > 29 && month == 2) ||
            (day > 28 && month == 2 && !isLeapYear(year))) {
            throw new IllegalArgumentException(
                "day (" + day + ") out-of-range for the specified month and year");
        }

        this.month = month;
        this.day = day;
        this.year = year;

        System.out.printf(
            "Date object constructor for date %s%n", this);
    }

    // utility method to confirm whether the year is a leap year
    private boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    // return day
    public int getDay() {
        return day;
    }

    // return month
    public int getMonth() {
        return month;
    }

    // return year
    public int getYear() {
        return year;
    }

    // return a String of the form month/day/year
    @Override
    public String toString() {
        return String.format("%d/%d/%d", month, day, year);
    }
}
