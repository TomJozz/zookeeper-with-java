
public class Main {
    public static void main(String[] args) {
        AnimalStatusReport.printReport();
    }
}

final class AnimalStatusReport {
    public static void printReport() {
        System.out.println("""
                I love animals!
                Let's check on the animals...
                The deer looks fine.
                The bat looks happy.
                The lion looks healthy."""
        );
    }
}