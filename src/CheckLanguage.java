import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CheckLanguage {

    private static final String A_ARTICLE = "a";
    private static final String THE_ARTICLE = "the";
    private static final String AN_ARTICLE = "an";

    private String[] preposition = {"in", "on", "to", "at", "of", "for",  "by"};
    private String[] splt;

    private int theCounter = 0;
    private int aCounter = 0;
    private int anCounter = 0;
    private int englishCounter = 0;
    private int articlesCounter = 0;
    private int russianCounter = 0;
    private int anotherCounter = 0;


    private Pattern pattern;
    private Matcher matcher;

    public void checkRussian(String text){
        articlesCounter = 0;
        pattern = Pattern.compile("^.*$");
        matcher = pattern.matcher(text);

        while (matcher.find()){
            if(!checkArticles(matcher.group()) && checkRussianCharacters(text)){
                russianCounter++;
            }
        }
    }
    private boolean checkRussianCharacters(String text){
        splt = text.split("\\s");

        for(int i = 0; i < splt.length; i++){

            try {
                if ((splt[i].charAt(i) < 'А' || splt[i].charAt(i) > 'я')) {
                    return false;
                }
            }catch (Exception ex){
                russianCounter++;
            }
        }
        return true;
    }

    public void checkEnglish(String text){
        articlesCounter = 0;
        pattern = Pattern.compile("^.*$");
        matcher = pattern.matcher(text);

        while (matcher.find()){
            if(checkArticles(matcher.group())){
                englishCounter++;
            }
        }
    }

    public void checkAnotherLanguage(String text){
        articlesCounter = 0;
        pattern = Pattern.compile("^.*$");
        matcher = pattern.matcher(text);

        while (matcher.find()){
            if(checkAnotherCharacters(matcher.group()) && !checkArticles(matcher.group())){
                anotherCounter++;
            }
        }
    }
    private boolean checkAnotherCharacters(String text){
        splt = text.split("\\s");

        for(int i = 0; i < splt.length; i++){

            if((splt[i].charAt(i) < 'A' || splt[i].charAt(i) > 'Z')
                    || (splt[i].charAt(i) < 'a' || splt[i].charAt(i) > 'z')){
                return true;

            }else if((splt[i].charAt(i) < 'А' || splt[i].charAt(i) > 'я')){

                return true;
            }
        }
        return false;
    }

    private boolean checkArticles(String text){
        splt = text.split("\\s");

        for(String origin : splt){
                switch (origin) {
                    case A_ARTICLE:
                        ++articlesCounter;
                        ++aCounter;
                        break;
                    case THE_ARTICLE:
                        ++theCounter;
                        ++articlesCounter;
                        break;
                    case  AN_ARTICLE:
                        ++anCounter;
                        ++articlesCounter;
                        break;
                }

        }
          if(aCounter > 0 && (anCounter == 0 && theCounter == 0)){
              return false;
          }else {
              return articlesCounter > 20;
          }
    }

    public void displayLanguage(){

        if(englishCounter > russianCounter && englishCounter > anotherCounter){
            System.out.println("English");
        }else if(anotherCounter > russianCounter && anotherCounter > englishCounter){
            System.out.println("Undefined language");
        }else if(russianCounter > anotherCounter && russianCounter > englishCounter){
            System.out.println("Russian");
        }
    }

}