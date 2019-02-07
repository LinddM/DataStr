public class Characters {

    public char character;
    public int repeatedTimes;
    public char [] collectedChars= new char[0];


    Characters [] dictionary(char [] chars){
        Characters [] noReps = new Characters[chars.length];
        for (int i=0; i<chardic(chars).length; i++){
            noReps[i].character=chardic(chars)[i];
            noReps[i].repeatedTimes=lookRepetitions(noReps[i].character, chars);
        }

        return noReps;
    }



    char [] chardic(char [] chars){
        char [] c= new char[1000];
        c[0]=chars[0];
        collectedChars=c;
        int count=0;
        for (int i=0; i<chars.length; i++){
            if (c[count]!=chars[i]){
                count++;
                c[count]=chars[i];
            }
        }
        char [] f = new char[count+1];
        for (int i=0; i<c.length; i++){
            if (c!=null){
                f[i]=c[i];
            }
        }
        collectedChars=f;
        return f;
    }

    boolean alreadythere(){
        return false;
    }


    int lookRepetitions(char c, char [] chars){
        int reps=0;
        for (int i=0; i<chars.length; i++){
            if (chars[i]==c){
                reps++;
            }
        }
        return reps;
    }


}