package interview.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;

public class DateUtils {

    public static final ZoneId MOSCOW_OFFSET = ZoneId.of("Europe/Moscow");

    private DateUtils() {
    }

    public static LocalDateTime offsetToLocal(OffsetDateTime offsetDateTime) {
        Instant instant = offsetDateTime.toInstant();
        return offsetDateTime.withOffsetSameInstant(MOSCOW_OFFSET.getRules().getOffset(instant)).toLocalDateTime();
    }

    public static OffsetDateTime localToOffset(LocalDateTime localDateTime) {
        return OffsetDateTime.of(localDateTime, MOSCOW_OFFSET.getRules().getOffset(localDateTime));
    }

    public static LocalDateTime nowMoscow() {
        return offsetToLocal(OffsetDateTime.now());
    }

    public static LocalDate moscowDate() {
        return offsetToLocal(OffsetDateTime.now()).toLocalDate();
    }

    public static LocalTime moscowTime() {
        return offsetToLocal(OffsetDateTime.now()).toLocalTime();
    }

}

