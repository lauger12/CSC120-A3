

class test{

public static void main(String[] args) {
    String phrase = "I am thinking";
    String[] splittext = phrase.split("\\s+");


for (int i = 0; i < splittext.length; i++){
    if (splittext[i].equals("I")){
        splittext[i] = "you";
    }
    else if (splittext[i].equals("you")){
        splittext[i] = "I";
    }
    if (splittext[i].equals("are")){
        splittext[i] = "am";
    }
    else if (splittext[i].equals("am")){
        splittext[i] = "are";
    }

}
String response = String.join(" ", splittext);
System.out.println(response + "?");
}
}


// for String line in transcript{
// }