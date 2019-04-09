package digitalPages;

public class JavaCode {


    // [[Chase Freedome Visa, Rapid Rewards Plus Card, creditcards.chase.com, freedom, LearnMore]]
//
    public static void main(String[] args) {

        String text = "Chase Freedom Visa | Rapid Rewards Plus Card\n" +
                "\u202Acreditcards.chase.com/freedom/LearnMore\u202C\n" +
                "Eear 40,000 bonus points";
        System.out.println(text);

        String text1 = text.replace(" | ", "@");
        String[] text2 = text1.split("@");
        for (String b : text2) {
            System.out.println(b);
        }
    }

}