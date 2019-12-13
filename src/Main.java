public class Main {

    public static void main(String[] args) throws Exception {

        HTMLParser htmlParser = new HTMLParser();
        CheckLanguage check = new CheckLanguage();

        long start = System.currentTimeMillis();
        check.checkRussian(htmlParser.convertHtmlToTxtFile());
        check.checkEnglish(htmlParser.convertHtmlToTxtFile());
        check.checkAnotherLanguage(htmlParser.convertHtmlToTxtFile());
        long finish = System.currentTimeMillis() - start;

        System.out.printf("Время выполнения: %d\n",finish);
        check.displayLanguage();

    }

}