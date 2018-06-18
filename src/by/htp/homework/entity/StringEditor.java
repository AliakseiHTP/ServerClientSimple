package by.htp.homework.entity;

public class StringEditor {

    public static String replaceSymbol(String sText, int iIndex, char cSymbol){
        StringBuilder sb = new StringBuilder();
        if(sText != null && sText.length() > 0 && iIndex > 0){
            for (String sWord : sText.split(" ")){
                if(sWord.length() >= iIndex){
                    sb.append(sWord.substring(0,iIndex - 1)).append(cSymbol).append(sWord.substring(iIndex, sWord.length()));
                } else {
                    sb.append(sWord);
                }
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
