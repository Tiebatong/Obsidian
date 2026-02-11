package planer;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.SortedMap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SchedulerTest {

    @Test
    @DisplayName("2 persons distributed to 10 weeks, without any rounding problems")
    void test_1() {
        Scheduler scheduler = new Scheduler(new String[]{"A", "70", "B", "30"});
        SortedMap<Integer, String> assignments = scheduler.assignNamesToWeeks(10);
        assertThat(assignments.values()).containsExactlyInAnyOrder("A", "A", "A", "A", "A", "A", "A", "B", "B", "B");
    }

    @Test
    @DisplayName("2 persons distributed to 5 weeks with rounding")
    void test_2() {
        Scheduler scheduler = new Scheduler(new String[]{"A", "70", "B", "30"});
        SortedMap<Integer, String> assignments = scheduler.assignNamesToWeeks(5);
        assertThat(assignments.values()).hasSize(5);
        assertThat(assignments.values().stream().limit(4)).containsExactlyInAnyOrder("A", "A", "A", "B");
        assertThat(assignments.values().stream().skip(4).findFirst().get()).isIn("A (Pech gehabt)", "B (Pech gehabt)");
    }

    @Test
    @DisplayName("3 persons distributed to 7 weeks")
    void test_3() {
        Scheduler scheduler = new Scheduler(new String[]{"A", "30", "B", "30", "C", "30"});
        SortedMap<Integer, String> assignments = scheduler.assignNamesToWeeks(7);
        assertThat(assignments.values()).hasSize(7);
        assertThat(assignments.values().stream().limit(6)).containsExactlyInAnyOrder("A", "A", "B", "B", "C", "C");
        assertThat(assignments.values().stream().skip(6).findFirst().get()).isIn("A (Pech gehabt)", "B (Pech gehabt)", "C (Pech gehabt)");
    }

    @Test
    @DisplayName("3 persons distributed to 8 weeks")
    void test_4() {
        Scheduler scheduler = new Scheduler(new String[]{"A", "30", "B", "30", "C", "30"});
        SortedMap<Integer, String> assignments = scheduler.assignNamesToWeeks(8);
        assertThat(assignments.values()).hasSize(8);
        String secondToLastPerson = assignments.values().stream().skip(6).findFirst().get();
        String lastPerson = assignments.values().stream().skip(7).findFirst().get();
        assertThat(assignments.values().stream().limit(6)).containsExactlyInAnyOrder("A", "A", "B", "B", "C", "C");
        assertThat(secondToLastPerson).isIn("A (Pech gehabt)", "B (Pech gehabt)", "C (Pech gehabt)");
        assertThat(lastPerson).isIn("A (Pech gehabt)", "B (Pech gehabt)", "C (Pech gehabt)");
        assertThat(secondToLastPerson).isNotEqualTo(lastPerson);
    }

    @Test
    @DisplayName("odd number of arguments throws IAE")
    void test_5() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> new Scheduler(new String[]{"A", "30", "B"}));
        assertThat(illegalArgumentException).hasMessageContaining("even");
    }

    @Test
    @DisplayName("invalid area string throws IAE")
    void test_6() {
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> new Scheduler(new String[]{"A", "foo"}));
        assertThat(illegalArgumentException).hasMessageContaining("area").hasMessageContaining("foo");
    }

    @Test
    @DisplayName("negative number of weeks throws IAE")
    void test_7() {
        Scheduler scheduler = new Scheduler(new String[]{"A", "10"});
        IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> scheduler.assignNamesToWeeks(-1));
        assertThat(illegalArgumentException).hasMessageContaining("negative");
    }

    @Test
    @DisplayName("0 weeks are okay")
    void test_8() {
        Scheduler scheduler = new Scheduler(new String[]{"A", "10"});
        SortedMap<Integer, String> assignment = scheduler.assignNamesToWeeks(0);
        assertThat(assignment).isEmpty();
    }
}
