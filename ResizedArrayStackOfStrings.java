public class ResizedArrayStackOfStrings {
    public String[] s;
    public int N = 0;

    public ResizedArrayStackOfStrings(){
        s = new String[1];
    }
    public boolean isEmpty(){
        return N == 0;
    }
    public String peek(){
        if (N == 0) return null;
        return s[N-1];
    }
    public void resize(int capacity){
        String[] copy = new String[capacity];
        for (int i = 0; i < N; i++){
            copy[i] = s[i];
        }
        s = copy;
    }
    public void push(String item){
        if(N == s.length){
            resize(2 * s.length);
        }
        s[N++] = item;
    }
    public String pop(){
        if (N == 0) return null;
        String item = s[--N];
        s[N] = null;
        if(N > 0 && N == s.length/4){
            resize(s.length/2);
        }
        return item;
    }
}
