import java.util.Scanner;

public class Zookeeper {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            HabitatViewer viewer = new HabitatViewer(sc);
            viewer.run();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            System.out.println("See you later!");
        }
    }
}

final class HabitatViewer {
    private final Scanner sc;

    public HabitatViewer(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        while(true) {
            displayAnimalOptions();
            System.out.print("Please enter the number of the habitat you would like to view: ");

            String input = sc.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            Animal[] animals = Animal.values();
            try {
                int choice = Integer.parseInt(input);
                if (choice < animals.length && choice >= 0) {
                    System.out.println("\nSwitching on the camera in the "+ animals[choice].toString() +" habitat...");
                    animals[choice].showHabitat();
                }

            } catch (Exception e) {
                System.out.println("Invalid choice. Please enter a number between 0 and " +
                        (animals.length - 1) + "or 'exit'.");
            }
        }
    }

    private void displayAnimalOptions() {
        for (Animal animal : Animal.values()) {
            System.out.printf("%s - %d, ", animal.toString(), animal.ordinal());
        }
        System.out.println("or type 'exit' to quit.");
    }
}

enum Animal {
    CAMEL("camel", """
             ___.-''''-.
            /___  @    |
            ',,,,.     |         _.'''''''._
                 '     |        /           \\
                 |     \\    _.-'             \\
                 |      '.-'                  '-.
                 |                               ',
                 |                                '',
                  ',,-,                           ':;
                       ',,| ;,,                 ,' ;;
                          ! ; !'',,,',',,,,'!  ;   ;:
                         : ;  ! !       ! ! ;  ;   :;
                         ; ;   ! !      ! !  ; ;   ;,
                        ; ;    ! !     ! !   ; ;
                        ; ;    ! !    ! !     ; ;
                       ;,,      !,!   !,!     ;,;
                       /_I      L_I   L_I     /_I
            Look at that! Our little camel is sunbathing!"""
    ),
    LION("lion", """
                                                           ,w.
                                                         ,YWMMw  ,M  ,
                                    _.---.._   __..---._.'MMMMMw,wMWmW,
                               _.-""        '''           YP"WMMMMMMMMMb,
                            .-' __.'                   .'     MMMMW^WMMMM;
                _,        .'.-'"; `,       /`     .--""      :MMM[==MWMW^;
             ,mM^"     ,-'.'   /   ;      ;      /   ,       MMMMb_wMW"  @\\
            ,MM:.    .'.-'   .'     ;     `\\    ;     `,     MMMMMMMW `"=./`-,
            WMMm__,-'.'     /      _.\\      F'''-+,,   ;_,_.dMMMMMMMM[,_ / `=_}
            "^MP__.-'    ,-' _.--""   `-,   ;       \\  ; ;MMMMMMMMMMW^``; __|
                       /   .'            ; ;         )  )`{  \\ `"^W^`,   \\  :
                      /  .'             /  (       .'  /     Ww._     `.  `"
                     /  Y,              `,  `-,=,_{   ;      MMMP`""-,  `-._.-,
                    (--, )                `,_ / `) \\/"")      ^"      `-, -;"\\:
            The lion is roaring!"""
    ),
    DEER("deer", """
               /|       |\\
            `__\\       //__'
               ||      ||
             \\__`\\     |'__/
               `_\\   //_'
               _.,:---;,._
               \\_:     :_/
                 |@. .@|
                 |     |
                 ,\\.-./ \\
                 ;;`-'   `---__________-----.-.
                 ;;;                         \\_\\
                 ';;;                         |
                  ;    |                      ;
                   \\   \\     \\        |      /
                    \\_, \\    /        \\     |\\
                      |';|  |,,,,,,,,/ \\    \\ \\_
                      |  |  |           \\   /   |
                      \\  \\  |           |  / \\  |
                       | || |           | |   | |
                       | || |           | |   | |
                       | || |           | |   | |
                       |_||_|           |_|   |_|
                      /_//_/           /_/   /_/
            Our 'Bambi' looks hungry. Let's go to feed it!"""
    ),
    GOOSE("goose", """
            
                                                _
                                            ,-"" "".
                                          ,'  ____  `.
                                        ,'  ,'    `.  `._
               (`.         _..--.._   ,'  ,'        \\    \\
              (`-.\\    .-""        ""'   /          (  d _b
             (`._  `-"" ,._             (            `-(   \\
             <_  `     (  <`<            \\              `-._\\
              <`-       (__< <           :
               (__        (_<_<          ;
                `------------------------------------------
            The goose is staring intently at you... Maybe it's time to change the channel?"""
    ),
    BAT("bat", """
            _________________               _________________
             ~-.              \\  |\\___/|  /              .-~
                 ~-.           \\ / o o \\ /           .-~
                    >           \\  W  //           <
                   /             /~---~\\             \\
                  /_            |       |            _\\
                     ~-.        |       |        .-~
                        ;        \\     /        i
                       /___      /\\   /\\      ___\\
                            ~-. /  \\_/  \\ .-~
                               V         V
            This bat looks like it's doing fine."""
    ),
    RABBIT("rabbit", """
                     ,
                    /|      __
                   / |   ,-~ /
                  Y :|  //  /
                  | jj /( .^
                  >-"~"-v"
                 /       Y
                jo  o    |
               ( ~T~     j
                >._-' _./
               /   "~"  |
              Y     _,  |
             /| ;-"~ _  l
            / l/ ,-"~    \\
            \\//\\/      .- \\
             Y        /    Y
             l       I     !
             ]\\      _\\    /"\\
            (" ~----( ~   Y.  )
            It looks like we will soon have more rabbits!"""
    );

    private final String name;
    private final String asciiCam;

    Animal(String name, String asciiCam) {
        this.name = name;
        this.asciiCam = asciiCam;
    }

    public void showHabitat(){
        System.out.println(asciiCam);
    }

    @Override
    public String toString() {
        return name;
    }
}