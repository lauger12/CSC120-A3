import java.util.Random;
import java.util.Scanner;

class Conversation {
    public static void main(String[] args) {
        // Initial setup
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int roundnumber = 5; // assign an arbitrary default value to roundnumber before the user updates it
        String[] cannedresponses = {
            "mhm",
            "yup",
            "uh-huh",
            "interesting",
            "hmm",
            "wow",
            "urm",
            "erm",
            "*nods*"
        };

        String s = "";
        String reply = "";

        //Start!
        System.out.println("Hello, please give a number of rounds you would like this conversation to last");
        roundnumber = sc.nextInt();
        System.out.println("Welcome to Chatbot! What's up?");
        s = sc.nextLine(); // clear input buffer (enter)

        for (int i = 0; i < roundnumber; i++) {
            int ran = random.nextInt(0, 8); // get a new random number each round for our canned responses 
            s = sc.nextLine(); // get user input
            String[] splittext = s.split("\\s+");

            if (s.contains("I") || s.contains("you") || s.contains("me") || s.contains("am") || s.contains("are") || s.contains("your") || s.contains("my")) {
                for (int n = 0; n < splittext.length; n++) {
                    if (splittext[n].equals("I")) {
                        splittext[n] = "you";
                    } else if (splittext[n].equals("you")) {
                        splittext[n] = "I";
                    }
                    if (splittext[n].equals("are")) {
                        splittext[n] = "am";
                    } 
                    else if (splittext[n].equals("am")) {
                        splittext[n] = "are";
                    }
                    if (splittext[n].equals("me")) {
                        splittext[n] = "you";
                    }
                    if (splittext[n].equals("my")) {
                        splittext[n] = "your"; 
                    }
                    else if (splittext[n].equals("your")) {
                        splittext[n] = "my";
                    }
                }
                reply = String.join(" ", splittext);
                System.out.println(reply + "?");
                }

                else {
                    System.out.println(cannedresponses[ran]); // Respond with a random canned response 
                    reply = cannedresponses[ran];
                }
            }
        System.out.println("Thanks for talking, goodbye! :)");
        sc.close(); //close scanner when done with it
        // give transcript
        }
    }
