import java.util.ArrayList;

public class mazeProb {
    public static void main(String[] args) {
        System.out.println(maze(3,3));
        maze2("",3,3);
        System.out.println(maze3("", 3,3));
        System.out.println(maze4("", 3,3));
    }
    static int maze(int r, int c){
        if(r == 1 || c == 1)
        return 1;
      
        int right = maze(r-1,c);
        int left = maze(r, c-1);  
        
        return right+left;
    }
    static void maze2(String p, int r, int c){
       if (r == 1 && c == 1){
           System.out.println(p);
           return;
       }
       if( r > 1){
        maze2(p+'D', r - 1, c);
       }
     if( c > 1){
        maze2(p + 'R', r, c-1);
     }
       
    }
     static ArrayList<String> maze3(String p, int r, int c){
       if (r == 1 && c == 1){
           ArrayList<String> list = new ArrayList<String>();
           list.add(p);
           return list;
       }
       ArrayList<String> list = new ArrayList<String>();

       if( r > 1){
        list.addAll(maze3(p+'D', r - 1, c));
       }
     if( c > 1){
        list.addAll(maze3(p + 'R', r, c-1));
     }
       return list;
    }


     static ArrayList<String> maze4(String p, int r, int c){
       if (r == 1 && c == 1){
           ArrayList<String> list = new ArrayList<String>();
           list.add(p);
           return list;
       }
       ArrayList<String> list = new ArrayList<String>();

       if( r > 1 && c > 1){
        list.addAll(maze4(p+'d', r - 1, c-1));}

       if( r > 1){
        list.addAll(maze4(p+'D', r - 1, c));
       }
     if( c > 1){
        list.addAll(maze4(p + 'R', r, c-1));
     }
       return list;
    
    
    }
  
}
