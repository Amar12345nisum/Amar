package org.example;

public class Mock
{
    private String text;
    private String text2;
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText2() {
        return text2;
    }

    public void setText2(String text2) {
        this.text2 = text2;
    }



    public Mock(String text,String text2)
    {
        setText(text);
        setText2(text2);

    }
}
