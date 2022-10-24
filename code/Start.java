import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import java.io.File;
class Start {
    public static void main (String[] data) throws Exception {
        System.out.println("Welcome to Java");
        Engine e = new Engine();
        e.show();
        double total = e.getTotal(150);
        System.out.println(total);
        // learn read file 
        URL url = new URL("https://api.coinbase.com/v2/prices/BTC-USD/spot"); // have to throws Exception at method
        InputStream input = url.openStream();
        byte[] result = input.readAllBytes();
        for (int i = 0; i < result.length; i++) {
//            System.out.println(result[i]); // show byte
            System.out.print((char) result[i]);
        }
        System.out.print("\n");
        
        Scanner in = new Scanner(url.openStream());
        while (in.hasNextLine()){
            String s = in.nextLine();
            System.out.println(s);
        }
       System.out.print("\n");

        File f = new File("data.txt");
        Scanner in2 = new Scanner(f);
        while (in2.hasNextLine()) {
            String s = in2.nextLine();
            System.out.println(s);
        }
        
        System.out.println(e.check("NNEESWSW"));
        System.out.println(e.check("NESENN"));
        //  learn read file 
        
        // Linked List 
        Element el1 = new Element();
        el1.name = "David Beckham";
        System.out.println(el1);
        System.out.println(el1.next);
        
        Element el2 = new Element();
        el2.name = "Michael Owen";
        System.out.println(el2);
        System.out.println(el2.next);
        
        Element el3 = new Element();
        el3.name = "Frank Lampard";
        System.out.println(el3);
        System.out.println(el3.next);
        
        el1.next = el2; //set next address
        el2.next = el3;
        
        Element current = el1;
        while (current != null) {
            System.out.println(current.name);
            current = current.next;
        }
        // 
        
        // BlockChain 
        BackElement e1 = new BackElement ();
        e1.name = "David B";
        
        BackElement e2 = new BackElement();
        e2.name = "Michael O";
        e2.back = e1;
        
        BackElement e3 =  new BackElement();
        e3.name = "Frank L";
        e3.back = e2;
        
        BackElement e4 = new BackElement();
        e4.name = "Stephen G";
        e4.back = e3; 
        
        BackElement backCurrent = e4;
        
        //while style
        while (backCurrent != null) {
            System.out.println(backCurrent.name);
            backCurrent = backCurrent.back;
        }
        //for style
        for (BackElement xcurrent = e4; xcurrent != null; xcurrent = xcurrent.back) {
            System.out.println(xcurrent.name);
        }
        
        // BlockChain
        
        // create linkList 
        int[] a = {3,5,7,6,3,4,8};
        LinkedListEngine engine = new LinkedListEngine();
        Element first = engine.create(a);
        System.out.println(first.next.number);
        for (Element current3 = first; current3 != null ; current3 = current3.next) {
            System.out.println(current3.number);
        }

        
        
    }
}
class Engine {
    double getTotal (double price) {
        return price * 1.08;
    }
    void show() {
        System.out.println("Welcome to Engine");
    }
    boolean check(String s) {
        char[] charArray = s.toCharArray();
        int x = 0;
        int y = 0;
//        boolean result = true;
        for (char c : charArray) {
            if (c == 'N') y++;
            if (c == 'S') y--;
            if (c == 'E') x++;
            if (c == 'W') x--;
        }
//        if (x != 0) result = false;
//        if (y != 0) result = false;
//        return result;
        return x == 0 && y == 0;
               
    }
}

//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

class Element {
    String name;
    int number;
    double salary;
    Element next;
}

class BackElement {
    String name;
    int number;
    double salary;
    BackElement back;
}

class LinkedListEngine {
    Element create(int[] a) {
        Element head = null;
        Element tail = null;
        for (int i = 0; i < a.length; i++) {
            Element e = new Element();
            e.number = a[i];
            if (head == null) {
                head = e;
                tail = e;
            } else {
                tail.next = e;
                tail = e;
            }
        
        }
        return head;        
    }
    
}



