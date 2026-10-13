
import java.util.ArrayDeque;
import java.util.Deque;

class Dequeue{

    public static void revstring(String s){
        Deque<Character> dq=new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            dq.addFirst(ch);
        }
        while(!dq.isEmpty()){
            char a=dq.peek();
            dq.removeFirst();
            System.out.print(a);
        }
    }

    public static void pall(String s){
        Deque<Character> dq=new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            dq.addFirst(ch);
        }
        StringBuilder sb=new StringBuilder();
        while(!dq.isEmpty()){
            char a=dq.peek();
            dq.removeFirst();
            sb.append(a);
        }
        if(sb.toString().equals(s)){
            System.out.println("Pallindrome");
        }
        else{
            System.out.println("not pallindrome");
        }
    }

    public static void palli(String s){
        Deque<Character> dq=new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            dq.addLast(ch);
        }
        while(dq.size()>1){
            char x=dq.peekFirst();
            char y=dq.peekLast();
            if(x==y){
                dq.removeFirst();
                dq.removeLast();
            }
            else{
                System.out.println("False");
                return;
            }
        }
        System.out.println("True");
    }

    public static void main(String[] args) {
        Deque<Integer> q=new ArrayDeque<>();
        q.addFirst(1);
        q.addFirst(2);
        q.addFirst(3);
        System.out.println(q);
        q.addFirst(2);
        System.out.println(q);
        System.out.println("removing first");
        q.removeFirst();
        System.out.println(q);

        revstring("Hello world");
        System.out.println();
        pall("madamm"); 
        palli("madamji");
        

    }
}