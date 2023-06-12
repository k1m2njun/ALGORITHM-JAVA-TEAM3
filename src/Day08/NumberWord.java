package Day08;
public class NumberWord {
    public static void main(String[] args) {
        String s = "one4seveneight";
        String[] word = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        for(int i=0; i<word.length; i++){
            if(s.contains(word[i])){ //s에 문자가 포함되있으면 인덱스값을 문자로 변환시켜 대체
                s = s.replace(word[i], Integer.toString(i));
            }
        }
        System.out.println(Integer.parseInt(s));
    }
}
