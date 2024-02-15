import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

class Conversation { // class for our conversation where all our methods will be 
    public static void main(String[] args) {
        // Initial setup
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int roundnumber = 5; // assign an arbitrary default value to roundnumber before the user updates it
        String[] cannedresponses = { // our canned responses that will be randomly selected from
                "Mhm",
                "Yup",
                "Uh-huh",
                "Interesting",
                "Hm!",
                "Wow",
                "Okay!",
                "Cool!",
                "*nods*"
        };

        String s = ""; // defining s, the user input variable
        String reply = ""; // defining reply, the chatbot reply variable

        // Start our conversation
        System.out.println("\nHello, please give a number of rounds you would like this conversation to last"); // ask for # of rounds
                                                                                                                

        roundnumber = sc.nextInt(); // set the # of rounds to the user's input
        System.out.println("\nWelcome to Chatbot! What's up?"); // inital phrase from chatbot
        ArrayList<String> transcript = new ArrayList<String>(2 * roundnumber); // creating an Arraylist (parameter String) for the transcript
                                                                               
        s = sc.nextLine(); // clear input buffer (enter)

        for (int i = 0; i < roundnumber; i++) {
            int ran = random.nextInt(0, 8); // get a new random number each round for our canned responses
            s = sc.nextLine(); // get user input
            transcript.add(s); // add user input to transcript
            String[] splittext = s.split("\\s+"); // splits the user input string into a string list, separating based on the whitespaces in the user input

            if (s.contains("was") || s.contains("were") || s.contains("I ") || s.contains("you ") || s.contains("me ")
                    || s.contains("am ") || s.contains("are ") || s.contains("your ") || s.contains("my ")
                    || s.contains("I'm ") || s.contains("you're ")) {
                for (int n = 0; n < splittext.length; n++) { // this goes through each word of split reply and will replace any found keywords with their output match
                    if (splittext[n].equals("was")) {
                        splittext[n] = "were";
                    } else if (splittext[n].equals("were")) {
                        splittext[n] = "was";
                    }
                    if (splittext[n].equals("I'm")) {
                        splittext[n] = "you're";
                    } else if (splittext[n].equals("you're")) {
                        splittext[n] = "I'm";
                    }
                    if (splittext[n].equals("I")) {
                        splittext[n] = "you";
                    } else if (splittext[n].equals("you")) {
                        splittext[n] = "I";
                    }
                    if (splittext[n].equals("are")) {
                        splittext[n] = "am";
                    } else if (splittext[n].equals("am")) {
                        splittext[n] = "are";
                    }
                    if (splittext[n].equals("me")) {
                        splittext[n] = "you";
                    }
                    if (splittext[n].equals("my")) {
                        splittext[n] = "your";
                    } else if (splittext[n].equals("your")) {
                        splittext[n] = "my";
                    }
                }
                reply = String.join(" ", splittext); // join the string list into a string so that it can properly be printed back with sout and be added to transcript
                System.out.println(reply + "?"); // reply with the changed words, and add a question marl
                transcript.add(reply + "?"); // add phrase to the transcript
            }

            else { // if no keywords are found
                System.out.println(cannedresponses[ran]); // Respond with a random canned response
                reply = cannedresponses[ran];
                transcript.add(reply); // add phrase to the transcript
            }
        }
        System.out.println("Thanks for talking, goodbye! :)\n"); // after the # of rounds pass, print the goodbye 
        sc.close(); // close scanner when done with it
        System.out.println("Transcript:"); // header for transcript 
        System.out.println("-----------"); // line below transcript (for formatting)
        // give transcript
        for (int a = 0; a < transcript.size(); a++) { // loop will go for each item (phrase) in the transcript
            System.out.println(transcript.get(a)); // get and print the current word matching the loop repeat "a" that we are on
        }
        System.out.println("\n"); // to space out the end of the transcript with the virtual machine/file info that's printed at the end
    }
}
