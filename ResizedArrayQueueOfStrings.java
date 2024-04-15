public class ResizedArrayQueueOfStrings {
    public String[] s;
    public int N = 0;
    public int eqPos = 0;
    public int dqPos = 0;

    public ResizedArrayQueueOfStrings(){
        s = new String[1];
    }
    public boolean isEmpty(){
        return N == 0;
    }


    public void enqueue(String item){
        if (eqPos == s.length){
            resize((int) Math.pow(2, Math.ceil(Math.log(N+1) / Math.log(2))));
        }
        s[eqPos++] = item;
        N++;
    }
    private void resize(int capacity){
        String[] copy = new String[capacity];
        for (int i = 0; i < N; i++){
            copy[i] = s[dqPos+i];
        }
        s = copy;
        dqPos = 0;
        eqPos = N;
    }
    public String dequeue(){
        String item = s[dqPos];
        System.out.println(item);
        s[dqPos] = null;
        N--;
        dqPos++;
        if(dqPos < s.length && N == s.length/4){
            resize(s.length/2);
        }
        return item;
    }
}
