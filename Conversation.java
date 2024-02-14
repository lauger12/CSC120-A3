import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;


class Conversation {
    public static void main(String[] args) {
        // Initial setup
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int roundnumber = 5; // assign an arbitrary default value to roundnumber before the user updates it
        String[] cannedresponses = { // our canned responses that will be randomly selected from
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

        String s = ""; //defining s, the user input variable
        String reply = ""; //defining reply, the chatbot reply variable

        //Start!
        System.out.println("\nHello, please give a number of rounds you would like this conversation to last"); // ask for # of rounds
        roundnumber = sc.nextInt(); // set the # of rounds to the user's input
        System.out.println("\nWelcome to Chatbot! What's up?"); // inital phrase from chatbot 
        ArrayList<String> transcript = new ArrayList<String>(2*roundnumber); // creating an Arraylist for strings for the transcript
        s = sc.nextLine(); // clear input buffer (enter)


        for (int i = 0; i < roundnumber; i++) {
            int ran = random.nextInt(0, 8); // get a new random number each round for our canned responses 
            s = sc.nextLine(); // get user input
            transcript.add(s); // add user input to transcript array
            String[] splittext = s.split("\\s+");

            if (s.contains("I") || s.contains("you") || s.contains("me") || s.contains("am") || s.contains("are") || s.contains("your") || s.contains("my")) {
                for (int n = 0; n < splittext.length; n++) {
                    if (splittext[n].equals("I'm")) {
                        splittext[n] = "you're";
                    }
                    else if (splittext[n].equals("you're")) {
                        splittext[n] = "I'm";
                    }
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
                transcript.add(reply + "?");
                }

                else {
                    System.out.println(cannedresponses[ran]); // Respond with a random canned response 
                    reply = cannedresponses[ran]; 
                    transcript.add(reply);
                }
            }
        System.out.println("Thanks for talking, goodbye! :)\n");
        sc.close(); //close scanner when done with it
        System.out.println("Transcript:");
        System.out.println("-----------");
        // give transcript
        for (int a = 0; a < transcript.size(); a++) {
            System.out.println(transcript.get(a));
        }
        }
    }


