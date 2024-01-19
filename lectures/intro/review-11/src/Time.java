public class Time implements Comparable<Time> {
    private int hour;  // 24 hour clock, 0-23
    private int minute;  // 0-59

    public Time() {  // default constructor
        hour = 0;
        minute = 0;
    }

    public Time(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public String toString() {
        return hour + ":" + minute;
    }

    public String toStringDebug() {
        return "hour=" + hour + ", minute=" + minute;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setHour(int h) {
        if (h >= 0 && h <= 23) {
            hour = h;
        }
    }

    public void setMinute(int m) {
        minute = m;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        else if (!(obj instanceof Time)) {
            return false;
        }
        else {
            Time otherTime = (Time)obj;   // cast

            if (this.hour == otherTime.hour && this.minute == otherTime.minute) {
                return true;
            }
        }
        return false;
    }


    @Override
    public int compareTo(Time otherTime) {
        if (this.hour < otherTime.hour) {
            return -1;
        }
        else if (this.hour > otherTime.hour) {
            return 1;
        }
        else {
            if (this.minute < otherTime.minute) {
                return -1;
            }
            else if (this.minute > otherTime.minute) {
                return 1;
            }
            else {
                return 0; // can only happen if hours and minutes match
            }
        }
    }
}
