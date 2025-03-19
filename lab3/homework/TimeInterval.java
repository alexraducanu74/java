package homework;
import java.time.LocalTime;
import homework.Pair;

public class TimeInterval extends Pair<LocalTime, LocalTime> {

    public TimeInterval(LocalTime start, LocalTime end) {
        super(start, end);
    }

    public boolean conflictsWith(TimeInterval other) {
        return !(this.getFirst().isAfter(other.getSecond()) || this.getSecond().isBefore(other.getFirst()));
    }
}
