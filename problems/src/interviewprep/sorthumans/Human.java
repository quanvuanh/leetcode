package interviewprep.sorthumans;

import java.time.LocalDate;

public record Human(
  LocalDate birthday,
  String name
) {
}
