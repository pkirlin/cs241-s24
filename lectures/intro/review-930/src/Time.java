public class Time implements Comparable<Time> {
    private int hour; // assume 24 hour clock, 0-23
    private int minute; // 0-59

    public Time() { // default constructor
        hour = 0;
        minute = 0; // represents midnight
    }

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public String toString() {
        return hour + ":" + minute;
    }

    public String toStringDebug() {
        return "hour = " + hour + ", minute = " + minute;
    }

    public int getHour() { // getter for hour
        return hour;
    }

    public int getMinute() { // getter for minute
        return minute;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        else if (!(obj instanceof Time otherTime)) {
            return false;
        }
        else {
            // if we get here, we know obj is an instanceof Time
            // cast
            // now we need to test whether our two times match
            return this.hour == otherTime.hour && this.minute == otherTime.minute;
        }
    }

    public int compareTo(Time otherTime) {
        if (this.hour < otherTime.hour) {
            return -1;
        } else if (this.hour > otherTime.hour) {
            return 1;
        } else {
            // now we know the hours are the same
            if (this.minute < otherTime.minute) {
                return -1;
            } else if (this.minute > otherTime.minute) {
                return 1;
            } else {
                // if we get here, we know the two times are equal
                return 0;
            }
        }
    }

}
