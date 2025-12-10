package strings;
import java.util.*;

class solution{

    public String encode(List<String> strs){
        if(strs.size() == 0){
            return Character.toString((char)258);
        }
        StringBuilder sb = new StringBuilder();
        String key = Character.toString((char)257);
        for(String str : strs){
            sb.append(str);
            sb.append(key);
        }
        sb.deleteCharAt(sb.length()-1); //remove the last #
        return sb.toString();
    }

    public List<String> decode(String str){
        if(str.equals(Character.toString((char)258))){
            return new ArrayList<>();
        }
        String key = Character.toString((char)257);
        return Arrays.asList(str.split(key, -1)); // -1 to handle the case where the last string is empty, otherwise the emtpy string is not included
    }
}
