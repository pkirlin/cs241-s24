public class TimeSeconds extends Time {
    private int seconds;

    public TimeSeconds() {
        seconds = 0;
    }

    public String toString() {
        return getHour() + ":" + getMinute() + ":" + seconds;
    }

    public int getSeconds() {
        return seconds;
    }
}
