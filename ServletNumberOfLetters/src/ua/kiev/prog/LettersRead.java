package ua.kiev.prog;

import java.util.ArrayList;

public class LettersRead {
    private ArrayList<Letters> letList=new ArrayList<>();
    private String text;

    public LettersRead(String text) {
        super();
        this.text = text;
    }

    public ArrayList<Letters> calculateLetter() {
        ArrayList<Character>chList=new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            if (text.toUpperCase().charAt(i)>='A' && text.toUpperCase().charAt(i)<='Z') {
                chList.add(text.toUpperCase().charAt(i));
                continue;
            }
        }
        return numLetter(chList);
    }

    private ArrayList<Letters> numLetter(ArrayList<Character> ch) {
        int count =1;

        for (int i = 0; i < ch.size(); i++) {
            for (int k = i+1; k < ch.size(); k++) {
                if (ch.get(i)==ch.get(k)) {
                    count++;
                    ch.remove(k);
                    continue;
                }
            }
            addLetter(ch.get(i), count);
            count=1;
        }
        return letList;
    }

    private void addLetter(char ch, int num) {
        Letters let=new Letters(ch, num);
        if (letList.size()>0) {
            for (int i = 0; i < letList.size(); i++) {
                if (let.getNumber()>=letList.get(i).getNumber()) {
                    letList.add(i, let);
                    return;
                }
            }
            letList.add(let);
        } else if (letList.size()==0) {
            letList.add(let);
        }
    }
}
