public class TimeSeconds extends Time {
    private int seconds;

    public TimeSeconds() {
        seconds = 10;
    }

    public String toString() {
        return getHour() + ":" + getMinute() + ":" + seconds;
    }
}
