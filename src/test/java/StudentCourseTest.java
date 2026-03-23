import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Disabled; // Tambahkan import ini
import org.junit.jupiter.api.Test;


public class StudentCourseTest {
    private Course course;
    private Student currentStudent;

    @BeforeEach
    void initMethod() {
        course = new Course("CS101", "OOP");
        currentStudent = new Student("S001", "Budi");
        System.out.println("Method Level Setup: New Course & Student Prepared");
    }

    @Test
    void testStudentEnroll() {
        course.enrollStudent(currentStudent);
        Assertions.assertEquals(1, course.getStudentCount());
    }

    @Test
    void testStudentUnenroll() {
        course.enrollStudent(currentStudent);
        course.unenrollStudent(currentStudent);
        Assertions.assertEquals(0, course.getStudentCount(), "Jumlah student harus 0 setelah unenroll");
    }

    @AfterEach
    void cleanMethod() {
        System.out.println("Method Level Cleanup");
    }
}
